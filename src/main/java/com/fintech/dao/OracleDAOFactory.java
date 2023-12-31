package com.fintech.dao;
import com.fintech.connection.ConnectionManager;

import java.sql.Connection;

public class OracleDAOFactory {
    public Connection pegarConexao() {
        return ConnectionManager.pegarConexao();
    }

    public void fecharConexao(){
        ConnectionManager.fecharConexao();
    }

    public UsuarioDAO pegaUsuarioDAO() {
        return new UsuarioDAO(pegarConexao());
    }
    // Adicione métodos para outros DAOs conforme necessário

    public ContaDAO pegaContaDao() {
        return new ContaDAO(pegarConexao());
    }

    public ReceitaDAO pegaReceitaDao() {
        return new ReceitaDAO(pegarConexao());
    }

//    public ObjetivoDAO pegaObjetivoDao(){
//        return new ObjetivoDAO(pegarConexao());
//    }

    public DespesaDAO pegaDespesaDao(){
        return new DespesaDAO(pegarConexao());
    }
    public ObjetivoDAO pegaObjetivoDAO(){return new ObjetivoDAO(pegarConexao());}
}
