package com.fintech.validacao.despesa;

import com.fintech.dto.DespesaDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class ValorDespesaValidador implements Validador<DespesaDto> {
    @Override
    public void validate(DespesaDto despesaDto, HashMap<String, String> erros){
        double valor = despesaDto.getValor();
        validaValor(valor);

    }

    boolean validaValor(double valor) {
        return !(valor <=0);
    }
}
