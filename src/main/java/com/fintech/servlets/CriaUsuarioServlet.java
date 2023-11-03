package com.fintech.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fintech.dto.UsuarioDto;
import com.fintech.service.ValidadorService;
import com.fintech.validacao.ValidadorException;

@WebServlet("/cria-usuario")
public class CriaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String foto = request.getParameter("foto");
		String dataNasc = request.getParameter("dataNasc");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		UsuarioDto usuarioDto = new UsuarioDto(foto, nome, null, sexo, email, senha);
		
		ValidadorService validadorService = new ValidadorService();
		
		try {
			validadorService.validate(usuarioDto);
		} catch (ValidadorException erro) {
			
		}
	}
}
