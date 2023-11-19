package com.fintech.model;

import java.time.LocalDate;

public class Receita extends Transacao {

	public Receita(String descricao, double valor, LocalDate data, Long contaId) {
		super(descricao, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}
	public Receita(Long id, String descricao, double valor, LocalDate data, Long contaId) {
		super(id, descricao, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}

}
