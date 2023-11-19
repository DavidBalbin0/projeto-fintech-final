package com.fintech.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DespesaDto {

    private String descricao;
    private double valor;
    private LocalDate data;
    private Long contaId;

    public DespesaDto(String descricao, double valor,  LocalDate data, Long contaId) {
        this.valor = negativaValor(valor);
        this.contaId = contaId;
        this.descricao = descricao;
        this.data = data;
    }
    private double negativaValor(double valorInserido){
        double valorNormalizado = Math.abs(valorInserido);
        return -Math.abs(valorNormalizado);
    }

    public Long getContaId() {
        return contaId;
    }

    public String getDescricao() {
        return descricao;
    }


    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

}
