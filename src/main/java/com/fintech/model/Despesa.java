package com.fintech.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Despesa extends Transacao{

	public Despesa(String descricao, String categoria, LocalDateTime data, String contaId) {
		super(descricao, categoria, data, contaId);
		// TODO Auto-generated constructor stub
	}

}
