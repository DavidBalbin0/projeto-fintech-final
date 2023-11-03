package com.fintech.model;

import java.security.Timestamp;
import java.util.UUID;

public abstract class Transacao {
	
	private String id;
	private String descricao;
	private String categoria;
	private Timestamp data;
	private String contaId;
	
	public Transacao (String descricao, String categoria, Timestamp data, String contaId) {
		
		this.id = UUID.randomUUID().toString();
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.contaId = contaId;
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
	
	public Timestamp getData() {
		return data;
	}
	
	public String getContaId() {
		return contaId;
	}
}
