package com.fintech.model;

import java.io.Serializable;
import java.util.UUID;

public class Investimentos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String descricao;
	private String meta;
	private String contaId;
	
	public Investimentos(String descricao, String meta, String contaId) {
		
		this.id = UUID.randomUUID().toString();
		this.descricao = descricao;
		this.meta = meta;
		this.contaId = contaId;
	}
	
	public String getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getMeta() {
		return meta;
	}

	public String getContaId() {
		return contaId;
	}
	
}
