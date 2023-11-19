package com.fintech.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioDto {
	private String nome;
	private LocalDate dataNasc;
	private String sexo;
	private String email;
	private String senha;
	
	public UsuarioDto(String nome, LocalDate dataNasc, String sexo, String email, String senha) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNasc() {
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




	public void setSenha(String senhaEncriptada) {
		this.senha = senhaEncriptada;
	}

	@Override
	public String toString() {
		return "UsuarioDto{" +
				"nome='" + nome + '\'' +
				", dataNasc=" + dataNasc +
				", sexo='" + sexo + '\'' +
				", email='" + email + '\'' +
				", senha='" + senha + '\'' +
				'}';
	}
}
