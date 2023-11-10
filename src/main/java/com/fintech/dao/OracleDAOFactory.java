package com.fintech.dao;
import com.fintech.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class OracleDAOFactory {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

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
        return new UsuarioDAO();
    }
    // Adicione métodos para outros DAOs conforme necessário
}
