package com.fintech.dto;

import java.time.LocalDateTime;

public class ReceitaDto {

    private double valor;
    private String descricao;
    private String categoria;
    private LocalDateTime data;

    public ReceitaDto (double valor, String descricao, String categoria, LocalDateTime data) {

        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = data;

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


