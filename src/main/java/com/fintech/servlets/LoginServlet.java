package com.fintech.servlets;

import com.fintech.dto.UsuarioDto;
import com.fintech.dto.UsuarioLoginDto;
import com.fintech.service.UsuarioService;
import com.fintech.service.ValidadorUsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioService usuarioService = new UsuarioService();
        UsuarioLoginDto usuarioLoginDto = new UsuarioLoginDto(email, senha);


        boolean usuarioValidado = usuarioService.validaLoginUsuario(usuarioLoginDto);

        if (usuarioValidado){
            //colocar uma forma de armazenamento para guardar as credenciais
            HttpSession sessao = request.getSession(true);
            sessao.setAttribute("usuarioLogado", email);



            response.sendRedirect(request.getContextPath() + "/jsp/home.jsp");
        } else{
            request.setAttribute("erro", "Email ou senha inválidos");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }



    }

}
