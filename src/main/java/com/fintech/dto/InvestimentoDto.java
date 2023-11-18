package com.fintech.dto;

import com.fintech.model.Conta;

import java.time.LocalDateTime;

public class InvestimentoDto {

    private String descricao;
    private double saldo;

    private double meta;
    private boolean vinculadoSaldoConta = true;
    private Long contaId;

    public InvestimentoDto (String descricao, double saldo, double meta, boolean vinculadoSaldoConta, Long contaId){
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
