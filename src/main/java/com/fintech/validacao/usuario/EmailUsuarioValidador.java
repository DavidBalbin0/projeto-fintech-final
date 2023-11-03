package com.fintech.validacao.usuario;

import java.util.regex.Pattern;
import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;
import com.fintech.validacao.ValidadorException;

public class EmailUsuarioValidador implements Validador<UsuarioDto> {

	@Override
	public void validate(UsuarioDto usuario) throws ValidadorException {
		String email = usuario.getEmail();
		if (email.isBlank()) {
			throw new ValidadorException("O email nao pode ser nulo ou vazio");
		}
		
		if (!isEmailValido(email)) {
			throw new ValidadorException("O email inserido não é valido");
		}
		
	}
	
	private boolean isEmailValido(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(email).matches();
	}

}
