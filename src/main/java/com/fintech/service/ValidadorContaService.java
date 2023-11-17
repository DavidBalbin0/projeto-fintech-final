package com.fintech.service;

import com.fintech.dto.ContaDto;
import com.fintech.dto.DespesaDto;
import com.fintech.validacao.Validador;
import com.fintech.validacao.conta.NomeContaValidador;
import com.fintech.validacao.conta.SaldoContaValidador;
import com.fintech.validacao.conta.UsuarioIdContaValidador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidadorContaService {

    private List<Validador<ContaDto>> validadores = new ArrayList<Validador<ContaDto>>();

    public ValidadorContaService() {
        validadores.add(new NomeContaValidador());
        validadores.add(new SaldoContaValidador());
        validadores.add(new UsuarioIdContaValidador());
    }

    public void validar (ContaDto dto, HashMap<String, String> erros){
        for (Validador<ContaDto> conta:
                validadores){
            conta.validate(dto, erros);
        }
    }
}
