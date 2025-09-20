package com.br.pdvpostodecombustivel.api.pessoa.dto;

public record ProdutoResponse(
        Long id,
        String nome,
        String referencia,
        String marca,
        String fornecedor,
        String categoria
        ){}