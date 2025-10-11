package com.br.pdvpostodecombustivel.api.produto.dto;

public record ProdutoResponse(
        Long id,
        String nome,
        String referencia,
        String marca,
        String fornecedor,
        String categoria
        ){}