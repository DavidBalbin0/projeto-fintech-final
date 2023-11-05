package com.fintech.validacao.usuario;

import java.util.HashMap;
import java.util.regex.Pattern;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;

public class NomeUsuarioValidador implements Validador<UsuarioDto> {
	@Override
	public void validate(UsuarioDto usuario, HashMap<String, String> erros) {
		// TODO Auto-generated method stub
		
		String nome = usuario.getNome();
		if(nome.isBlank()) {
			erros.put("nome","O nome de usuário não pode ser nulo ou vazio");
		}
		
		if (!isNomeValido(nome)) {
			erros.put("nome","O nome de usuário inserido não é valido");
		}
	}
	private boolean isNomeValido(String nome) {
		String regex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(nome).matches();
	}

}

