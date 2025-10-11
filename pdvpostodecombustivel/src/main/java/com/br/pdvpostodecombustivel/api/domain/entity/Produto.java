package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;

@Entity

@Table(name = "pessoa")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 30, nullable = false)

    private String nome ;
    @Column(length = 50, nullable = false)

    private String referencia;
    @Column(length = 15, nullable = false)

    private String categoria;
    @Column(length = 30, nullable = false)

    private String fornecedor;
    @Column(length = 25, nullable = false)

    private String marca;

    public Produto (String nome, String referencia, String categoria, String fornecedor, String marca){
        this.nome = nome;
        this.referencia = referencia;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.marca = marca;
    }

    public long getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome (String nome){
        this.nome = nome;
    }
    public String getReferencia(){
        return referencia;
    }
    public void setReferencia(String referencia){
        this.referencia = referencia;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getFornecedor(){
        return fornecedor;
    }
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
}