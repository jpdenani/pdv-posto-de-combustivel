package com.br.pdvpostodecombustivel.api.estoque.dto;

import com.br.pdvpostodecombustivel.enums.TipoEstoque;
import java.math.BigDecimal;
import java.util.Date;

public record EstoqueResponse(
        Long id,
        Long produtoId,           // ✅ ADICIONE ESTE CAMPO
        String nomeProduto,       // ✅ ADICIONE ESTE CAMPO
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        Date dataValidade,
        TipoEstoque tipoEstoque,
        BigDecimal capacidadeMaxima,
        BigDecimal percentualEstoque
) {}