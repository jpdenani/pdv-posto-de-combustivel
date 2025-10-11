package com.br.pdvpostodecombustivel.api.contato;

import com.br.pdvpostodecombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostodecombustivel.api.contato.dto.ContatoResponse;
import com.br.pdvpostodecombustivel.api.domain.entity.Contato;
import com.br.pdvpostodecombustivel.api.domain.repository.ContatoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    // Criar um novo contato
    public ContatoResponse create(ContatoRequest req) {
        Contato contato = new Contato(req.telefone(), req.email(), req.endereco());
        repository.save(contato);
        return new ContatoResponse(contato.getId(), contato.getTelefone(), contato.getEmail(), contato.getEndereco());
    }

    // Buscar por id
    public ContatoResponse getById(long id) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        return new ContatoResponse(contato.getId(), contato.getTelefone(), contato.getEmail(), contato.getEndereco());
    }

    // Listar contatos com paginação simples
    public List<ContatoResponse> list(int page, int size, String sortBy, Sort.Direction dir) {
        return repository.findAll(Sort.by(dir, sortBy)).stream()
                .skip(page * size)
                .limit(size)
                .map(c -> new ContatoResponse(c.getId(), c.getTelefone(), c.getEmail(), c.getEndereco()))
                .collect(Collectors.toList());
    }

    // Atualizar contato (substituindo telefone, email e endereco)
    public ContatoResponse update(long id, ContatoRequest req) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        contato.setTelefone(req.telefone());
        contato.setEmail(req.email());
        contato.setEndereco(req.endereco());
        repository.save(contato);
        return new ContatoResponse(contato.getId(), contato.getTelefone(), contato.getEmail(), contato.getEndereco());
    }

    // Atualização parcial
    public ContatoResponse patch(long id, ContatoRequest req) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        if (req.telefone() != null) contato.setTelefone(req.telefone());
        if (req.email() != null) contato.setEmail(req.email());
        if (req.endereco() != null) contato.setEndereco(req.endereco());
        repository.save(contato);
        return new ContatoResponse(contato.getId(), contato.getTelefone(), contato.getEmail(), contato.getEndereco());
    }

    // Deletar por id
    public boolean delete(long id) {
        Optional<Contato> contatoOpt = repository.findById(id);
        if (contatoOpt.isPresent()) {
            repository.delete(contatoOpt.get());
            return true;
        }
        return false;
    }
}
