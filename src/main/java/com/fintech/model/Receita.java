package com.fintech.model;

import java.time.LocalDateTime;

public class Receita extends Transacao {

	public Receita(String descricao, String categoria, double valor, LocalDateTime data, String contaId) {
		super(descricao, categoria, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}

}
