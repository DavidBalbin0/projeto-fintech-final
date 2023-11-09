package com.fintech.validacao.receita;

import com.fintech.dto.ReceitaDto;
import com.fintech.validacao.Validador;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ValorReceitaValidador implements Validador<ReceitaDto> {
    @Override
    public void validate(ReceitaDto receitaDto, HashMap<String, String> erros) {
        double valor = receitaDto.getValor();
        validaValor(valor);
    }

    boolean validaValor(double valor){
        return !(valor <= 0);
    }


}
