package com.br.pdvpostodecombustivel.api.contato.dto;

public record ContatoRequest(
        String email,
        String telefone,
        String endereco
) {
}