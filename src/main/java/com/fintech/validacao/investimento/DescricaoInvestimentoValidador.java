package com.fintech.validacao.investimento;

import com.fintech.dto.InvestimentoDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class DescricaoInvestimentoValidador implements Validador<InvestimentoDto> {

    @Override
    public void validate(InvestimentoDto investimento, HashMap<String, String> erros) {
        String descricao = investimento.getDescricao();

        if (descricao == null || descricao.trim().isEmpty()) {
            erros.put("descricao", "A descrição do investimento não pode ser vazia ou nula");
        }
    }
}
