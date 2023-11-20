package com.fintech.servlets;

import com.fintech.model.Usuario;
import com.fintech.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/excluir-usuario")
public class ExcluirUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");
        UsuarioService usuarioService = new UsuarioService();
        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);
        usuarioService.excluirUsuarioAndDependentes(usuario);

        response.sendRedirect(request.getContextPath() + "/login");
    }
}