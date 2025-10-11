package com.br.pdvpostodecombustivel.api.estoque;

import com.br.pdvpostodecombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostodecombustivel.api.estoque.dto.EstoqueResponse;
import com.br.pdvpostodecombustivel.api.domain.entity.Estoque;
import com.br.pdvpostodecombustivel.api.domain.repository.EstoqueRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    private final EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

    // Criar novo estoque
    public EstoqueResponse create(EstoqueRequest req) {
        Estoque estoque = new Estoque(
                req.quantidade(),
                req.localTanque(),
                req.localEndereco(),
                req.loteFabricacao(),
                req.dataValidade()
        );
        repository.save(estoque);
        return mapToResponse(estoque);
    }

    // Buscar por id
    public EstoqueResponse getById(long id) {
        Estoque estoque = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
        return mapToResponse(estoque);
    }

    // Listar estoques com paginação simples
    public List<EstoqueResponse> list(int page, int size, String sortBy, Sort.Direction dir) {
        return repository.findAll(Sort.by(dir, sortBy)).stream()
                .skip(page * size)
                .limit(size)
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Atualizar estoque
    public EstoqueResponse update(long id, EstoqueRequest req) {
        Estoque estoque = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
        estoque.setQuantidade(req.quantidade());
        estoque.setLocalTanque(req.localTanque());
        estoque.setLocalEndereco(req.localEndereco());
        estoque.setLoteFabricacao(req.loteFabricacao());
        estoque.setDataValidade(req.dataValidade());
        repository.save(estoque);
        return mapToResponse(estoque);
    }

    // Atualização parcial
    public EstoqueResponse patch(long id, EstoqueRequest req) {
        Estoque estoque = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
        if (req.quantidade() != null) estoque.setQuantidade(req.quantidade());
        if (req.localTanque() != null) estoque.setLocalTanque(req.localTanque());
        if (req.localEndereco() != null) estoque.setLocalEndereco(req.localEndereco());
        if (req.loteFabricacao() != null) estoque.setLoteFabricacao(req.loteFabricacao());
        if (req.dataValidade() != null) estoque.setDataValidade(req.dataValidade());
        repository.save(estoque);
        return mapToResponse(estoque);
    }

    // Deletar por id
    public boolean delete(long id) {
        Optional<Estoque> estoqueOpt = repository.findById(id);
        if (estoqueOpt.isPresent()) {
            repository.delete(estoqueOpt.get());
            return true;
        }
        return false;
    }

    // Mapeia a entidade para DTO
    private EstoqueResponse mapToResponse(Estoque e) {
        return new EstoqueResponse(
                e.getId(),
                e.getQuantidade(),
                e.getLocalTanque(),
                e.getLocalEndereco(),
                e.getLoteFabricacao(),
                e.getDataValidade()
        );
    }
}
