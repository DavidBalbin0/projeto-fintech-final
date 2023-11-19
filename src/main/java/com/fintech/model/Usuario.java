package com.fintech.model;

import com.fintech.teste.Sexo;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private LocalDate dataNasc;
	private Sexo sexo;
	private String email;
	private String senha;

	public Usuario(String nome, LocalDate dataNasc, Sexo sexo, String email, String senhaSimples) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.email = email;
		this.senha = senhaSimples;
	}

	public Usuario(Long id, String nome, LocalDate dataNasc, Sexo sexo, String email, String senhaSimples) {
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.email = email;
		this.senha = senhaSimples;
	}


	public Long getId() {
		return id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getNome() {
		return nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public Sexo getSexo() {
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
		return "Usuario [id=" + id + ", nome=" + nome + ", dataNasc=" + dataNasc + ", sexo=" + sexo
				+ ", email=" + email + " senha= " + senha + "]";
	}
}
