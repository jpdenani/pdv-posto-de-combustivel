package com.br.pdvpostodecombustivel.domain.entity;

public class Acesso {
    //atributos
    private String usuario;

    private String senha;
    //construtor
    public Acesso (String nomeCompleto, String email) {
        this.usuario = usuario;
        this.senha = email;
    }
    //getters //setters
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;

    }
}