package com.fintech.service;

import com.fintech.dao.OracleDAOFactory;
import com.fintech.dao.UsuarioDAO;
import com.fintech.dto.UsuarioDto;
import com.fintech.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.HashMap;
import java.util.UUID;

public class UsuarioService {

    OracleDAOFactory daoFactory = new OracleDAOFactory();
    UsuarioDAO usuarioDAO = daoFactory.getUsuarioDAO();

    public Long cadastrar(UsuarioDto usuarioDtoValidado) {
        return usuarioDAO.cadastrarUsuario(usuarioDtoValidado);
    }

    public Usuario buscarPorId(Long id ){
        return usuarioDAO.buscaUsuarioPorId(id);
    }

}