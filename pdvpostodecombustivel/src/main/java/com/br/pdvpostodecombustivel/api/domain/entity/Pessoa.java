package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity

@Table(name = "pessoa")

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       //atributos
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeCompleto;
    @Column(length = 14, nullable = false)
    private String cpfCnpj;
    @Column(length = 12)
    private Long numeroCtps;
    @Column(length = 14, nullable = false)
    private LocalDate dataNascimento;


    //construtor
    public Pessoa (String nomeCompleto,  String cpfCNPJ, LocalDate dataNascimento, Long numeroCtps) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCNPJ;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    }
    public Pessoa (){

    }
    //getters //setters
    public Long getId (){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto(){
        return nomeCompleto;
    }
    public void setNomeCompleto (String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }
    public String getCpfCnpj(){
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Long getNumeroCtps(){
        return numeroCtps;
    }
    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
    }
}