package com.br.pdvpostodecombustivel.api.produto.dto;

import com.br.pdvpostodecombustivel.enums.TipoProduto;

public record ProdutoRequest(
        String marca,
        String referencia,
        String fornecedor,
        String categoria,
        String nome,
        TipoProduto TipoProduto
) {
}