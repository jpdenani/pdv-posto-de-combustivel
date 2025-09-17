package com.br.pdvpostodecombustivel.api.domain.entity;

public class Contato {
    //atributos
    private String telefone;

    private String email;

    private String endereco;
    //construtor
    public Contato (String nomeCompleto, String email, String endereco) {
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    //getters //setters
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}