package com.fintech.dao;

import com.fintech.dto.ObjetivoDto;
import com.fintech.model.Conta;
import com.fintech.model.Objetivo;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ObjetivoDAO {


    private final Connection conexao;

    public ObjetivoDAO(Connection conexao){
        this.conexao = conexao;
    }

    public List<Objetivo> buscaTodosObjetivos() {
        List<Objetivo> objetivos = new ArrayList<>();
        String sql = "SELECT * FROM objetivo";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Objetivo objetivo= mapearObjetivo(rs);

                objetivos.add(objetivo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objetivos;
    }

    public Objetivo buscaPorId(Long idObjetivo) {
        Objetivo objetivo = null;
        String sql = "SELECT * FROM objetivo WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, idObjetivo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    objetivo = mapearObjetivo(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
        return objetivo;
    }

    public List<Objetivo> buscaPorContaId(Long contaId) {

        List<Objetivo> objetivos = new ArrayList<>();
        String sql = "SELECT * FROM objetivo WHERE conta_id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, contaId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Objetivo objetivo = mapearObjetivo(rs);
                    objetivos.add(objetivo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
        return objetivos;
    }


    public Long cadastra(ObjetivoDto objetivoDto) {
        Long idObjetivoCadastrado = null;
        String sql = "{call inserir_objetivo(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {

            // Configurar os parâmetros da instrução SQL
            callableStatement.setString(1, objetivoDto.getDescricao());
            callableStatement.setDouble(2, objetivoDto.getSaldo());
            callableStatement.setTimestamp(3, Timestamp.valueOf(objetivoDto.getDataInicio().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()));
            callableStatement.setTimestamp(4, Timestamp.valueOf(objetivoDto.getDataFinal().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()));
            callableStatement.setDouble(5, objetivoDto.getMeta());
            callableStatement.setDouble(6, objetivoDto.getProgresso());
            callableStatement.setLong(7, objetivoDto.getContaId());

            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(8, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idObjetivoCadastrado = callableStatement.getLong(8);

        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }

        return idObjetivoCadastrado;
    }


    private Objetivo mapearObjetivo(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String descricao = rs.getString("descricao");
        double saldo = rs.getDouble("saldo");
        LocalDate dataInicial = rs.getTimestamp("data_inicio").toLocalDateTime().toLocalDate();
        LocalDate dataFinal = rs.getTimestamp("data_final").toLocalDateTime().toLocalDate();
        double meta = rs.getDouble("meta");
        double progresso = rs.getDouble("progresso");
        Long contaId = rs.getLong("conta_id");


        OracleDAOFactory daoFactory = new OracleDAOFactory();
        Conta conta = daoFactory.pegaContaDao().buscaPorId(contaId);

        return new Objetivo(id, descricao, saldo, dataInicial, dataFinal, meta, progresso, contaId);
    }

    public void atualizarObjetivo(Objetivo objetivo) {
        String sql = "UPDATE objetivo SET descricao = ?, saldo = ?, data_inicio = ?, data_final = ?, meta = ?, progresso = ?, conta_id = ? WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, objetivo.getDescricao());
            stmt.setDouble(2, objetivo.getSaldo());
            stmt.setTimestamp(3, Timestamp.valueOf(objetivo.getDataInicio().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()));
            stmt.setTimestamp(4, Timestamp.valueOf(objetivo.getDataFinal().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()));
            stmt.setDouble(5, objetivo.getMeta());
            stmt.setDouble(6, objetivo.getProgresso());
            stmt.setLong(7, objetivo.getContaId());
            stmt.setLong(8, objetivo.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
    }
}
