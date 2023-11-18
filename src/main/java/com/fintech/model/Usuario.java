package com.fintech.model;

import com.fintech.teste.Sexo;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.UUID;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private byte[] foto;
	private String nome;
	private LocalDateTime dataNasc;
	private Sexo sexo;
	private String email;
	private String senha;

	public Usuario(byte[] foto, String nome, LocalDateTime dataNasc, Sexo sexo, String email, String senhaSimples) {
		this.foto = foto;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.email = email;
		this.senha = senhaSimples;
	}

	public Usuario(Long id, byte[] foto, String nome, LocalDateTime dataNasc, Sexo sexo, String email, String senhaSimples) {
		this.id = id;
		this.foto = foto;
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


	public byte[] getFoto() {
		return foto;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getDataNasc() {
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
		return "Usuario [id=" + id + ", foto=" + foto + ", nome=" + nome + ", dataNasc=" + dataNasc + ", sexo=" + sexo
				+ ", email=" + email + " senha= " + senha + "]";
	}
}
