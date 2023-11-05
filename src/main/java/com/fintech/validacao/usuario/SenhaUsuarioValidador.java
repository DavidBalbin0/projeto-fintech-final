package com.fintech.validacao.usuario;

import com.fintech.dto.UsuarioDto;
import com.fintech.validacao.Validador;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SenhaUsuarioValidador implements Validador<UsuarioDto> {
    String regex ="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";


    @Override
    public void validate(UsuarioDto usuario, HashMap<String, String> erros) {
        String senha = usuario.getSenha();

        if(senha.length() < 4 || senha.length() > 50) {
            erros.put("senha", "A senha deve ter entre 4 e 50 caracteres.");
        }

        if(senha.contains(" ")) {
            erros.put("senha", "A senha não pode conter espaços");
        }
    }


}
