package com.br.pdvpostodecombustivel.api.domain.repository;

import com.br.pdvpostodecombustivel.api.domain.entity.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {
    Optional<Acesso> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
}
