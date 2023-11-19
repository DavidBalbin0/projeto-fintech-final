package com.fintech.servlets;

import com.fintech.model.Objetivo;
import com.fintech.model.Usuario;
import com.fintech.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ObjetivosServlet extends HttpServlet {
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession sessao = request.getSession(true);
//        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");
//
//        UsuarioService usuarioService = new UsuarioService();
//
//        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);
//
//        List<Objetivo> objetivos =  usuarioService.pegarObjetivos(usuario);
//
//        request.setAttribute("objetivos", objetivos);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/home.jsp");
//        dispatcher.forward(request, response);
//    }
}
