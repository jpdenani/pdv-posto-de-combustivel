package com.br.pdvpostodecombustivel.api.acesso.dto;

import com.br.pdvpostodecombustivel.enums.TipoAcesso;

public record AcessoResponse(
        Long id,
        String usuario,
        String senha,
        TipoAcesso tipoAcesso
){}