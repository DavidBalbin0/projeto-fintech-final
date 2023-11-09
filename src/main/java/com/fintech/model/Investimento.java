package com.fintech.model;

import java.io.Serializable;
import java.util.UUID;

public class Investimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String descricao;
	private double saldo;

	private double meta;
	private Conta conta;

	private boolean vinculadoSaldoConta = true;
	
	public Investimento(String descricao, double meta, Conta conta, double saldoInicial, boolean vinculadoSaldoConta) {
		this.vinculadoSaldoConta = vinculadoSaldoConta;
		this.id = UUID.randomUUID().toString();
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
	public String getId() {
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
