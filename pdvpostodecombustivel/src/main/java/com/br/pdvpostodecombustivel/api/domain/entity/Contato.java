package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;

@Entity

@Table(name = "pessoa")

public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    //atributos
    @Column(length = 15, nullable = false)

    private String telefone;
    @Column(length = 320, nullable = false)

    private String email;
    @Column(length = 50, nullable = false)

    private String endereco;
    //construtor
    public Contato (String nomeCompleto, String email, String endereco) {
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    //getters //setters
    public long getId(){
        return id;
    }

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