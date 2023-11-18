package com.fintech.model;

import java.io.Serializable;
import java.util.UUID;

public class Investimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	private double saldo;

	private double meta;
	private Conta conta;

	private boolean vinculadoSaldoConta = true;
	
	public Investimento(String descricao, double meta, Conta conta, double saldoInicial, boolean vinculadoSaldoConta) {
		this.vinculadoSaldoConta = vinculadoSaldoConta;
		this.descricao = descricao;
		this.meta = meta;
		this.conta = conta;
		depositarValor(saldoInicial);
	}

	public Investimento(Long id, String descricao, double meta, Conta conta, double saldoInicial, boolean vinculadoSaldoConta) {
		this.id = id;
		this.vinculadoSaldoConta = vinculadoSaldoConta;
		this.descricao = descricao;
		this.meta = meta;
		this.conta = conta;
		depositarValor(saldoInicial);
	}

	public void depositarValor(double valor){
		if(vinculadoSaldoConta){
			conta.sacarValor(valor);
		}
		saldo += valor;
	}

	public void retirarValor (double valor){
		if(vinculadoSaldoConta){
			conta.depositarValor(valor);
		}
		saldo -= valor;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getMeta() {
		return meta;
	}

	public Conta getConta() {
		return conta;
	}


}
