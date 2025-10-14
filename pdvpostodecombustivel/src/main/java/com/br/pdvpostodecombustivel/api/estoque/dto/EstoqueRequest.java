package com.br.pdvpostodecombustivel.api.estoque.dto;

import com.br.pdvpostodecombustivel.enums.TipoEstoque;

import java.math.BigDecimal;
import java.util.Date;

public record EstoqueRequest(
        String localTanque,
        String localEndereco,
        BigDecimal quantidade,
        String loteFabricacao,
        Date dataValidade,
        TipoEstoque tipoEstoque
) {
}