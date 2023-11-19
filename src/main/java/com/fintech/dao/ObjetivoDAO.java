//package com.fintech.dao;
//
//import com.fintech.dto.ObjetivoDto;
//import com.fintech.model.Conta;
//import com.fintech.model.Objetivo;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ObjetivoDAO {
//
//
//    private final Connection conexao;
//
//    public ObjetivoDAO(Connection conexao){
//        this.conexao = conexao;
//    }
//
//    public List<Objetivo> buscaTodosObjetivos() {
//        List<Objetivo> objetivos = new ArrayList<>();
//        String sql = "SELECT * FROM objetivo";
//
//        try (Statement stmt = conexao.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                Objetivo Objetivo= mapearObjetivo(rs);
//
//                objetivo.add(objetivo);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return objetivos;
//    }
//
//    public Objetivo buscaPorId(Long idObjetivo) {
//        Objetivo objetivo = null;
//        String sql = "SELECT * FROM objetivo WHERE id = ?";
//
//        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
//            stmt.setLong(1, idObjetivo);
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    objetivo = mapearObjetivo(rs);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
//        }
//        return objetivo;
//    }
//
//
//    public Long cadastrarObjetivo(ObjetivoDto objetivoDto) {
//        Long idObjetivoCadastrado = null;
//        String sql = "{call inserir_objetivo(?, ?, ?, ?, ?)}";
//
//        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {
//
//            // Configurar os parâmetros da instrução SQL
//            callableStatement.setString(1, objetivoDto.getDescricao());
//            callableStatement.setDouble(2, objetivoDto.getSaldo());
//            callableStatement.setDouble(3, objetivoDto.getMeta());
////            callableStatement.setBoolean(4, objetivoDto.isVinculadoSaldoConta());
//            callableStatement.setLong(4, objetivoDto.getContaId());
//
//            // Registrar o parâmetro de saída para o ID
//            callableStatement.registerOutParameter(5, Types.NUMERIC);
//
//            // Executar a instrução SQL
//            callableStatement.execute();
//
//            // Obter o ID gerado
//            idObjetivoCadastrado = callableStatement.getLong(5);
//
//        } catch (SQLException e) {
//            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
//        }
//
//        return idObjetivoCadastrado;
//    }
//
//
//    private Objetivo mapearObjetivo(ResultSet rs) throws SQLException {
//        Long id = rs.getLong("id");
//        String descricao = rs.getString("descricao");
//        double meta = rs.getDouble("meta");
//        Long contaId = rs.getLong("conta_id");
//        boolean vinculadoSaldoConta = rs.getBoolean("vinculado_saldo_conta");
//        double saldoInicial = rs.getDouble("saldo");
//
//        OracleDAOFactory daoFactory = new OracleDAOFactory();
//        Conta conta = daoFactory.pegaContaDao().buscaPorId(contaId);
//
//        return new Objetivo(id, descricao, dataInicial, dataFinal, meta, conta, saldoInicial, vinculadoSaldoConta);
//    }
//}
