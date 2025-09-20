package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome);
    Optional <Produto> findByCategoria(String categoria);
    Optional <Produto> findByMarca(String marca);
    Optional <Produto> findByFornecedor(String fornecedor);
    Optional <Produto> findByReferencia(String referencia);

    boolean existsByNome(String nome);
    boolean existsByCategoria(String categoria);
    boolean existsByMarca(String marca);
    boolean existsByFornecedor(String fornecedor);
    boolean existsByReferencia(String referencia);
}
