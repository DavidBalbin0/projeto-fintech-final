package com.fintech.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Transacao {
	
	private String id;
	private String descricao;
	private String categoria;

	private double valor ;
	private LocalDateTime data;
	private String contaId;
	
	public Transacao (String descricao, String categoria, double valor, LocalDateTime data, String contaId) {


		this.id = UUID.randomUUID().toString();
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.contaId = contaId;
		this.valor = valor;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public String getContaId() {
		return contaId;
	}

	public double getValor() {
		return valor;
	}
}
