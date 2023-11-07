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

	public void sacarValor(double valor){
		if (valor < saldo) {
			saldo -= valor;
		}
	}

	public void depositarValor(double valor){
		saldo += valor;
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

	@Override
	public String toString() {
		return "Conta{" +
				"id='" + id + '\'' +
				", nome='" + nome + '\'' +
				", saldo=" + saldo +
				", usuarioId='" + usuarioId + '\'' +
				'}';
	}
}
