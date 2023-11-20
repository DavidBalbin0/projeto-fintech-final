package com.fintech.validacao.usuario;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;

import java.time.LocalDate;
import java.util.HashMap;


public class DataNascValidador implements Validador<UsuarioDto> {

    public boolean isMenorQue12Anos(LocalDate dataNasc) {
        LocalDate dataAtual = LocalDate.now();

        // Retorna true se a pessoa for menor de 12 anos
        return dataNasc.plusYears(12).isAfter(dataAtual);
    }

    @Override
    public void validate(UsuarioDto usuario, HashMap<String, String> erros) {
        LocalDate dataNascimento = usuario.getDataNasc();

        // Se a validação falhar, adicione a mensagem de erro ao HashMap
        if (isMenorQue12Anos(dataNascimento)) {
            erros.put("dataNasc", "A data de nascimento não é válida ou o usuário é menor de 12 anos.");
        }
    }
}
