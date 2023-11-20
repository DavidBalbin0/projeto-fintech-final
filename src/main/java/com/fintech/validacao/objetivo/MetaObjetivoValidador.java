package com.fintech.validacao.objetivo;

import com.fintech.dto.ObjetivoDto;
import com.fintech.model.Objetivo;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class MetaObjetivoValidador implements Validador<ObjetivoDto> {
    private static final double META_MINIMA = 50.0;

    @Override
    public void validate(ObjetivoDto objetivo, HashMap<String, String> erros) {
        Double meta = objetivo.getMeta();

        if (meta == null || meta < META_MINIMA) {
            erros.put("meta", "A meta do objetivo não pode ser nula ou menor que 50");
        }
    }
}
