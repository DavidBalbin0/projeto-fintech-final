package com.fintech.dto;

import java.time.LocalDateTime;

public class ReceitaDto {

    private double valor;
    private String descricao;
    private String categoria;
    private LocalDateTime data;
    private final Long contaId;

    public ReceitaDto (String descricao, double valor,  String categoria, LocalDateTime data, Long contaId) {

        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = data;
        this.contaId = contaId;

    }

    public double getValor() {
        return valor;
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
}


