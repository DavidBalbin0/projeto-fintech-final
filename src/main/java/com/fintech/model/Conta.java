package com.fintech.model;

import java.io.Serializable;
import java.util.UUID;

public class Conta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private double saldo;
	private Long usuarioId;
	
	public Conta (String nome, double saldoInicial, Long usuarioId) {
		
		this.id =usuarioId;
		this.nome = nome;
		this.saldo = saldoInicial;
		this.usuarioId = usuarioId;
	}

	public Conta (Long id, String nome, double saldoInicial, Long usuarioId) {
		this.id = id;
		this.nome = nome;
		this.saldo = saldoInicial;
		this.usuarioId = usuarioId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void adicionarValor(double valor) {
			saldo += valor;
	}

	public Long getId() { return id; }

	public String getNome() {
		return nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public Long getUsuarioId() { return usuarioId; }

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
