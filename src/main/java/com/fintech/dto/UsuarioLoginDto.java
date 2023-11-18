package com.fintech.dto;

public class UsuarioLoginDto {

    private String email;
    private String senha;

    public UsuarioLoginDto(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }
}
