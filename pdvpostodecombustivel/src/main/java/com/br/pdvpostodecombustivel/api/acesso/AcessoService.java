package com.br.pdvpostodecombustivel.api.acesso;

import com.br.pdvpostodecombustivel.api.domain.entity.Acesso;
import com.br.pdvpostodecombustivel.api.domain.repository.AcessoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AcessoService {

    private final AcessoRepository repository;

    public AcessoService(AcessoRepository repository) {
        this.repository = repository;
    }

    public Acesso create(Acesso acesso) {
        return repository.save(acesso);
    }

    public List<Acesso> listAll() {
        return repository.findAll();
    }

    public Optional<Acesso> findById(Long id) {
        return repository.findById(id);
    }

    public Acesso update(Long id, Acesso acessoAtualizado) {
        Acesso acesso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acesso não encontrado com id: " + id));

        acesso.setUsuario(acessoAtualizado.getUsuario());
        acesso.setSenha(acessoAtualizado.getSenha());
        acesso.setTipoAcesso(acessoAtualizado.getTipoAcesso());

        return repository.save(acesso);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Acesso não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}