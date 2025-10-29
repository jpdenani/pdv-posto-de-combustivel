package com.br.pdvpostodecombustivel.api.preco;

import com.br.pdvpostodecombustivel.api.domain.entity.Preco;
import com.br.pdvpostodecombustivel.api.domain.repository.PrecoRepository;
import com.br.pdvpostodecombustivel.api.preco.dto.PrecoRequest;
import com.br.pdvpostodecombustivel.api.preco.dto.PrecoResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrecoService {

    private final PrecoRepository repository;

    public PrecoService(PrecoRepository repository) {
        this.repository = repository;
    }

    public PrecoResponse create(PrecoRequest req) {
        Preco preco = new Preco(req.valor(), req.dataAlteracao(), req.horaAlteracao());
        preco = repository.save(preco);
        return mapToResponse(preco);
    }

    public PrecoResponse getById(long id) {
        Preco preco = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preço não encontrado"));
        return mapToResponse(preco);
    }

    public List<PrecoResponse> list(int page, int size, String sortBy, Sort.Direction dir) {
        return repository.findAll(Sort.by(dir, sortBy)).stream()
                .skip((long) page * size)
                .limit(size)
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public PrecoResponse update(long id, PrecoRequest req) {
        Preco preco = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preço não encontrado"));
        preco.setValor(req.valor());
        preco.setDataAlteracao(req.dataAlteracao());
        preco.setHoraAlteracao(req.horaAlteracao());
        preco = repository.save(preco);
        return mapToResponse(preco);
    }

    public PrecoResponse patch(long id, PrecoRequest req) {
        Preco preco = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preço não encontrado"));
        if (req.valor() != null) preco.setValor(req.valor());
        if (req.dataAlteracao() != null) preco.setDataAlteracao(req.dataAlteracao());
        if (req.horaAlteracao() != null) preco.setHoraAlteracao(req.horaAlteracao());
        preco = repository.save(preco);
        return mapToResponse(preco);
    }

    public boolean delete(long id) {
        Optional<Preco> precoOpt = repository.findById(id);
        if (precoOpt.isPresent()) {
            repository.delete(precoOpt.get());
            return true;
        }
        return false;
    }

    private PrecoResponse mapToResponse(Preco p) {
        return new PrecoResponse(p.getId(), p.getValor(), p.getDataAlteracao(), p.getHoraAlteracao());
    }
}