package com.fintech.dao;

import com.fintech.dto.UsuarioDto;
import com.fintech.model.Usuario;
import com.fintech.teste.Sexo;

import java.sql.*;
import java.time.LocalDateTime;

public class UsuarioDAO {

    private final Connection conexao;

    public UsuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    public Usuario buscaUsuarioPorId(Long idUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setLong(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Long id = rs.getLong("id");
                    byte[] foto = rs.getBytes("foto");
                    String nome = rs.getString("Nome");
                    Timestamp timestamp = rs.getTimestamp("data_nasc");
                    LocalDateTime dataNasc = timestamp.toLocalDateTime();
                    String sexoString = rs.getString("sexo");
                    Sexo sexo = Sexo.valueOf(sexoString.toUpperCase());
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    usuario = new Usuario(id, foto, nome, dataNasc, sexo, email, senha);

                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return usuario;
    }

    public Long cadastrarUsuario(UsuarioDto usuarioDto) {
        Long idUsuarioCadastrado = null;
        String sql = "{call inserir_usuario(?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement callableStatement = conexao.prepareCall(sql)) {

            // Configurar os parâmetros da instrução SQL
            callableStatement.setBytes(1, usuarioDto.getFoto());
            callableStatement.setString(2, usuarioDto.getNome());
            callableStatement.setTimestamp(3, Timestamp.valueOf(usuarioDto.getDataNasc()));
            callableStatement.setString(4, usuarioDto.getSexo());
            callableStatement.setString(5, usuarioDto.getEmail());
            callableStatement.setString(6, usuarioDto.getSenha());
            // Registrar o parâmetro de saída para o ID
            callableStatement.registerOutParameter(7, Types.NUMERIC);

            // Executar a instrução SQL
            callableStatement.execute();

            // Obter o ID gerado
            idUsuarioCadastrado = callableStatement.getLong(7);

        } catch (SQLException e) {
            e.printStackTrace();  // Tratar a exceção apropriadamente no seu código real
        }
        return idUsuarioCadastrado;
    }

}
