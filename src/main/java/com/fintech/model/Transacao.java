package com.fintech.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Transacao implements Comparable<Transacao>  {
	
	private Long id;
	private String descricao;
	private double valor ;
	private LocalDate data;
	private Long contaId;
	
	public Transacao (String descricao, double valor, LocalDate data, Long contaId) {

		this.descricao = descricao;
		this.data = data;
		this.contaId = contaId;
		this.valor = valor;
	}
	public Transacao (Long id, String descricao, double valor, LocalDate data, Long contaId) {
		this.id = id;
		this.descricao = descricao;
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

	
	public LocalDate getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public Long getContaId() {
		return contaId;
	}

	@Override
	public int compareTo(Transacao outraTrasacao) {
		return this.data.compareTo(outraTrasacao.data);
	}

	@Override
	public String toString() {
		return "Transacao{" +
				"id=" + id +
				", descricao='" + descricao + '\'' +
				", valor=" + valor +
				", data=" + data +
				", contaId=" + contaId +
				'}';
	}
}
