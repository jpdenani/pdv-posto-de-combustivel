package com.br.pdvpostodecombustivel.enums;

public enum TipoEstoque {


    FALTA("Indisponível"),
    CRITICO("Crítico"),
    BAIXO("Baixo"),
    MÉDIO("Disponível");

    private final String descricao;

    private TipoEstoque(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}