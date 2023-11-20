package com.fintech.validacao.usuario;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;

import java.time.LocalDate;
import java.util.HashMap;


public class DataNascValidador implements Validador<UsuarioDto> {

    public boolean validarDataNascimento(LocalDate dataNasc) {
        LocalDate dataAtual = LocalDate.now();

        return !dataNasc.plusYears(12).isAfter(dataAtual) || !dataNasc.isAfter(dataAtual);
    }
    @Override
    public void validate(UsuarioDto usuario, HashMap<String, String> erros) {
        LocalDate dataNascimento = usuario.getDataNasc();

        if (!validarDataNascimento(dataNascimento)) {
            erros.put("dataNasc", "A data de nascimento não é válida ou o usuário é menor de 12 anos.");
        }

    }
}
