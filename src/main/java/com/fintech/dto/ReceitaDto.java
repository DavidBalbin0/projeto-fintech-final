package com.fintech.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReceitaDto {

    private double valor;
    private String descricao;
    private LocalDate data;
    private final Long contaId;

    public ReceitaDto (String descricao, double valor, LocalDate data, Long contaId) {

        this.valor = normalizaValor(valor);
        this.descricao = descricao;
        this.data = data;
        this.contaId = contaId;

    }

    private double normalizaValor(double valorInserido){
        return Math.abs(valorInserido);
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }


    public LocalDate getData() {
        return data;
    }

    public Long getContaId() {
        return contaId;
    }
}


