package com.fintech.servlets;


import com.fintech.dto.UsuarioDto;
import com.fintech.service.UsuarioService;
import com.fintech.service.ValidadorUsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


@MultipartConfig
public class CriaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/registro.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		Part fotoPart = request.getPart("foto");
		String dataNasc = request.getParameter("dataNasc");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		InputStream fotoInputStream = fotoPart.getInputStream();
		byte[] fotoBytes = fotoInputStream.readAllBytes();

		UsuarioDto usuarioDto = new UsuarioDto(fotoBytes, nome, null, sexo, email, senha);
		HashMap<String, String> erros = new HashMap<String, String>();

		ValidadorUsuarioService validadorService = new ValidadorUsuarioService();

		validadorService.validar(usuarioDto, erros);
		if(!erros.isEmpty()){
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("/jsp/registro.jsp").forward(request, response);
		} else {

			UsuarioService usuarioService = new UsuarioService();
			usuarioService.cadastrar(usuarioDto);

			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		}


		
	}


}
