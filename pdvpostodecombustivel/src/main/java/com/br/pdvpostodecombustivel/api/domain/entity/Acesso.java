package com.br.pdvpostodecombustivel.api.domain.entity;

import com.br.pdvpostodecombustivel.enums.TipoAcesso;
import com.br.pdvpostodecombustivel.enums.TipoPessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity

@Table(name = "pessoa")

public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    //atributos
    @Column(length = 50, nullable = false)

    private String usuario;
    @Column(length = 20, nullable = false)


    private String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_acesso", nullable = false, length = 15)
    private TipoAcesso tipoAcesso;

    //construtor
    public Acesso (String usuario, String senha, TipoAcesso tipoAcesso) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
    }
    //getters //setters
    public long getId(){
        return id;
    }

    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;

    }
    public TipoAcesso getTipoAcesso(){
        return tipoAcesso;
    }
    public void setTipoAcesso(TipoAcesso tipoAcesso){
        this.tipoAcesso = tipoAcesso;
    }
}