package com.fintech.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Receita extends Transacao {

	public Receita(String descricao, String categoria, LocalDateTime data, String contaId) {
		super(descricao, categoria, data, contaId);
		// TODO Auto-generated constructor stub
	}

}
