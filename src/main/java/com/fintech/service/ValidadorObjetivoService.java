package com.fintech.service;

import com.fintech.dto.ObjetivoDto;
import com.fintech.validacao.Validador;
//import com.fintech.validacao.objetivo.ContaIdObjetivoValidador;
import com.fintech.validacao.objetivo.DescricaoObjetivoValidador;
import com.fintech.validacao.objetivo.MetaObjetivoValidador;
import com.fintech.validacao.objetivo.SaldoObjetivoValidador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidadorObjetivoService {

    private List<Validador<ObjetivoDto>> validadores = new ArrayList<Validador<ObjetivoDto>>();
    public ValidadorObjetivoService(){
//        validadores.add(new ContaIdObjetivoValidador());
        validadores.add(new DescricaoObjetivoValidador());
        validadores.add(new MetaObjetivoValidador());
        validadores.add(new SaldoObjetivoValidador());
    }

    public void validar(ObjetivoDto dto, HashMap<String, String> erros){
        for (Validador<ObjetivoDto> objetivo:
        validadores) {
            objetivo.validate(dto, erros);
        }
    }
}

