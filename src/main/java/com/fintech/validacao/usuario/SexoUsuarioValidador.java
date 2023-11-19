package com.fintech.validacao.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fintech.dto.UsuarioDto;
import com.fintech.teste.Sexo;
import com.fintech.validacao.Validador;


public class SexoUsuarioValidador implements Validador<UsuarioDto>{
	@Override
	public void validate(UsuarioDto usuario, HashMap<String, String> erros) {
		String sexo = usuario.getSexo();
		System.out.println(sexo);

		try {

			Sexo.valueOf(sexo.toUpperCase());
		} catch (IllegalArgumentException e) {
			erros.put("sexo", "O sexo inserido é inválido");
		}
	}
}
		