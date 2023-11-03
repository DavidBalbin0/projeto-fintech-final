package com.fintech.validacao.usuario;

import java.util.regex.Pattern;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;
import com.fintech.validacao.ValidadorException;

public class NomeUsuarioValidador implements Validador<UsuarioDto> {

	@Override
	public void validate(UsuarioDto usuario) throws ValidadorException {
		String nome = usuario.getNome();
		if(nome.isBlank()) {
			throw new ValidadorException("O nome de usuário não pode ser nulo ou vazio");
		}
		
		if (!isNomeValido(nome)) {
			throw new ValidadorException("O nome de usuário inserido não é valido");
		}
	}
	
	private boolean isNomeValido(String nome) {
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(nome).matches();
    }

}

