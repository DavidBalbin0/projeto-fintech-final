package com.fintech.validacao.receita;

import com.fintech.dto.DespesaDto;
import com.fintech.dto.ReceitaDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;

public class DescricaoReceitaValidador implements Validador<ReceitaDto> {

    @Override
    public void validate(ReceitaDto receitaDto, HashMap<String, String> erros) {
        String descricao = receitaDto.getDescricao();
        validaDescricao(descricao, erros);
    }

    void validaDescricao(String descricao, HashMap<String, String> erros){
        if (descricao.isBlank()) {
            adicionarErro(erros, "A descrição não pode ser nula ou vazia!");
        }

        int comprimento = descricao.length();
        if (comprimento < 5 || comprimento > 50) {
            adicionarErro(erros, "A descrição deve ter entre 5 e 50 caracteres!");
        }
    }
    private void adicionarErro(HashMap<String, String> erros, String mensagem) {
        erros.put("valor:", mensagem);
    }



}
