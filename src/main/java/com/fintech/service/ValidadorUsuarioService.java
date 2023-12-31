package com.fintech.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;

import com.fintech.validacao.usuario.*;


public class ValidadorUsuarioService {
	private List<Validador<UsuarioDto>> validadores = new ArrayList<Validador<UsuarioDto>>();

	public ValidadorUsuarioService() {
		validadores.add(new NomeUsuarioValidador());
		validadores.add(new EmailUsuarioValidador());
		validadores.add(new SenhaUsuarioValidador());
		validadores.add(new SexoUsuarioValidador());
		validadores.add(new DataNascValidador());
	}

	public void validar(UsuarioDto usuarioDto, HashMap<String, String> erros) {

		for (Validador<UsuarioDto> validator: validadores) {
			validator.validate(usuarioDto, erros);
		}
	}
}
