package com.fintech.dao;
import com.fintech.connection.ConnectionManager;
import com.fintech.model.Investimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class OracleDAOFactory {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection pegarConexao() {
        return ConnectionManager.pegarConexao();
    }

    public void fecharConexao(){
        ConnectionManager.fecharConexao();
    }

    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO(pegarConexao());
    }
    // Adicione métodos para outros DAOs conforme necessário

    public ContaDAO pegaContaDao() {
        return new ContaDAO(pegarConexao());
    }

    public ReceitaDAO pegaReceitaDao() {
        return new ReceitaDAO(pegarConexao());
    }

    public InvestimentoDAO pegaInvestimentoDao(){
        return new InvestimentoDAO(pegarConexao());
    }
}
