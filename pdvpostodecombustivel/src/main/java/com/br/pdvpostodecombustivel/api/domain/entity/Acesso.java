package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;

@Entity

@Table(name = "pessoa")

public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //atributos
    @Column(length = 50, nullable = false)

    private String usuario;
    @Column(length = 20, nullable = false)


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