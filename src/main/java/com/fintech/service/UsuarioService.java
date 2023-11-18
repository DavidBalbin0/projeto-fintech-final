package com.fintech.service;

import com.fintech.dao.*;
import com.fintech.dto.UsuarioDto;
import com.fintech.dto.UsuarioLoginDto;
import com.fintech.model.*;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    OracleDAOFactory daoFactory = new OracleDAOFactory();
    UsuarioDAO usuarioDAO = daoFactory.pegaUsuarioDAO();
    ContaDAO contaDAO = daoFactory.pegaContaDao();
    ReceitaDAO receitaDAO = daoFactory.pegaReceitaDao();
    DespesaDAO depesaDAO = daoFactory.pegaDespesaDao();

    public Long cadastrar(UsuarioDto usuarioDtoValidado) {
        String senhaEncriptada = encriptarSenha(usuarioDtoValidado.getSenha());
        usuarioDtoValidado.setSenha(senhaEncriptada);
        return usuarioDAO.cadastrarUsuario(usuarioDtoValidado);
    }

    public Usuario buscarPorId(Long id ){
        return usuarioDAO.buscaUsuarioPorId(id);
    }

    public Usuario buscarPorEmail(String email){
        return usuarioDAO.buscarPorEmail(email);
    }

    public Boolean validaLoginUsuario(UsuarioLoginDto usuarioLoginDto){
        Usuario usuario = buscarPorEmail(usuarioLoginDto.getEmail());

        if (usuario != null) {
            return verificarSenha(usuarioLoginDto.getSenha(), usuario.getSenha());
        } else {
            return false;
        }
    }

    public String encriptarSenha(String senhaSimples) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(senhaSimples, salt);
    }
    public  boolean verificarSenha(String senhaSimples, String hashSenha) {
        return BCrypt.checkpw(senhaSimples, hashSenha);
    }

    public List<Transacao> pegarAndOrdenarTransacoesRecente(Usuario usuario) {
        Conta conta = contaDAO.buscarContaPorUsuarioId(usuario.getId());
        List<Transacao> transacaos = new ArrayList<>();

        List<Receita> receitas = receitaDAO.buscarTodasAsReceitasPorContaId(conta.getId());
        List<Despesa> despesas = depesaDAO.buscarTodasAsDespesasPorContaId(conta.getId());
        //buscar receitas e despespesas *dos ultimos 5 dias* dessa conta do usuario
        //atribuir dentro de uma lista de transacoes
        //ordenar essa lista pela data
        // retornar lista
    }
}

