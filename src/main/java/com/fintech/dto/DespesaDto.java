package com.fintech.dto;

import java.time.LocalDateTime;

public class DespesaDto {
    private Long contaId;
    private String descricao;
    private double valor;
    private String categoria;
    private LocalDateTime data;

    public DespesaDto(Long contaId, String descricao, double valor, String categoria, LocalDateTime data) {
        this.valor = valor;
        this.contaId = contaId;
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = data;
    }

    public Long getContaId() {
        return contaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDateTime getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}
