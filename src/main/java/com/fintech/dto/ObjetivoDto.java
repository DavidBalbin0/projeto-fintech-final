package com.fintech.dto;

import java.time.LocalDate;

public class ObjetivoDto {
    private String descricao;
    private double saldo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private double meta;
    private double progresso;
    private Long contaId;

    public ObjetivoDto(String descricao, double saldo, LocalDate dataInicio, LocalDate dataFinal, double meta, Long contaId) {
        this.descricao = descricao;
        this.saldo = saldo;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.meta = meta;
        this.progresso = calcularProgressao();
        this.contaId = contaId;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public double getProgresso() {
        return progresso;
    }

    private double calcularProgressao() {
        if (meta != 0) {
            return (saldo / meta) * 100.0;
        } else {
            return 0.0; // lidar com o caso em que a meta é zero para evitar divisão por zero
        }
    }
}
