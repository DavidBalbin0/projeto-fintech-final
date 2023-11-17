package com.fintech.validacao.investimento;

import com.fintech.dto.InvestimentoDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class SaldoInvestimentoValidador implements Validador<InvestimentoDto> {
    @Override
    public void validate(InvestimentoDto investimento, HashMap<String, String> erros) {
        Double saldo = investimento.getSaldo();

        if (saldo <= 0) {
            erros.put("saldo", "O saldo do investimento não pode ser nulo ou negativo");
        }
    }
}
