package com.br.pdvpostodecombustivel.enums;

public enum TipoAcesso {


    ADMINISTRADO("Administrador"),
    FUNCIONÁRIO("Funcionário");

    private final String descricao;

    private TipoAcesso(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}