//package com.fintech.validacao.investimento;
//
//import com.fintech.dto.InvestimentoDto;
//import com.fintech.validacao.Validador;
//
//import java.util.HashMap;
//
//public class SaldoObjetivoValidador implements Validador<ObjetivoDto> {
//    @Override
//    public void validate(ObjetivoDto objetivo, HashMap<String, String> erros) {
//        Double saldo = objetivo.getSaldo();
//
//        if (saldo <= 0) {
//            erros.put("saldo", "O saldo do objetivo não pode ser nulo ou negativo");
//        }
//    }
//}
