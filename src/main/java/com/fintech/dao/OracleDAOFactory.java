package com.fintech.dao;
import com.fintech.connection.ConnectionManager;

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
}
