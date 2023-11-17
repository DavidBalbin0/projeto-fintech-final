package com.fintech.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Transacao {
	
	private Long id;
	private String descricao;
	private String categoria;

	private double valor ;
	private LocalDateTime data;
	private Long contaId;
	
	public Transacao (String descricao, String categoria, double valor, LocalDateTime data, Long contaId) {

		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.contaId = contaId;
		this.valor = valor;
	}
	public Transacao (Long id, String descricao, String categoria, double valor, LocalDateTime data, Long contaId) {
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.contaId = contaId;
		this.valor = valor;
	}
	
	public Long getId() {
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

	public double getValor() {
		return valor;
	}
}
