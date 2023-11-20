package com.fintech.validacao.objetivo;


import com.fintech.dto.ObjetivoDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class DescricaoObjetivoValidador implements Validador<ObjetivoDto> {

    @Override
    public void validate(ObjetivoDto objetivo, HashMap<String, String> erros) {
        String descricao = objetivo.getDescricao();

        if (descricao == null || descricao.trim().isEmpty()) {
            erros.put("descricao", "A descrição do objetivo não pode ser vazia ou nula");
        }
    }
}
