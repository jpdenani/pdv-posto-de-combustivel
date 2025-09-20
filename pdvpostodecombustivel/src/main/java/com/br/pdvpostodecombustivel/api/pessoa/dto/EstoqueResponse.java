package com.br.pdvpostodecombustivel.api.pessoa.dto;

import java.math.BigDecimal;

public record EstoqueResponse(
        Long id,
        String localTanque,
        String localEndereco,
        BigDecimal quantidade,
        String loteFabricacao
) {
}