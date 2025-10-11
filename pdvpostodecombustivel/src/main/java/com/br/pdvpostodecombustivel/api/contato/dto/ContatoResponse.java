package com.br.pdvpostodecombustivel.api.contato.dto;

public record ContatoResponse(
        Long id,
        String email,
        String telefone,
        String endereco
) {
}