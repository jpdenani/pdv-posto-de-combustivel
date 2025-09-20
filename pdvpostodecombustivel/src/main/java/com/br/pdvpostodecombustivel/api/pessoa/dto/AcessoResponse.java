package com.br.pdvpostodecombustivel.api.pessoa.dto;

public record AcessoResponse(
        Long id,
        String usuario,
        String senha
){}