package com.fintech.service;

import com.fintech.dao.*;
import com.fintech.dto.UsuarioDto;
import com.fintech.dto.UsuarioLoginDto;
import com.fintech.model.*;
import org.mindrot.jbcrypt.BCrypt;

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







}

