package com.br.pdvpostodecombustivel.api.venda.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VendaResponse(
        Long id,
        Integer numeroBomba,
        String nomeProduto,
        BigDecimal litros,
        BigDecimal valorUnitario,
        BigDecimal valorTotal,
        LocalDateTime dataHora,
        String usuarioVendedor
) {}