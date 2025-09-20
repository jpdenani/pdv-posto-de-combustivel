package com.br.pdvpostodecombustivel.api.pessoa.dto;


public record PessoaResponse(
        Long id,
        String nomeCompleto,
        String cpfCnpj,
        Long numeroCtps,
        java.time.LocalDate dataNascimento){}