package com.fintech.service;

import com.fintech.dao.ContaDAO;
import com.fintech.dao.DespesaDAO;
import com.fintech.dao.OracleDAOFactory;
import com.fintech.dao.ReceitaDAO;
import com.fintech.dto.ContaDto;
import com.fintech.dto.DespesaDto;
import com.fintech.dto.ReceitaDto;
import com.fintech.model.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaService {

    OracleDAOFactory daoFactory = new OracleDAOFactory();
    ContaDAO contaDAO = daoFactory.pegaContaDao();
    ReceitaDAO receitaDAO = daoFactory.pegaReceitaDao();
    DespesaDAO despesaDAO = daoFactory.pegaDespesaDao();
    public Conta criarConta(String nomeConta, double saldoInicial, Long usuarioId) {
        ContaDto contaDto = new ContaDto(nomeConta, saldoInicial, usuarioId);
        Long idConta = contaDAO.cadastrar(contaDto);
        return contaDAO.buscaPorId(idConta);
    }

    public Conta buscarContaPorUsuarioId(Long usuarioId) {
        return contaDAO.buscarContaPorUsuarioId(usuarioId);
    }

    public List<Receita> pegarReceitas(Usuario usuario) {
        Conta conta = buscarContaPorUsuarioId(usuario.getId());
        List<Receita> receitas = receitaDAO.buscarReceitasPorContaId(conta.getId());
        Collections.sort(receitas);
        return receitas;

    }

    public List<Receita> buscarReceitasPorContaId(Long contaId) {
        return receitaDAO.buscarReceitasPorContaId(contaId);
    }



    public List<Despesa> pegarDespesas(Usuario usuario) {
        Conta conta = buscarContaPorUsuarioId(usuario.getId());
        List<Despesa> despesas = buscarDespesasPorContaId(conta.getId());
        Collections.sort(despesas);
        return despesas;
    }

    public List<Despesa> buscarDespesasPorContaId(Long despesaId){
        return despesaDAO.buscarDespesasPorContaId(despesaId);
    }


    public List<Transacao> pegarAndOrdenarTransacoesRecente(Usuario usuario) {
        Conta conta = buscarContaPorUsuarioId(usuario.getId());
        List<Transacao> transacoes = new ArrayList<>();

        List<Receita> receitas = buscarReceitasPorContaId(conta.getId());
        List<Despesa> despesas = buscarDespesasPorContaId(conta.getId());
        transacoes.addAll(receitas);
        transacoes.addAll(despesas);
        Collections.sort(transacoes);

        return transacoes;
    }

    public Receita cadastrarReceita(ReceitaDto receitaDto){
        Receita receita = null;
        try {
            Long id = receitaDAO.cadastra(receitaDto);
            receita = receitaDAO.buscaPorId(id);
            Conta conta = buscaContaPorId(receita.getContaId());
            conta.adicionarValor(receita.getValor());
        }catch (NullPointerException e){
            System.out.println("erro ao cadastrar receita!");
        }
        return receita;
    }

    public Despesa cadastrarDespesa(DespesaDto despesaDto){
        Despesa despesa = null;
        try{
            Long id = despesaDAO.cadastra(despesaDto);
            despesa = despesaDAO.buscaPorId(id);
            Conta conta = buscaContaPorId(despesa.getContaId());
            conta.adicionarValor(despesa.getValor());
        } catch (NullPointerException e){
            System.out.println("erro ao cadastrar despesa!");
        }
        return despesa;
    }

    public Conta buscaContaPorId(Long contaId) {
        return contaDAO.buscaPorId(contaId);
    }


}