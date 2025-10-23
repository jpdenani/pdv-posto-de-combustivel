package com.br.pdvpostodecombustivel.enums;

public enum TipoAcesso {


    ADMINISTRADOR("Administrador"),
    FUNCIONARIO("Funcionário");

    private final String descricao;

    private TipoAcesso(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}