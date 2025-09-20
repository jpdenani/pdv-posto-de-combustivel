package com.br.pdvpostodecombustivel.api.pessoa.dto;

import java.math.BigDecimal;

public record EstoqueRequest(
        String localTanque,
        String localEndereco,
        BigDecimal quantidade,
        String loteFabricacao
) {
}