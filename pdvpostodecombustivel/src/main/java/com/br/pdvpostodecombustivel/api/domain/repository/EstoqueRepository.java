package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Estoque;
import com.br.pdvpostodecombustivel.api.domain.entity.Produto;
import com.br.pdvpostodecombustivel.enums.TipoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByTipoEstoque(TipoEstoque tipoEstoque);

    // ✅ ADICIONE ESTE MÉTODO - Busca estoque por produto
    Optional<Estoque> findByProduto(Produto produto);

    // ✅ OU ESTE (mais direto) - Busca por ID do produto
    Optional<Estoque> findByProdutoId(Long produtoId);
}