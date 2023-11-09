package com.fintech.service;

import com.fintech.dto.ReceitaDto;
import com.fintech.validacao.Validador;
import com.fintech.validacao.receita.DataReceitaValidador;
import com.fintech.validacao.receita.DescricaoReceitaValidador;
import com.fintech.validacao.receita.ValorReceitaValidador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidadorReceitaService {
    private List<Validador<ReceitaDto>> validadores = new ArrayList<Validador<ReceitaDto>>();

    public ValidadorReceitaService() {
        validadores.add(new DataReceitaValidador());
        validadores.add(new DescricaoReceitaValidador());
        validadores.add(new ValorReceitaValidador());
    }

    public void validar(ReceitaDto receitaDto, HashMap<String, String> erros){
        for (Validador<ReceitaDto> validador: validadores) {
            validador.validate(receitaDto, erros);

        }
    }

}
