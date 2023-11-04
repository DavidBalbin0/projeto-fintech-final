package com.fintech.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;

import com.fintech.validacao.usuario.EmailUsuarioValidador;
import com.fintech.validacao.usuario.NomeUsuarioValidador;
import com.fintech.validacao.usuario.SexoUsuarioValidador;

public class ValidadorService {
	private List<Validador<UsuarioDto>> validadores = new ArrayList<Validador<UsuarioDto>>();
	
	public ValidadorService() {
		validadores.add(new NomeUsuarioValidador());
		validadores.add(new EmailUsuarioValidador());
		validadores.add(new SexoUsuarioValidador());
	}
	
	public void validate(UsuarioDto usuarioDto, HashMap<String, String> erros) {
		
		for (Validador<UsuarioDto> validator: validadores) {
			validator.validate(usuarioDto, erros);
		}
	}
}
