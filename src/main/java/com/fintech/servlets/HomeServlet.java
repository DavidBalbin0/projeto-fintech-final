package com.fintech.servlets;

import com.fintech.dao.ReceitaDAO;
import com.fintech.dto.ReceitaDto;
import com.fintech.model.Conta;
import com.fintech.model.Receita;
import com.fintech.model.Transacao;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/restrito/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");

        UsuarioService usuarioService = new UsuarioService();
        ContaService contaService = new ContaService();

        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);
        List<Transacao> transacoes = new ArrayList<>();
        try {
            transacoes =  contaService.pegarAndOrdenarTransacoesRecente(usuario);
        }catch (NullPointerException e){
            request.setAttribute("erro", "Sem transacoes recentes");
        }

        request.setAttribute("trasacoes", transacoes);
        request.setAttribute("nome", usuario.getNome());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(request, response);
    }




}
