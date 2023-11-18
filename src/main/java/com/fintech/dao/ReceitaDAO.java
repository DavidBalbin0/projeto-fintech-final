package com.fintech.dao;

import com.fintech.dto.ReceitaDto;
import com.fintech.model.Receita;

import java.sql.*;
import java.time.LocalDateTime;
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
            callableStatement.setString(2, receitaDto.getCategoria());
            callableStatement.setDouble(3, receitaDto.getValor());
            callableStatement.setTimestamp(4, Timestamp.valueOf(receitaDto.getData()));
            callableStatement.setLong(5, receitaDto.getContaId());

            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(6, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idReceitaCadastrada = callableStatement.getLong(6);

        } catch (SQLException e) {
            e.printStackTrace(); // Tratar a exceção apropriadamente no seu código real
        }

        return idReceitaCadastrada;
    }


    private Receita mapearReceita(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String descricao = rs.getString("descricao");
        String categoria = rs.getString("categoria");
        double valor = rs.getDouble("valor");
        LocalDateTime data = rs.getTimestamp("data").toLocalDateTime();
        Long contaId = rs.getLong("conta_id");

        return new Receita(id, descricao, categoria, valor, data, contaId);
    }
}
