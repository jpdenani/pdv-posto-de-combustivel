package com.br.pdvpostodecombustivel.api.acesso.dto;

import com.br.pdvpostodecombustivel.enums.TipoAcesso;

public record AcessoRequest(
        String usuario,
        String senha,
        TipoAcesso TipoAcesso
) {

}