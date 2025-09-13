package com.br.pdvpostodecombustivel.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Preco {

    private BigDecimal valor ;
    private String dataAlteracao;
    private Date horaAlteracao;

    public Preco (BigDecimal valor, String dataAlteracao, Date horaAlteracao){
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }
    public BigDecimal getValor(){
        return valor;
    }
    public void setNome (BigDecimal valor){
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