package com.fintech.validacao.objetivo;


import com.fintech.dto.ObjetivoDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class SaldoObjetivoValidador implements Validador<ObjetivoDto> {
    @Override
    public void validate(ObjetivoDto objetivo, HashMap<String, String> erros) {
        Double saldo = objetivo.getSaldo();

        if (saldo <= 0) {
            erros.put("saldo", "O saldo do objetivo não pode ser nulo ou negativo");
        }
        if (objetivo.getSaldo() > objetivo.getMeta()) {
            erros.put("saldo", "O valor do objetivo nao pode ser maior do que o valor da meta");
        }
    }
}
