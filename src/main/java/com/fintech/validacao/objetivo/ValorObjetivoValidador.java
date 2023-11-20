//package com.fintech.validacao.objetivo;
//
//import com.fintech.dto.ObjetivoDto;
//import com.fintech.validacao.Validador;
//
//import java.util.HashMap;
//
//public class ValorObjetivoValidador implements Validador<ObjetivoDto> {
//
//    @Override
//    public void validate(ObjetivoDto objetivo, HashMap<String, String> erros) {
//        if (objetivo.getValor() > objetivo.getMeta()) {
//            erros.put("valor", "O valor do objetivo nao pode ser maior do que o valor da meta");
//        }
//
//    }
//}
