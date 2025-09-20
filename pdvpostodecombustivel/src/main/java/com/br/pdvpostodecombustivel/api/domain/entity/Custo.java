package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity

@Table(name = "pessoa")

public class Custo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Double imposto;

    @Column(nullable = false)
    private Double custoVariavel;

    @Column(nullable = false)
    private Double custoFixo;

    @Column(nullable = false)
    private Double margemLucro;

    @Column(nullable = false)
    private Date dataProcesasmento;

    public Custo (Double imposto, Double custoVariavel, Double custoFixo, Double margemLucro, Date dataProcesasmento){
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.margemLucro = margemLucro;
        this.dataProcesasmento = dataProcesasmento;
    }
    public Double getImposto(){
        return imposto;
    }
    public void setNome (Double imposto){
        this.imposto = imposto;
    }
    public Double getCustoVariavel(){
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

    public void setDataProcesasmento(Date dataProcesasmento) {
        this.dataProcesasmento = dataProcesasmento;
    }

    public Date getDataProcesasmento() {
        return dataProcesasmento;
    }
}