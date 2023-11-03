package com.fintech.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String foto;
	private String nome;
	private Timestamp dataNasc;
	private String sexo;
	private String email;
	private String senha;
	
	public Usuario(String foto, String nome, Timestamp dataNasc, String sexo, String email, String senha) {
		this.id = UUID.randomUUID().toString();
		this.foto = foto;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public String getFoto() {
		return foto;
	}

	public String getNome() {
		return nome;
	}

	public Timestamp getDataNasc() {
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", foto=" + foto + ", nome=" + nome + ", dataNasc=" + dataNasc + ", sexo=" + sexo
				+ ", email=" + email + "]";
	}
	
	
	
	
}
