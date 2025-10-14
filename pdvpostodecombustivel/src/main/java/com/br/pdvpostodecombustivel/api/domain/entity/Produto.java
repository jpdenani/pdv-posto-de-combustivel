package com.br.pdvpostodecombustivel.api.domain.entity;

import com.br.pdvpostodecombustivel.enums.TipoAcesso;
import com.br.pdvpostodecombustivel.enums.TipoPessoa;
import com.br.pdvpostodecombustivel.enums.TipoProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_produto", nullable = false, length = 15)
    private TipoProduto tipoProduto;

    public Produto (String nome, String referencia, String categoria, String fornecedor, String marca, TipoProduto tipoProduto){
        this.nome = nome;
        this.referencia = referencia;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.tipoProduto = tipoProduto;
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
    public TipoProduto getTipoProduto(){
        return tipoProduto;
    }
    public void setTipoProduto(TipoProduto tipoProduto){
        this.tipoProduto = tipoProduto;
    }
}