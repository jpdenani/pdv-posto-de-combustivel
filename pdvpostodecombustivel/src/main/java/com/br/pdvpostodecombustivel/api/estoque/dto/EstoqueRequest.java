package com.br.pdvpostodecombustivel.api.estoque.dto;

import com.br.pdvpostodecombustivel.enums.TipoEstoque;
import java.math.BigDecimal;

public record EstoqueRequest(
        Long produtoId,           // ✅ ADICIONE ESTE CAMPO
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        String dataValidade,
        TipoEstoque tipoEstoque
) {}