package com.fintech.service;

import com.fintech.dto.InvestimentoDto;
import com.fintech.model.Investimento;
import com.fintech.validacao.Validador;
import com.fintech.validacao.investimento.ContaIdInvestimentoValidador;
import com.fintech.validacao.investimento.DescricaoInvestimentoValidador;
import com.fintech.validacao.investimento.MetaInvestimentoValidador;
import com.fintech.validacao.investimento.SaldoInvestimentoValidador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidadorInvestimentoService {

    private List<Validador<InvestimentoDto>> validadores = new ArrayList<Validador<InvestimentoDto>>();
    public ValidadorInvestimentoService(){
        validadores.add(new ContaIdInvestimentoValidador());
        validadores.add(new DescricaoInvestimentoValidador());
        validadores.add(new MetaInvestimentoValidador());
        validadores.add(new SaldoInvestimentoValidador());
    }

    public void validar(InvestimentoDto dto, HashMap<String, String> erros){
        for (Validador<InvestimentoDto> investimento:
        validadores) {
            investimento.validate(dto, erros);
        }
    }
}

