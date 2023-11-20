package com.fintech.servlets;

import com.fintech.dto.ReceitaDto;
import com.fintech.model.Conta;
import com.fintech.model.Receita;
import com.fintech.model.Usuario;
import com.fintech.service.ContaService;
import com.fintech.service.UsuarioService;
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
@WebServlet("/restrito/receitas")
public class ReceitaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");

        UsuarioService usuarioService = new UsuarioService();
        ContaService contaService = new ContaService();

        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);

        List<Receita> receitas =  contaService.pegarReceitas(usuario);

        request.setAttribute("receitas", receitas);
        request.setAttribute("nome", usuario.getNome());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/receitas.jsp");
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


        ReceitaDto receitaDto = new ReceitaDto(descricao, valor, data, conta.getId());
        ValidadorReceitaService validadorReceitaService = new ValidadorReceitaService();
        HashMap<String, String> erros = new HashMap<String, String>();
        validadorReceitaService.validar(receitaDto, erros);


        if (erros.isEmpty()){
            Receita receita = contaService.cadastrarReceita(receitaDto);

            response.sendRedirect(request.getContextPath() + "/restrito/receitas");
        }else {
            request.setAttribute("erros", erros);
            response.sendRedirect(request.getContextPath() + "/restrito/receitas");
        }
    }
}
