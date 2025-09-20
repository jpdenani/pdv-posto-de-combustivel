package com.br.pdvpostodecombustivel.api.pessoa.dto;

import java.util.Date;

public record CustoRequest(
        Double imposto,
        Double custoVariavel,
        Double custoFixo,
        Double margemLucro,
        Date dataProcessamento
){}