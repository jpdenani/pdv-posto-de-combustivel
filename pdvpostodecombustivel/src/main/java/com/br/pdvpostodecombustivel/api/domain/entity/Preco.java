package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "preco")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataAlteracao;

    @Column(nullable = false)
    private LocalTime horaAlteracao;

    // ✅ NOVO: Relacionamento com Produto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Preco() {}

    public Preco(BigDecimal valor, LocalDate dataAlteracao, LocalTime horaAlteracao) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }

    // ✅ NOVO: Construtor com produto
    public Preco(BigDecimal valor, LocalDate dataAlteracao, LocalTime horaAlteracao, Produto produto) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
        this.produto = produto;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalTime getHoraAlteracao() {
        return horaAlteracao;
    }

    public void setHoraAlteracao(LocalTime horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }

    // ✅ NOVO: Getter e Setter do produto
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}