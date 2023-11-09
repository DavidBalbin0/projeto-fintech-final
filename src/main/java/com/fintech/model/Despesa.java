package com.fintech.model;

import java.time.LocalDateTime;

public class Despesa extends Transacao{

	public Despesa(String descricao, String categoria, double valor, LocalDateTime data, String contaId) {
		super(descricao, categoria, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}

}
