package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Bomba;
import com.br.pdvpostodecombustivel.enums.TipoBomba;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BombaRepository extends JpaRepository<Bomba, Long> {
    Optional<Bomba> findByNumero(Integer numero);
    List<Bomba> findByStatus(TipoBomba status);
    boolean existsByNumero(Integer numero);
}