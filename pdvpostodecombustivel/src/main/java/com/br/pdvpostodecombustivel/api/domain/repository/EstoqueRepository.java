package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional <Estoque> findByDataValidade(Date dataValidade);
    Optional <Estoque> findByLocalTanque(String localTanque);
    Optional <Estoque> findByLoteFabricacao(String loteFabricacao);

    boolean existsByLoteFabricacao(String loteFabricacao);
    boolean existsByLocalTanque(String localTanque);
    boolean existsByDataValidade(Date dataValidade);
}
