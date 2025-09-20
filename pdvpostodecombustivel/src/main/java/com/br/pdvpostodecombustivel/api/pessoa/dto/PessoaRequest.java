package com.br.pdvpostodecombustivel.api.pessoa.dto;


import com.br.pdvpostodecombustivel.enums.TipoPessoa;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PessoaRequest(
        String nomeCompleto,
        String cpfCnpj,
        Long numeroCtps,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento,
        TipoPessoa tipoPessoa){
}