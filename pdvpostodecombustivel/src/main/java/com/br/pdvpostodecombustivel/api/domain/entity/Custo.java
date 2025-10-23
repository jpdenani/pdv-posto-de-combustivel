package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "custo") // ❌ ESTAVA "pessoa" - CORRIGIDO!
public class Custo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double imposto;

    @Column(nullable = false)
    private Double custoVariavel;

    @Column(nullable = false)
    private Double custoFixo;

    @Column(nullable = false)
    private Double margemLucro;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataProcessamento;

    // ✅ CONSTRUTOR VAZIO (JPA precisa!)
    public Custo() {}

    // ✅ CONSTRUTOR CORRIGIDO (estava dataProcesasmento)
    public Custo(Double imposto, Double custoVariavel, Double custoFixo, Double margemLucro, Date dataProcessamento) {
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.margemLucro = margemLucro;
        this.dataProcessamento = dataProcessamento;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public Double getImposto() {
        return imposto;
    }

    // ✅ CORRIGIDO: era setNome, agora é setImposto
    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public Double getCustoVariavel() {
        return custoVariavel;
    }

    public void setCustoVariavel(Double custoVariavel) {
        this.custoVariavel = custoVariavel;
    }

    public Double getCustoFixo() {
        return custoFixo;
    }

    public void setCustoFixo(Double custoFixo) {
        this.custoFixo = custoFixo;
    }

    public Double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(Double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public Date getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }
}