package com.fintech.dao;

import com.fintech.dto.DespesaDto;
import com.fintech.model.Despesa;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    private final Connection conexao;

    public DespesaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public Despesa buscaPorId(Long idDespesa) {
        Despesa despesa = null;
        String sql = "SELECT * FROM despesa WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, idDespesa);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    despesa = mapearDespesa(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return despesa;
    }

    public List<Despesa> buscaTodos() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesa";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Despesa despesa = mapearDespesa(rs);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return despesas;
    }

    public Long cadastra(DespesaDto despesaDto) {
        Long idDespesaCadastrada = null;
        String sql = "{call inserir_despesa(?, ?, ?, ?, ?, ? )}";

        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {
            callableStatement.setString(1, despesaDto.getDescricao());
            callableStatement.setString(2, despesaDto.getCategoria());
            callableStatement.setDouble(3, despesaDto.getValor());
            callableStatement.setTimestamp(4, Timestamp.valueOf(despesaDto.getData()));
            callableStatement.setLong(5, despesaDto.getContaId());

            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(6, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idDespesaCadastrada = callableStatement.getLong(6);

        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return idDespesaCadastrada;
    }

    public List<Despesa> buscarTodasAsDespesasPorContaId(Long idConta){
        List despesas = new ArrayList<>();

        String sql = "SELECT * FROM receita WHERE CONTA_ID = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, idConta);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Despesa despesa = mapearDespesa(rs);
                    despesas.add(despesa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }
        return despesas;
    }

    private Despesa mapearDespesa(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String descricao = rs.getString("descricao");
        String categoria = rs.getString("categoria");
        double valor = rs.getDouble("valor");
        LocalDateTime data = rs.getTimestamp("data").toLocalDateTime();
        Long contaId = rs.getLong("conta_id");

        return new Despesa(id, descricao, categoria, valor, data, contaId);
    }

}
