package com.fintech.validacao.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;


public class SexoUsuarioValidador implements Validador<UsuarioDto>{
	private List<String> sexos = new ArrayList<>();
	
	public SexoUsuarioValidador() {
		sexos.add("masculino");
		sexos.add("Feminino");
		sexos.add("Outro");
	}
	
	@Override
	public void validate(UsuarioDto usuario, HashMap<String, String> erros){
		
		
		if (!sexos.contains(usuario.getSexo())) {
		erros.put("sexo","O sexo inserido é inválido");
		}
	}
}
		