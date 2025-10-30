package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrecoRepository extends JpaRepository<Preco, Long> {
    Optional<Preco> findByValor(BigDecimal valor);
    Optional<Preco> findFirstByOrderByDataAlteracaoDesc();
    List<Preco> findByDataAlteracao(LocalDate dataAlteracao);
    boolean existsByValor(BigDecimal valor);
}