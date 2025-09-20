package com.br.pdvpostodecombustivel.api.pessoa.dto;

public record ProdutoRequest(
        String marca,
        String referencia,
        String fornecedor,
        String categoria,
        String nome
) {
}