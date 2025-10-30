package com.br.pdvpostodecombustivel.api.bomba;

import com.br.pdvpostodecombustivel.api.bomba.dto.BombaRequest;
import com.br.pdvpostodecombustivel.api.bomba.dto.BombaResponse;
import com.br.pdvpostodecombustivel.api.domain.entity.Bomba;
import com.br.pdvpostodecombustivel.api.domain.repository.BombaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BombaService {

    private final BombaRepository repository;

    public BombaService(BombaRepository repository) {
        this.repository = repository;
    }

    public BombaResponse create(BombaRequest req) {
        if (repository.existsByNumero(req.numero())) {
            throw new RuntimeException("Já existe uma bomba com este número");
        }
        Bomba bomba = new Bomba(req.numero(), req.tipoBomba());
        bomba = repository.save(bomba);
        return mapToResponse(bomba);
    }

    public BombaResponse getById(Long id) {
        Bomba bomba = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));
        return mapToResponse(bomba);
    }

    public List<BombaResponse> listAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public BombaResponse update(Long id, BombaRequest req) {
        Bomba bomba = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));
        bomba.setNumero(req.numero());
        bomba.setStatus(req.tipoBomba());
        bomba = repository.save(bomba);
        return mapToResponse(bomba);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Bomba não encontrada");
        }
        repository.deleteById(id);
    }

    private BombaResponse mapToResponse(Bomba b) {
        return new BombaResponse(b.getId(), b.getNumero(), b.getStatus());
    }
}
