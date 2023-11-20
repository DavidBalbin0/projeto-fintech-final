package com.fintech.dao;

import com.fintech.dto.UsuarioDto;
import com.fintech.model.Usuario;
import com.fintech.teste.Sexo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UsuarioDAO {

    private final Connection conexao;

    public UsuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    OracleDAOFactory daoFactory =new OracleDAOFactory();
    ContaDAO contaDAO = daoFactory.pegaContaDao();

    public Usuario buscaUsuarioPorId(Long idUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setLong(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return usuario;
    }

    public Long cadastrarUsuario(UsuarioDto usuarioDto) {
        System.out.println("chegou no dao");
        Long idUsuarioCadastrado = null;
        String sql = "{call inserir_usuario(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {

            // Configurar os parâmetros da instrução SQL
            callableStatement.setString(1, usuarioDto.getNome());
            callableStatement.setTimestamp(2, Timestamp.valueOf(usuarioDto.getDataNasc().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()));
            callableStatement.setString(3, usuarioDto.getSexo());
            callableStatement.setString(4, usuarioDto.getEmail());
            callableStatement.setString(5, usuarioDto.getSenha());
            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(6, Types.NUMERIC);

            // Executar a instrução SQL
            boolean executou = callableStatement.execute();
            System.out.println("executou? " + executou);

            // Obter o ID gerado
            idUsuarioCadastrado = callableStatement.getLong(6);
            System.out.println(idUsuarioCadastrado);

        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
        return idUsuarioCadastrado;
    }

    public Usuario buscarPorEmail(String email) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return usuario;
    }

    public Usuario mapearUsuario(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        String nome = rs.getString("Nome");
        Timestamp timestamp = rs.getTimestamp("data_nasc");
        LocalDate dataNasc = timestamp.toLocalDateTime().toLocalDate();
        String sexoString = rs.getString("sexo");
        Sexo sexo = Sexo.valueOf(sexoString.toUpperCase());
        String email = rs.getString("email");
        String senha = rs.getString("senha");

        return new Usuario(id, nome, dataNasc, sexo, email, senha);
    }

    public void excluirUsuario(Long idUsuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
    }
}
