package com.fintech.dao;

import com.fintech.dto.ContaDto;
import com.fintech.model.Conta;
import com.fintech.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private final Connection conexao;

    public ContaDAO(Connection conexao) { this.conexao = conexao; }

    public Conta buscaPorId(Long idConta) {
        Conta conta = null;
        String sql = "SELECT * FROM conta WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setLong(1, idConta);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                   conta = mapearConta(rs);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return conta;
    }

    public List<Conta> buscaTodas() {
        List<Conta> contas = new ArrayList<>();

        String sql = "SELECT * FROM conta";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
               Conta conta = mapearConta(rs);
                contas.add(conta);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return contas;

    }

    public Long cadastrar (ContaDto contaDto){
        Long idContaCadastrada = null;
        String sql = "{call inserir_conta(?, ?, ?, ?)}";
        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {

            // Configurar os parâmetros da instrução SQL
            callableStatement.setString(1, contaDto.getNome());
            callableStatement.setDouble(2, contaDto.getSaldo());
            callableStatement.setLong(3, contaDto.getUsuarioId());
            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(4, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idContaCadastrada = callableStatement.getLong(4);

        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
        return idContaCadastrada;
    }

    public Conta buscarContaPorUsuarioId(Long usuarioId) {
        Conta conta = null;
        String sql = "SELECT * FROM conta WHERE USUARIO_ID = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, usuarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    conta = mapearConta(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conta;
    }

    public Conta mapearConta(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        String nome = rs.getString("nome");
        double saldo = rs.getDouble("saldo");
        Long usuarioId = rs.getLong("usuario_id");

        return new Conta(id, nome, saldo, usuarioId);
    }
}
