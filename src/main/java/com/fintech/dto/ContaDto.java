package com.fintech.dto;

import java.util.UUID;

public class ContaDto {

    private String id;
    private String nome;
    private double saldo;
    private Long UsuarioId;

    public ContaDto(String nome, double saldo, Long usuarioId) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.saldo = saldo;
        UsuarioId = usuarioId;
    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public Long getUsuarioId() {
        return UsuarioId;
    }
}
