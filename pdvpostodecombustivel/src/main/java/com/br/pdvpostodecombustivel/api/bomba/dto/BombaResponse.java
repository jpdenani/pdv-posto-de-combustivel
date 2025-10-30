package com.br.pdvpostodecombustivel.api.bomba.dto;

import com.br.pdvpostodecombustivel.enums.TipoBomba;

public record BombaResponse(
        Long id,
        Integer numero,
        TipoBomba tipoBomba
) {}