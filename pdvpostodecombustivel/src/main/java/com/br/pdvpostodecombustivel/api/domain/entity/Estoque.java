package com.br.pdvpostodecombustivel.api.domain.entity;

import com.br.pdvpostodecombustivel.enums.TipoEstoque;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;

    @Column(length = 100)
    private String localTanque;

    @Column(length = 255)
    private String localEndereco;

    @Column(length = 50)
    private String loteFabricacao;

    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoEstoque tipoEstoque;

    @Column(precision = 10, scale = 2)
    private BigDecimal capacidadeMaxima = new BigDecimal("150000.00");

    @Column(precision = 5, scale = 2)
    private BigDecimal percentualEstoque;

    public Estoque() {}

    public Estoque(BigDecimal quantidade, String localTanque, String localEndereco,
                   String loteFabricacao, Date dataValidade, TipoEstoque tipoEstoque) {
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.loteFabricacao = loteFabricacao;
        this.dataValidade = dataValidade;
        this.tipoEstoque = tipoEstoque;
        this.capacidadeMaxima = new BigDecimal("150000.00");
        atualizarTipo();
    }


    public void atualizarTipo() {
        if (quantidade == null || capacidadeMaxima == null || capacidadeMaxima.compareTo(BigDecimal.ZERO) == 0) {
            this.percentualEstoque = BigDecimal.ZERO;
            this.tipoEstoque = TipoEstoque.BAIXO;
            return;
        }

        this.percentualEstoque = quantidade
                .divide(capacidadeMaxima, 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"))
                .setScale(2, RoundingMode.HALF_UP);

        if (percentualEstoque.compareTo(new BigDecimal("70")) >= 0) {
            this.tipoEstoque = TipoEstoque.ALTO;
        } else if (percentualEstoque.compareTo(new BigDecimal("30")) >= 0) {
            this.tipoEstoque = TipoEstoque.MEDIO;
        } else {
            this.tipoEstoque = TipoEstoque.BAIXO;
        }
    }


    public void subtrairQuantidade(BigDecimal litros) {
        if (litros == null || litros.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Quantidade inválida para subtração");
        }

        if (this.quantidade.compareTo(litros) < 0) {
            throw new RuntimeException("Estoque insuficiente! Disponível: " + this.quantidade + "L");
        }

        this.quantidade = this.quantidade.subtract(litros);
        atualizarTipo();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocalTanque() {
        return localTanque;
    }

    public void setLocalTanque(String localTanque) {
        this.localTanque = localTanque;
    }

    public String getLocalEndereco() {
        return localEndereco;
    }

    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }

    public String getLoteFabricacao() {
        return loteFabricacao;
    }

    public void setLoteFabricacao(String loteFabricacao) {
        this.loteFabricacao = loteFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public TipoEstoque getTipoEstoque() {
        return tipoEstoque;
    }

    public void setTipoEstoque(TipoEstoque tipoEstoque) {
        this.tipoEstoque = tipoEstoque;
    }

    public BigDecimal getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(BigDecimal capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public BigDecimal getPercentualEstoque() {
        return percentualEstoque;
    }

    public void setPercentualEstoque(BigDecimal percentualEstoque) {
        this.percentualEstoque = percentualEstoque;
    }
}