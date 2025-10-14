package com.br.pdvpostodecombustivel.api.produto.dto;

import com.br.pdvpostodecombustivel.enums.TipoProduto;

public record ProdutoResponse(
        Long id,
        String nome,
        String referencia,
        String marca,
        String fornecedor,
        String categoria,
        TipoProduto tipoProduto
        ){}