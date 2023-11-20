package com.fintech.servlets;

import com.fintech.dto.DespesaDto;
import com.fintech.dto.ReceitaDto;
import com.fintech.model.Conta;
import com.fintech.model.Despesa;
import com.fintech.model.Receita;
import com.fintech.model.Usuario;
import com.fintech.service.ContaService;
import com.fintech.service.UsuarioService;
import com.fintech.service.ValidadorDespesaService;
import com.fintech.service.ValidadorReceitaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
@WebServlet("/restrito/despesas")
public class DespesaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");

        UsuarioService usuarioService = new UsuarioService();
        ContaService contaService = new ContaService();

        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);

        List<Despesa> despesas =  contaService.pegarDespesas(usuario);

        HashMap<String, String> erros = (HashMap<String, String>) sessao.getAttribute("erros");
        if (erros != null) {
            // Remove os erros da sessão
            sessao.removeAttribute("erros");
        }
        System.out.println(erros);
        request.setAttribute("erros", erros);
        request.setAttribute("despesas", despesas);
        request.setAttribute("nome", usuario.getNome());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/despesas.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");

        String descricao = request.getParameter("descricao");
        String valorString = request.getParameter("valor");
        String dataString =request.getParameter("data");

        BigDecimal bigDecimal = new BigDecimal(valorString);
        double valor = bigDecimal.doubleValue();

        LocalDate data;
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            data = LocalDate.parse(dataString, formatador);
        }catch (DateTimeParseException e){
            data = LocalDate.now();
        }
        UsuarioService usuarioService = new UsuarioService();
        ContaService contaService = new ContaService();

        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);
        Conta conta = contaService.buscarContaPorUsuarioId(usuario.getId());


        DespesaDto despesaDto = new DespesaDto(descricao, valor, data, conta.getId());
        ValidadorDespesaService validadorDespesaService = new ValidadorDespesaService();
        HashMap<String, String> erros = new HashMap<String, String>();
        validadorDespesaService.validar(despesaDto, erros);


        if (erros.isEmpty()){
            Despesa despesa = contaService.cadastrarDespesa(despesaDto);

            response.sendRedirect(request.getContextPath() + "/restrito/despesas");
        }else {
            HttpSession session = request.getSession(true);
            session.setAttribute("erros", erros);
            response.sendRedirect(request.getContextPath() + "/restrito/despesas");
        }
    }
}
