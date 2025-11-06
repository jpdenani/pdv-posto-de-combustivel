package com.br.pdvpostodecombustivel.api.estoque;

import com.br.pdvpostodecombustivel.api.domain.entity.Estoque;
import com.br.pdvpostodecombustivel.api.domain.repository.EstoqueRepository;
import com.br.pdvpostodecombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostodecombustivel.api.estoque.dto.EstoqueResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional
    public EstoqueResponse criar(EstoqueRequest req) {
        try {
            // Converte String para Date
            Date dataValidade = dateFormat.parse(req.dataValidade());

            Estoque estoque = new Estoque(
                    req.quantidade(),
                    req.localTanque(),
                    req.localEndereco(),
                    req.loteFabricacao(),
                    dataValidade,
                    req.tipoEstoque()
            );

            // ✅ Calcula o tipo automaticamente
            estoque.atualizarTipo();

            estoque = estoqueRepository.save(estoque);
            return mapToResponse(estoque);
        } catch (ParseException e) {
            throw new RuntimeException("Data inválida! Use o formato dd/MM/yyyy");
        }
    }

    @Transactional
    public EstoqueResponse atualizar(Long id, EstoqueRequest req) {
        try {
            Estoque estoque = estoqueRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

            // Converte String para Date
            Date dataValidade = dateFormat.parse(req.dataValidade());

            estoque.setQuantidade(req.quantidade());
            estoque.setLocalTanque(req.localTanque());
            estoque.setLocalEndereco(req.localEndereco());
            estoque.setLoteFabricacao(req.loteFabricacao());
            estoque.setDataValidade(dataValidade);

            // ✅ Recalcula o tipo
            estoque.atualizarTipo();

            estoque = estoqueRepository.save(estoque);
            return mapToResponse(estoque);
        } catch (ParseException e) {
            throw new RuntimeException("Data inválida! Use o formato dd/MM/yyyy");
        }
    }

    @Transactional
    public void deletar(Long id) {
        if (!estoqueRepository.existsById(id)) {
            throw new RuntimeException("Estoque não encontrado");
        }
        estoqueRepository.deleteById(id);
    }

    public EstoqueResponse buscarPorId(Long id) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
        return mapToResponse(estoque);
    }

    public List<EstoqueResponse> listarTodos() {
        return estoqueRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private EstoqueResponse mapToResponse(Estoque e) {
        return new EstoqueResponse(
                e.getId(),
                e.getQuantidade(),
                e.getLocalTanque(),
                e.getLocalEndereco(),
                e.getLoteFabricacao(),
                e.getDataValidade(),
                e.getTipoEstoque(),
                e.getCapacidadeMaxima(),    // ✅ 150.000 litros
                e.getPercentualEstoque()    // ✅ % atual
        );
    }
}