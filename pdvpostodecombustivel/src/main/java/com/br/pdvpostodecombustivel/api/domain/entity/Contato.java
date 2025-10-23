package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contato") // ❌ ESTAVA "pessoa" - CORRIGIDO!
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String telefone;

    @Column(length = 320, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String endereco;

    // ✅ CONSTRUTOR VAZIO (JPA precisa!)
    public Contato() {}

    // ✅ CONSTRUTOR CORRIGIDO (estava com nomeCompleto)
    public Contato(String telefone, String email, String endereco) {
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}