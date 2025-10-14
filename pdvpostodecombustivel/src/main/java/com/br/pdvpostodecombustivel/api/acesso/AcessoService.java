package com.br.pdvpostodecombustivel.api.acesso;

import com.br.pdvpostodecombustivel.api.acesso.dto.AcessoRequest;
import com.br.pdvpostodecombustivel.api.acesso.dto.AcessoResponse;
import com.br.pdvpostodecombustivel.api.domain.entity.Acesso;
import com.br.pdvpostodecombustivel.api.domain.repository.AcessoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AcessoService {

    private final AcessoRepository repository;

    public AcessoService(AcessoRepository repository) {
        this.repository = repository;
    }

    // Criar um novo acesso
    public AcessoResponse create(AcessoRequest req) {
        Acesso acesso = new Acesso(req.usuario(), req.senha(), req.TipoAcesso()); // id será gerado pelo JPA
        repository.save(acesso);
        return new AcessoResponse(acesso.getId(), acesso.getUsuario(), acesso.getSenha(), acesso.getTipoAcesso());
    }

    // Buscar por id
    public AcessoResponse getById(long id) {
        Acesso acesso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acesso não encontrado"));
        return new AcessoResponse(acesso.getId(), acesso.getUsuario(), acesso.getSenha(), acesso.getTipoAcesso());
    }

    // Buscar por usuário
    public AcessoResponse getByUsuario(String usuario) {
        Acesso acesso = repository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new AcessoResponse(acesso.getId(), acesso.getUsuario(), acesso.getSenha(), acesso.getTipoAcesso());
    }

    // Listar acessos com paginação simples
    public List<AcessoResponse> list(int page, int size, String sortBy, Sort.Direction dir) {
        return repository.findAll(Sort.by(dir, sortBy)).stream()
                .skip(page * size)
                .limit(size)
                .map(a -> new AcessoResponse(a.getId(), a.getUsuario(), a.getSenha(), a.getTipoAcesso()))
                .collect(Collectors.toList());
    }

    // Atualizar acesso (substituindo usuário e senha)
    public AcessoResponse update(long id, AcessoRequest req) {
        Acesso acesso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acesso não encontrado"));
        acesso.setUsuario(req.usuario());
        acesso.setSenha(req.senha());
        repository.save(acesso);
        return new AcessoResponse(acesso.getId(), acesso.getUsuario(), acesso.getSenha(), acesso.getTipoAcesso());
    }

    // Atualização parcial
    public AcessoResponse patch(long id, AcessoRequest req) {
        Acesso acesso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acesso não encontrado"));
        if (req.usuario() != null) acesso.setUsuario(req.usuario());
        if (req.senha() != null) acesso.setSenha(req.senha());
        repository.save(acesso);
        return new AcessoResponse(acesso.getId(), acesso.getUsuario(), acesso.getSenha(), acesso.getTipoAcesso());
    }

    // Deletar por id
    public boolean delete(long id) {
        Optional<Acesso> acessoOpt = repository.findById(id);
        if (acessoOpt.isPresent()) {
            repository.delete(acessoOpt.get());
            return true;
        }
        return false;
    }
}
