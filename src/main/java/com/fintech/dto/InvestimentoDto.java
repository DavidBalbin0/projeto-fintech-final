package com.fintech.dto;

import com.fintech.model.Conta;

import java.time.LocalDateTime;

public class InvestimentoDto {
    private Conta contaId;
    private String descricao;
    private double saldo;

    private double meta;
    private boolean vinculadoSaldoConta = true;

    public InvestimentoDto (String descricao, double saldo, double meta, Conta contaId, boolean vinculadoSaldoConta){
        this.meta = meta;
        this.contaId = contaId;
        this.descricao = descricao;
        this.saldo = saldo;
        this.vinculadoSaldoConta = vinculadoSaldoConta;
    }

    public Long getContaId() {
        return contaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getMeta() {
        return meta;
    }

    public boolean isVinculadoSaldoConta() {
        return vinculadoSaldoConta;
    }
}
