package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;

@Entity

@Table(name = "pessoa")

public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    //atributos
    @Column(length = 50, nullable = false)

    private String usuario;
    @Column(length = 20, nullable = false)


    private String senha;

    //construtor
    public Acesso (String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    //getters //setters
    public long getId(){
        return id;
    }

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