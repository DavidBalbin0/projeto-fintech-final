package com.fintech.validacao.despesa;

import com.fintech.dto.DespesaDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class DescricaoDespesaValidador implements Validador<DespesaDto> {
    @Override
    public void validate(DespesaDto despesaDto, HashMap<String, String> erros){
        String descricao = despesaDto.getDescricao();
        validaDescricao(descricao, erros);
    }

    private void validaDescricao(String descricao, HashMap<String, String> erros) {
        if(descricao.isBlank()) {
            adicionarErro(erros, "A descrição não pode ser nula ou vazia!");
        }

        int comprimento = descricao.length();
        if (comprimento < 3 || comprimento > 50){
            adicionarErro(erros, "A descrição deve ter entre 5 e 50 caracteres!");
        }
    }

    private void adicionarErro(HashMap<String, String> erros, String mensagem) {
        erros.put("valor:", mensagem);
    }
}
