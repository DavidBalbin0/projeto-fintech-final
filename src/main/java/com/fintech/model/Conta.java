package com.fintech.model;

import java.io.Serializable;
import java.util.UUID;

public class Conta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private double saldo;
	private String usuarioId;
	
	public Conta (String nome, double saldo, String usuarioId) {
		
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
		this.saldo = saldo;
		this.usuarioId = usuarioId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getUsuarioId() {
		return usuarioId;
	}
	

}
