package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
@Entity

@Table(name = "pessoa")

public class Preco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)

    private BigDecimal valor ;
    @Column(length = 8, nullable = false)

    private String dataAlteracao;
    @Column(nullable = false)

    private Date horaAlteracao;

    public Preco (BigDecimal valor, String dataAlteracao, Date horaAlteracao){
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getValor(){
        return valor;
    }
    public void setValor(BigDecimal valor){
        this.valor = valor;
    }
    public String getDataAlteracao(){
        return dataAlteracao;
    }
    public void setDataAlteracao(String dataAlteracao){
        this.dataAlteracao = dataAlteracao;
    }
    public Date getHoraAlteracao(){
        return horaAlteracao;
    }
    public void setHoraAlteracao(Date horaAlteracao){
        this.horaAlteracao = horaAlteracao;
    }
}