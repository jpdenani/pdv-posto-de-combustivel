package com.br.pdvpostodecombustivel.api.bomba.dto;

import com.br.pdvpostodecombustivel.enums.TipoBomba;

public record BombaRequest(
        Integer numero,
        TipoBomba tipoBomba
) {}