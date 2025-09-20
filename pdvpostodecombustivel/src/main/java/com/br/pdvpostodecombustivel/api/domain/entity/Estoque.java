package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.Date;
@Entity

@Table(name = "pessoa")

public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)

    private BigDecimal quantidade;
    @Column(length = 15, nullable = false)

    private String localTanque;
    @Column(length = 50, nullable = false)

    private String localEndereco;
    @Column(length = 4, nullable = false)

    private String loteFabricacao;
    @Column(nullable = false)

    private Date dataValidade;

    public Estoque ( BigDecimal quantidade, String localTanque, String localEndereco, String loteFabricacao, Date dataValidade){
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.loteFabricacao = loteFabricacao;
        this.dataValidade = dataValidade;
    }
    public BigDecimal getQuantidade(){
        return quantidade;
    }
    public void setQuantidade (BigDecimal quantidade){
        this.quantidade = quantidade;
    }
    public String getLocalTanque(){
        return localTanque;
    }
    public void setLocalTanque (String localTanque){
        this.localTanque = localTanque;
    }
    public String getLocalEndereco(){
        return localEndereco;
    }
    public void setLocalEndereco (String localEndereco){
        this.localEndereco = localEndereco;
    }
    public String getLoteFabricacao(){
        return loteFabricacao;
    }
    public void setLoteFabricacao (String loteFabricacao){
        this.loteFabricacao = loteFabricacao;
    }
    public Date getDataValidade(){
        return dataValidade;
    }
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
}