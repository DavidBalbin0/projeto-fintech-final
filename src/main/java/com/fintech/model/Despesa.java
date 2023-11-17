package com.fintech.model;

import java.time.LocalDateTime;

public class Despesa extends Transacao{

	public Despesa(String descricao, String categoria, double valor, LocalDateTime data, Long contaId) {
		super(descricao, categoria, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}
	public Despesa(Long id, String descricao, String categoria, double valor, LocalDateTime data, Long contaId) {
		super(id, descricao, categoria, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}

}
