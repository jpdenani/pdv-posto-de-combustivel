package com.br.pdvpostodecombustivel.domain.entity;

import java.util.Date;

public class Pessoa {
       //atributos
    private String nomeCompleto;

    private String cpfCNPJ;

    private Date dataNascimento;

    private Long numeroCtps;
    //construtor
    public Pessoa (String nomeCompleto,  String cpfCNPJ, Date dataNascimento, Long numeroCtps) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCNPJ = cpfCNPJ;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    }
    public Pessoa (){

    }
    //getters //setters
    public String getNomeCompleto(){
        return nomeCompleto;
    }
    public void setNomeCompleto (String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }
    public String getCpfCNPJ(){
        return cpfCNPJ;
    }
    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }
    public Date getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Long getNumeroCtps(){
        return numeroCtps;
    }
    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
    }
}