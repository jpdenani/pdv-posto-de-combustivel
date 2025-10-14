package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Custo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustoRepository extends JpaRepository<Custo, Long> {
    Optional<Custo> findByDataProcessamento(java.util.Date dataProcessamento);
    boolean existsByDataProcessamento(java.util.Date dataProcessamento);
}
