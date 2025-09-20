package com.br.pdvpostodecombustivel.api.pessoa.dto;

import java.math.BigDecimal;

public record PrecoResponse(
        Long id,
        BigDecimal valor,
        String dataAlteracao,
        String horaAlteracao
){}