package com.fintech.service;

import com.fintech.connection.ConnectionManager;
import com.fintech.dao.*;
import com.fintech.dto.UsuarioDto;
import com.fintech.dto.UsuarioLoginDto;
import com.fintech.model.*;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioService {

    OracleDAOFactory daoFactory = new OracleDAOFactory();
    ContaService contaService = new ContaService();
    UsuarioDAO usuarioDAO = daoFactory.pegaUsuarioDAO();

    public Long cadastrar(UsuarioDto usuarioDtoValidado) {
//        String senhaEncriptada = encriptarSenha(usuarioDtoValidado.getSenha());
//        usuarioDtoValidado.setSenha(senhaEncriptada);
        System.out.println(" printando usuario no metodo cadastrar do service " + usuarioDtoValidado);
        try {
            Long idUsuario =  usuarioDAO.cadastrarUsuario(usuarioDtoValidado);
            contaService.criarConta("minha conta", 0.0, idUsuario);
            return idUsuario;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Usuario buscarPorId(Long id ){
        return usuarioDAO.buscaUsuarioPorId(id);
    }

    public Usuario buscarPorEmail(String email){
        return usuarioDAO.buscarPorEmail(email);
    }

    public Boolean validaLoginUsuario(UsuarioLoginDto usuarioLoginDto){
        Usuario usuario = buscarPorEmail(usuarioLoginDto.getEmail());

        if (usuario != null) {
            return verificarSenha(usuarioLoginDto.getSenha(), usuario.getSenha());
        } else {
            return false;
        }
    }

    public String encriptarSenha(String senhaSimples) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(senhaSimples, salt);
    }
//    public  boolean verificarSenha(String senhaSimples, String hashSenha) {
//        return BCrypt.checkpw(senhaSimples, hashSenha);
//    }

    public boolean verificarSenha(String senhaInserida, String senhaSalva){
        return  senhaInserida.equals(senhaSalva);
    }


    public void deslogarUsuario(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    public void excluirUsuarioAndDependentes(Usuario usuario) {
        Connection conexao = ConnectionManager.pegarConexao();  // Mover a declaração para fora do try-with-resources

        try {
            conexao.setAutoCommit(false);

            // Excluir contas associadas ao usuário
            contaService.excluirContaPorUsuarioId(usuario.getId());

            // Em seguida, excluir o usuário
            usuarioDAO.excluirUsuario(usuario.getId());

            conexao.commit();
        } catch (Exception e) {
            // Tratar a exceção de violação de integridade aqui
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.setAutoCommit(true);
                    conexao.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
                // Ou lidar com a exceção de fechamento de conexão
            }
        }
    }



}

