package com.br.pdvpostodecombustivel.enums;

public enum TipoProduto {


    GASOLINACOMUM("Gasolina Comum"),
    GASOLINAADITIVADA("Gasolina Aditivada"),
    ETANOL("Etanol Hidratado"),
    DIESELS10("Diesel S10");

    private final String descricao;

    private TipoProduto(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}