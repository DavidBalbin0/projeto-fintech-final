package com.fintech.validacao.conta;

import com.fintech.dto.ContaDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class SaldoContaValidador implements Validador<ContaDto> {
    private static final double SALDO_MINIMO_PERMITIDO = 0.0;
    @Override
    public void validate(ContaDto conta, HashMap<String, String> erros) {
        double saldo = conta.getSaldo();

        if (saldo < SALDO_MINIMO_PERMITIDO) {
            erros.put("saldo", "O saldo da conta não pode ser menor que " + SALDO_MINIMO_PERMITIDO);
        }
    }
}
