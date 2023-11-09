package com.fintech.service;

import com.fintech.dto.DespesaDto;
import com.fintech.validacao.Validador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidadorDespesaService {

    private List<Validador<DespesaDto>> validadores = new ArrayList<Validador<DespesaDto>>();

    public ValidadorDespesaService(){

    }

    public void validar(DespesaDto dto, HashMap<String, String> erros){
        for (Validador<DespesaDto> despesa:
             validadores) {
            despesa.validate(dto, erros);
        }
    }
}
