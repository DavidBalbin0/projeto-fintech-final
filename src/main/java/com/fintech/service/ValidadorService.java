package com.fintech.service;

import java.util.ArrayList;
import java.util.List;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;
import com.fintech.validacao.ValidadorException;
import com.fintech.validacao.usuario.EmailUsuarioValidador;
import com.fintech.validacao.usuario.NomeUsuarioValidador;

public class ValidadorService {
	private List<Validador<UsuarioDto>> validadores = new ArrayList<Validador<UsuarioDto>>();
	
	public ValidadorService() {
		validadores.add(new NomeUsuarioValidador());
		validadores.add(new EmailUsuarioValidador());
	}
	
	public void validate(UsuarioDto usuarioDto) throws ValidadorException{
		for (Validador<UsuarioDto> validator: validadores) {
			validator.validate(usuarioDto);
		}
	}
}
