package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface PrecoRepository extends JpaRepository<Preco, Long> {
    Optional<Preco> findByValor(BigDecimal valor);
    Optional <Preco> findByDataAlteracao(String dataAlteracao);

    boolean existsByValor(BigDecimal valor);
    boolean existsByDataAlteracao(String dataAlteracao);
}
