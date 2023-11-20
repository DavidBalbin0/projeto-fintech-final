package com.fintech.dao;

import com.fintech.dto.ReceitaDto;
import com.fintech.model.Receita;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    private final Connection conexao;

    public ReceitaDAO(Connection conexao) { this.conexao = conexao; }

    public Receita buscaPorId(Long idReceita){
        Receita receita = null;
        String sql = "SELECT * FROM receita WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, idReceita);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    receita = mapearReceita(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return receita;
    }

    public List<Receita> buscaTodos(){
        List receitas = new ArrayList<>();

        String sql = "SELECT * FROM receita";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Receita receita = mapearReceita(rs);
                receitas.add(receita);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return receitas;
    }

    public Long cadastra(ReceitaDto receitaDto){
        Long idReceitaCadastrada = null;
        String sql = "{call inserir_receita(?, ?, ?, ?, ?)}";

        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {
            callableStatement.setString(1, receitaDto.getDescricao());
            callableStatement.setDouble(2, receitaDto.getValor());
            callableStatement.setTimestamp(3, Timestamp.valueOf(receitaDto.getData().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()));
            callableStatement.setLong(4, receitaDto.getContaId());

            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(5, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idReceitaCadastrada = callableStatement.getLong(5);

        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return idReceitaCadastrada;
    }



    public List<Receita> buscarReceitasPorContaId(Long idConta) {
        List receitas = new ArrayList<>();

        String sql = "SELECT * FROM receita WHERE CONTA_ID = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, idConta);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Receita receita = mapearReceita(rs);
                    receitas.add(receita);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }
        return receitas;
    }

    public void excluirPorContaId(Long contaId) {
        String sql = "DELETE FROM RECEITA WHERE CONTA_ID = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, contaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
    }

    private Receita mapearReceita(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String descricao = rs.getString("descricao");
        double valor = rs.getDouble("valor");
        LocalDate data = rs.getTimestamp("data").toLocalDateTime().toLocalDate();
        Long contaId = rs.getLong("conta_id");

        return new Receita(id, descricao, valor, data, contaId);
    }





}
