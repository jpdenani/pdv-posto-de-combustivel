package com.br.pdvpostodecombustivel.api.pessoa.dto;


import com.br.pdvpostodecombustivel.enums.TipoPessoa;

public record PessoaResponse(
        Long id,
        String nomeCompleto,
        String cpfCnpj,
        Long numeroCtps,
        java.time.LocalDate dataNascimento,
        TipoPessoa tipoPessoa){}