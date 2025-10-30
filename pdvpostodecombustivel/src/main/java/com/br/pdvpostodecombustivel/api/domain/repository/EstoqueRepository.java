package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Estoque;
import com.br.pdvpostodecombustivel.enums.TipoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    // ✅ CORRETO: Busca por TipoEstoque (que existe na entidade Estoque)
    Optional<Estoque> findByTipoEstoque(TipoEstoque tipoEstoque);

    // Se você quiser buscar por múltiplos registros do mesmo tipo:
    // List<Estoque> findByTipoEstoque(TipoEstoque tipoEstoque);
}