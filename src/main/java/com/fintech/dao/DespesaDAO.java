package com.fintech.dao;

import com.fintech.dto.DespesaDto;
import com.fintech.model.Despesa;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
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
        String sql = "{call inserir_despesa(?, ?, ?, ?, ? )}";

        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {
            callableStatement.setString(1, despesaDto.getDescricao());
            callableStatement.setDouble(2, despesaDto.getValor());
            callableStatement.setTimestamp(3, Timestamp.valueOf(despesaDto.getData().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()));
            callableStatement.setLong(4, despesaDto.getContaId());

            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(5, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idDespesaCadastrada = callableStatement.getLong(5);

        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return idDespesaCadastrada;
    }

    public List<Despesa> buscarDespesasPorContaId(Long idConta){
        List despesas = new ArrayList<>();

        String sql = "SELECT * FROM despesa WHERE CONTA_ID = ?";

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

    public void excluirPorContaId(Long contaId) {
        String sql = "DELETE FROM DESPESA WHERE CONTA_ID = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, contaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
    }

    private Despesa mapearDespesa(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String descricao = rs.getString("descricao");
        double valor = rs.getDouble("valor");
        LocalDate data = rs.getTimestamp("data").toLocalDateTime().toLocalDate();
        Long contaId = rs.getLong("conta_id");

        return new Despesa(id, descricao, valor, data, contaId);
    }

}
