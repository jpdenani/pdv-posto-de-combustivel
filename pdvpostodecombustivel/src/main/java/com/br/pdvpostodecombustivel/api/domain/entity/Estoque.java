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

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;

    @Column(length = 50, nullable = false)
    private String localTanque;

    @Column(length = 100, nullable = false)
    private String localEndereco;

    @Column(length = 20, nullable = false)
    private String loteFabricacao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataValidade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_estoque", nullable = false, length = 20)
    private TipoEstoque tipoEstoque;

    // ✅ Capacidade máxima FIXA (não vai no banco)
    private static final BigDecimal CAPACIDADE_MAXIMA = new BigDecimal("150000.00");

    // Construtores
    public Estoque() {}

    public Estoque(BigDecimal quantidade, String localTanque, String localEndereco,
                   String loteFabricacao, Date dataValidade, TipoEstoque tipoEstoque) {
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.loteFabricacao = loteFabricacao;
        this.dataValidade = dataValidade;
        this.tipoEstoque = tipoEstoque;
    }

    // ✅ Calcula tipo baseado na % (0-20% CRITICO, 20-45% BAIXO, 45-75% MEDIO, 75-100% ALTO)
    public void atualizarTipo() {
        if (quantidade == null) {
            this.tipoEstoque = TipoEstoque.CRITICO;
            return;
        }

        BigDecimal percentual = quantidade
                .multiply(new BigDecimal("100"))
                .divide(CAPACIDADE_MAXIMA, 2, RoundingMode.HALF_UP);

        if (percentual.compareTo(new BigDecimal("20")) < 0) {
            this.tipoEstoque = TipoEstoque.CRITICO;
        } else if (percentual.compareTo(new BigDecimal("45")) < 0) {
            this.tipoEstoque = TipoEstoque.BAIXO;
        } else if (percentual.compareTo(new BigDecimal("75")) < 0) {
            this.tipoEstoque = TipoEstoque.MEDIO;
        } else {
            this.tipoEstoque = TipoEstoque.ALTO;
        }
    }

    // ✅ Subtrai quantidade (usado nas vendas)
    public void subtrairQuantidade(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (this.quantidade.compareTo(valor) < 0) {
            throw new IllegalStateException("Estoque insuficiente! Disponível: " + this.quantidade + " litros");
        }
        this.quantidade = this.quantidade.subtract(valor);
        atualizarTipo();
    }

    // ✅ Adiciona quantidade (reabastecimento)
    public void adicionarQuantidade(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        BigDecimal novaQuantidade = this.quantidade.add(valor);
        if (novaQuantidade.compareTo(CAPACIDADE_MAXIMA) > 0) {
            throw new IllegalStateException("Capacidade máxima excedida! Máximo: 150.000 litros");
        }
        this.quantidade = novaQuantidade;
        atualizarTipo();
    }

    // ✅ Retorna capacidade máxima
    public BigDecimal getCapacidadeMaxima() {
        return CAPACIDADE_MAXIMA;
    }

    // ✅ Retorna percentual de estoque
    public BigDecimal getPercentualEstoque() {
        if (quantidade == null) return BigDecimal.ZERO;
        return quantidade.multiply(new BigDecimal("100"))
                .divide(CAPACIDADE_MAXIMA, 2, RoundingMode.HALF_UP);
    }

    // Getters e Setters
    public Long getId() { return id; }

    public BigDecimal getQuantidade() { return quantidade; }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
        atualizarTipo();
    }

    public String getLocalTanque() { return localTanque; }
    public void setLocalTanque(String localTanque) { this.localTanque = localTanque; }

    public String getLocalEndereco() { return localEndereco; }
    public void setLocalEndereco(String localEndereco) { this.localEndereco = localEndereco; }

    public String getLoteFabricacao() { return loteFabricacao; }
    public void setLoteFabricacao(String loteFabricacao) { this.loteFabricacao = loteFabricacao; }

    public Date getDataValidade() { return dataValidade; }
    public void setDataValidade(Date dataValidade) { this.dataValidade = dataValidade; }

    public TipoEstoque getTipoEstoque() { return tipoEstoque; }
    public void setTipoEstoque(TipoEstoque tipoEstoque) { this.tipoEstoque = tipoEstoque; }
}