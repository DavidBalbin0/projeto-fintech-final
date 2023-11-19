package com.fintech.model;

import java.time.LocalDate;

public class Despesa extends Transacao{

	public Despesa(String descricao, double valor, LocalDate data, Long contaId) {
		super(descricao, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}
	public Despesa(Long id, String descricao, double valor, LocalDate data, Long contaId) {
		super(id, descricao, valor, data, contaId);
		// TODO Auto-generated constructor stub
	}



}
