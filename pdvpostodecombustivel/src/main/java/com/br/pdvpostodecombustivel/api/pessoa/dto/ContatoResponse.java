package com.br.pdvpostodecombustivel.api.pessoa.dto;

public record ContatoResponse(
        Long id,
        String email,
        String telefone,
        String endereco
) {
}