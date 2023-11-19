package com.fintech.validacao.usuario;

import java.util.HashMap;
import java.util.regex.Pattern;
import com.fintech.dto.UsuarioDto;
import com.fintech.service.UsuarioService;
import com.fintech.validacao.Validador;


public class EmailUsuarioValidador implements Validador<UsuarioDto> {

	UsuarioService usuarioService = new UsuarioService();
	@Override
	public void validate(UsuarioDto usuario, HashMap<String, String> erros) {
		// TODO Auto-generated method stub
		
		String email = usuario.getEmail();
		if (email.isBlank()) {
			erros.put("email","O email nao pode ser nulo ou vazio");
		}
		
		if (!isEmailValido(email)) {
			erros.put("email","O email inserido não é valido");
		}

		if (isEmailExistente(email)){
			erros.put("email","O email já existe no sistema");
		}
	}

	private boolean isEmailValido(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(email).matches();
	}

	private boolean isEmailExistente(String email) {
        return usuarioService.buscarPorEmail(email) != null;
	}


}
