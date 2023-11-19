package com.fintech.validacao.despesa;

import com.fintech.dto.DespesaDto;
import com.fintech.validacao.Validador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class DataDespesaValidador implements Validador<DespesaDto> {
    @Override
    public void validate(DespesaDto despesaDto, HashMap<String, String> erros) {
        LocalDate data = despesaDto.getData();
        validaDataHora(data, erros);
    }

    public void validaDataHora(LocalDate dataHora, HashMap<String, String> erros) {
        LocalDate agora = LocalDate.now();
        LocalDate umAnoAtras = agora.minus(1, ChronoUnit.YEARS);
        LocalDate umaSemanaFrente = agora.plus(1, ChronoUnit.WEEKS);

        if (dataHora.isBefore(umAnoAtras)) {
            erros.put("dataHora", "A data não pode ser mais antiga que um ano atrás");
        }

        if (dataHora.isAfter(umaSemanaFrente)) {
            erros.put("dataHora", "A data não pode ser mais recente à uma semana à frente");
        }

    }
}
