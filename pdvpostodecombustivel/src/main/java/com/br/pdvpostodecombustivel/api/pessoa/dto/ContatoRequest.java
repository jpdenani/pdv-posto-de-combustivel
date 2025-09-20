package com.br.pdvpostodecombustivel.api.pessoa.dto;

public record ContatoRequest(
        String email,
        String telefone,
        String endereco
) {
}