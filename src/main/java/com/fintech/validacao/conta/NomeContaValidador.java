package com.fintech.validacao.conta;

import com.fintech.dto.ContaDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class NomeContaValidador implements Validador<ContaDto> {
    private static final int TAMANHO_MAXIMO_NOME = 255;
    @Override
    public void validate(ContaDto conta, HashMap<String, String> erros) {
        String nome = conta.getNome();

        if (nome == null || nome.trim().isEmpty()) {
            erros.put("nome", "O nome da conta não pode ser nulo ou vazio");
        } else if (nome.length() > TAMANHO_MAXIMO_NOME) {
            erros.put("nome", "O nome da conta deve ter no máximo " + TAMANHO_MAXIMO_NOME + " caracteres");
        }
    }
}
