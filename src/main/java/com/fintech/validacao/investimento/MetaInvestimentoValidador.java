package com.fintech.validacao.investimento;

import com.fintech.dto.InvestimentoDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class MetaInvestimentoValidador implements Validador<InvestimentoDto> {
    private static final double META_MINIMA = 50.0;

    @Override
    public void validate(InvestimentoDto investimento, HashMap<String, String> erros) {
        Double meta = investimento.getMeta();

        if (meta == null || meta < META_MINIMA) {
            erros.put("meta", "A meta do investimento não pode ser nula ou menor que 50");
        }
    }
}
