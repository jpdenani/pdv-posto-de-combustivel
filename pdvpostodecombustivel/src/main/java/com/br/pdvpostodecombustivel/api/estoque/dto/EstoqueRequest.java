package com.br.pdvpostodecombustivel.api.estoque.dto;

import com.br.pdvpostodecombustivel.enums.TipoEstoque;

import java.math.BigDecimal;

// ✅ Usando String para data - evita problemas de serialização
public record EstoqueRequest(
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        String dataValidade,      // ✅ MUDOU para String (formato: "dd/MM/yyyy" ou "yyyy-MM-dd")
        TipoEstoque tipoEstoque
) {
}