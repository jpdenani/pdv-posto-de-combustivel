package com.br.pdvpostodecombustivel.api.domain.entity;

import com.br.pdvpostodecombustivel.enums.TipoAcesso;
import jakarta.persistence.*;

@Entity
@Table(name = "acesso")
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String usuario;

    @Column(length = 50, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_acesso", nullable = false, length = 15)
    private TipoAcesso tipoAcesso;

    public Acesso() {}

    public Acesso(String usuario, String senha, TipoAcesso tipoAcesso) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
    }


    public Long getId() { return id; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public TipoAcesso getTipoAcesso() { return tipoAcesso; }
    public void setTipoAcesso(TipoAcesso tipoAcesso) { this.tipoAcesso = tipoAcesso; }
}
