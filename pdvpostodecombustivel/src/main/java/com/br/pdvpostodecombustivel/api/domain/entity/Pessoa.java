package com.br.pdvpostodecombustivel.api.domain.entity;

import com.br.pdvpostodecombustivel.enums.TipoPessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", length = 200, nullable = false)
    private String nomeCompleto;

    @Column(name = "cpf_cnpj", length = 14, nullable = false)
    private String cpfCnpj;

    @Column(name = "numero_ctps", length = 12)
    private Long numeroCtps;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "tipo_pessoa", nullable = false, length = 15)
    private TipoPessoa tipoPessoa;

    // Construtores
    public Pessoa(){
    }

    public Pessoa(String nomeCompleto, String cpfCNPJ, LocalDate dataNascimento, Long numeroCtps, TipoPessoa tipoPessoa) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCNPJ;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
        this.tipoPessoa = tipoPessoa;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getNumeroCtps() {
        return numeroCtps;
    }

    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
