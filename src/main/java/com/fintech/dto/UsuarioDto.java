package com.fintech.dto;

import java.time.LocalDateTime;

public class UsuarioDto {
	private byte[] foto;
	private String nome;
	private LocalDateTime dataNasc;
	private String sexo;
	private String email;
	private String senha;
	
	public UsuarioDto(byte[] foto, String nome, LocalDateTime dataNasc, String sexo, String email, String senha) {
		super();
		this.foto = foto;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
	}

	public byte[] getFoto() {
		return foto;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getDataNasc() {
		return dataNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	
}
