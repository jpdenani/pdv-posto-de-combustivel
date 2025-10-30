package com.br.pdvpostodecombustivel.api.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bomba_id", nullable = false)
    private Bomba bomba;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal litros;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 50)
    private String usuarioVendedor;

    public Venda() {}

    public Venda(Bomba bomba, Produto produto, BigDecimal litros,
                 BigDecimal valorUnitario, BigDecimal valorTotal,
                 LocalDateTime dataHora, String usuarioVendedor) {
        this.bomba = bomba;
        this.produto = produto;
        this.litros = litros;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.dataHora = dataHora;
        this.usuarioVendedor = usuarioVendedor;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public Bomba getBomba() { return bomba; }
    public void setBomba(Bomba bomba) { this.bomba = bomba; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public BigDecimal getLitros() { return litros; }
    public void setLitros(BigDecimal litros) { this.litros = litros; }

    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getUsuarioVendedor() { return usuarioVendedor; }
    public void setUsuarioVendedor(String usuarioVendedor) { this.usuarioVendedor = usuarioVendedor; }
}