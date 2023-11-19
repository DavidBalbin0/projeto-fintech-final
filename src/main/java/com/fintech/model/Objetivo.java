package com.fintech.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Objetivo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	private double saldo;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFinal;
	private double objetivo;
	private Conta conta;
	private boolean vinculadoSaldoConta = true;
	
	public Objetivo(String descricao, LocalDateTime dataInicio, LocalDateTime dataFinal, double objetivo, Conta conta, double saldoInicial, boolean vinculadoSaldoConta) {
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.vinculadoSaldoConta = vinculadoSaldoConta;
		this.descricao = descricao;
		this.objetivo = objetivo;
		this.conta = conta;
		depositarValor(saldoInicial);
	}

	public Objetivo(Long id, String descricao, LocalDateTime dataInicio, LocalDateTime dataFinal, double objetivo, Conta conta, double saldoInicial, boolean vinculadoSaldoConta) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.vinculadoSaldoConta = vinculadoSaldoConta;
		this.descricao = descricao;
		this.objetivo = objetivo;
		this.conta = conta;
		depositarValor(saldoInicial);
	}

	public void depositarValor(double valor){
		if(vinculadoSaldoConta){
			conta.adicionarValor(valor);
		}
		saldo += valor;
	}

	public void retirarValor (double valor){
		if(vinculadoSaldoConta){
			conta.adicionarValor(valor);
		}
		saldo -= valor;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getObjetivo() {
		return objetivo;
	}

	public Conta getConta() {
		return conta;
	}

	@Override
	public String toString() {
		return "Investimento{" +
				"id=" + id +
				", descricao='" + descricao + '\'' +
				", saldo=" + saldo +
				", meta=" + objetivo +
				", conta=" + conta +
				", vinculadoSaldoConta=" + vinculadoSaldoConta +
				'}';
	}
}
