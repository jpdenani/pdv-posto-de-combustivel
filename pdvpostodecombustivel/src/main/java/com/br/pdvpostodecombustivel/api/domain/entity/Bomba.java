package com.br.pdvpostodecombustivel.api.domain.entity;

import com.br.pdvpostodecombustivel.enums.TipoBomba;
import jakarta.persistence.*;

@Entity
@Table(name = "bomba")
public class Bomba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TipoBomba status;

    public Bomba() {}

    public Bomba(Integer numero, TipoBomba status) {
        this.numero = numero;
        this.status = status;
    }

    // getters e getters
    public Long getId() { return id; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public TipoBomba getStatus() { return status; }
    public void setStatus(TipoBomba status) { this.status = status; }
}