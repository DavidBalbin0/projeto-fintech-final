package com.fintech.dao;

import com.fintech.model.Conta;
import com.fintech.model.Investimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {


    private final Connection conexao;

    public InvestimentoDAO(Connection conexao){
        this.conexao = conexao;
    }

    public List<Investimento> buscaTodosInvestimentos() {
        List<Investimento> investimentos = new ArrayList<>();
        String sql = "SELECT * FROM investimento";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Investimento investimento = mapearInvestimento(rs);

                investimentos.add(investimento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return investimentos;
    }

    public Investimento buscaPorId(Long idInvestimento) {
        Investimento investimento = null;
        String sql = "SELECT * FROM investimento WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, idInvestimento);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    investimento = mapearInvestimento(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
        return investimento;
    }


    public Long cadastrarInvestimento(Investimento investimento) {
        Long idInvestimentoCadastrado = null;
        String sql = "{call inserir_investimento(?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {

            // Configurar os parâmetros da instrução SQL
            callableStatement.setString(1, investimento.getDescricao());
            callableStatement.setDouble(2, investimento.getMeta());
            callableStatement.setLong(3, investimento.getConta().getId());
            callableStatement.setBoolean(4, investimento.isVinculadoSaldoConta());
            callableStatement.setDouble(5, investimento.getSaldo());

            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(6, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idInvestimentoCadastrado = callableStatement.getLong(6);

        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }

        return idInvestimentoCadastrado;
    }


    private Investimento mapearInvestimento(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String descricao = rs.getString("descricao");
        double meta = rs.getDouble("meta");
        Long contaId = rs.getLong("conta_id");
        boolean vinculadoSaldoConta = rs.getBoolean("vinculado_saldo_conta");
        double saldoInicial = rs.getDouble("saldo_inicial");

        OracleDAOFactory daoFactory = new OracleDAOFactory();
        Conta conta = daoFactory.pegaContaDao().buscaPorId(contaId);

        return new Investimento(id, descricao, meta, conta, saldoInicial, vinculadoSaldoConta);
    }
}
