package com.fintech.validacao.receita;

import com.fintech.dto.ReceitaDto;
import com.fintech.validacao.Validador;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class DataReceitaValidador implements Validador<ReceitaDto> {


    @Override
    public void validate(ReceitaDto receitaDto, HashMap<String, String> erros) {
        LocalDateTime data = receitaDto.getData();
        validaDataHora(data, erros);

    }


    public void validaDataHora(LocalDateTime dataHora, HashMap<String, String> erros) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime umAnoAtras = agora.minus(1, ChronoUnit.YEARS);
        LocalDateTime umaSemanaFrente = agora.plus(1, ChronoUnit.WEEKS);

        if (dataHora.isBefore(umAnoAtras)) {
            erros.put("dataHora", "A data não pode ser mais antiga que um ano atrás");
        }

        if (dataHora.isAfter(umaSemanaFrente)) {
            erros.put("dataHora", "A data não pode ser mais recente à uma semana à frente");
        }
    }
}
