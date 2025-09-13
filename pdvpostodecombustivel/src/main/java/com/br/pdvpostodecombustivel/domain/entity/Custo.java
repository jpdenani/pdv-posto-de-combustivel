package com.br.pdvpostodecombustivel.domain.entity;

import java.util.Date;

public class Custo {

    private Double imposto;
    private Double custoVariavel;
    private Double custoFixo;
    private Double margemLucro;
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