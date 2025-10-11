package com.br.pdvpostodecombustivel.api.estoque.dto;

import java.math.BigDecimal;
import java.util.Date;

public record EstoqueResponse(
        Long id,
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        Date dataValidade
) {
}