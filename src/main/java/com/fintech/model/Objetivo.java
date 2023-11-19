package com.fintech.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Objetivo implements Serializable, Comparable<Objetivo> {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	private double saldo;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private double meta;
	private double progresso;
	private Long contaId;

	public Objetivo(Long id, String descricao, double saldo, LocalDate dataInicio, LocalDate dataFinal, double meta, double progresso, Long contaId) {
		this.id = id;
		this.descricao = descricao;
		this.saldo = saldo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.meta = meta;
		this.progresso = calcularProgressao();
		this.contaId = contaId;
	}

	public Objetivo(String descricao, double saldo, LocalDate dataInicio, LocalDate dataFinal, double meta, Long contaId) {
		this.descricao = descricao;
		this.saldo = saldo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.meta = meta;
		this.progresso = calcularProgressao();
		this.contaId = contaId;
	}

	private double calcularProgressao() {
		if (meta != 0) {
			return (saldo / meta) * 100.0;
		} else {
			return 0.0; // lidar com o caso em que a meta é zero para evitar divisão por zero
		}
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getSaldo() {
		return saldo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public double getMeta() {
		return meta;
	}

	public double getProgresso() {
		return progresso;
	}

	public Long getContaId() {
		return contaId;
	}

	@Override
	public int compareTo(Objetivo outroObjetivo) {
		return this.dataFinal.compareTo(outroObjetivo.dataFinal);
	}

	public void adicionarSaldo(double saldo) {
		this.saldo += saldo;
	}
}
