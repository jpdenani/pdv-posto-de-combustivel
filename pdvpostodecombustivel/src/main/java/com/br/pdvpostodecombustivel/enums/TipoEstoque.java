package com.br.pdvpostodecombustivel.enums;

public enum TipoEstoque {


    EMFALTA("Indisponível"),
    CRÍTICO("Crítico"),
    BAIXO("Baixo"),
    NAMÉDIA("Disponível");

    private final String descricao;

    private TipoEstoque(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}