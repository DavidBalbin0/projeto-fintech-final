package com.fintech.servlets;

import com.fintech.dto.ObjetivoDto;
import com.fintech.dto.ReceitaDto;
import com.fintech.model.Conta;
import com.fintech.model.Objetivo;
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
@WebServlet("/restrito/objetivos")
public class ObjetivosServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");

        UsuarioService usuarioService = new UsuarioService();
        ContaService contaService = new ContaService();

        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);

        List<Objetivo> objetivos =  contaService.pegarObjetivos(usuario);

        request.setAttribute("objetivos", objetivos);
        request.setAttribute("nome", usuario.getNome());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/objetivos.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");

        String descricao = request.getParameter("descricao");
        String valorString = request.getParameter("valor");
        String dataInicioString =request.getParameter("dataInicio");
        String dataFinalString = request.getParameter("dataFinal");
        String metaString = request.getParameter("meta");


        BigDecimal bigDecimal = new BigDecimal(valorString);
        double valor = bigDecimal.doubleValue();

        bigDecimal = new BigDecimal(metaString);
        double meta = bigDecimal.doubleValue();

        LocalDate dataInicio;
        LocalDate dataFinal;
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dataInicio = LocalDate.parse(dataInicioString, formatador);
            dataFinal = LocalDate.parse(dataFinalString, formatador);
        }catch (DateTimeParseException e){
            dataInicio = LocalDate.now();
            dataFinal = LocalDate.now();
        }
        UsuarioService usuarioService = new UsuarioService();
        ContaService contaService = new ContaService();

        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);
        Conta conta = contaService.buscarContaPorUsuarioId(usuario.getId());


        ObjetivoDto objetivoDto = new ObjetivoDto(descricao, valor, dataInicio, dataFinal, meta,  conta.getId());
//        ValidadorObjetivoService validadorObjetivosService = new ValidadorObjetivoService();
        HashMap<String, String> erros = new HashMap<String, String>();
//        validadorObjetivosService.validar(objetivoDto, erros);


        if (erros.isEmpty()){
            Objetivo objetivo = contaService.cadastrarObjetivo(objetivoDto);

            response.sendRedirect(request.getContextPath() + "/restrito/objetivos");
        }else {
            request.setAttribute("erros", erros);
            response.sendRedirect(request.getContextPath() + "/restrito/objetivos");
        }
    }
}
