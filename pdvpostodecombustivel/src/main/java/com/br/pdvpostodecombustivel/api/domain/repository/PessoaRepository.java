package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByNome(String nome);
    Optional<Pessoa> findByCpfCnpj(String cpfCnpj);


    boolean existsByCpfCnpj(String cpfCnpj);

    boolean existsByNome(String nomeCompleto);
}
