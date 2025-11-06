package com.br.pdvpostodecombustivel.api.venda;

import com.br.pdvpostodecombustivel.api.domain.entity.Bomba;
import com.br.pdvpostodecombustivel.api.domain.entity.Estoque;
import com.br.pdvpostodecombustivel.api.domain.entity.Preco;
import com.br.pdvpostodecombustivel.api.domain.entity.Produto;
import com.br.pdvpostodecombustivel.api.domain.entity.Venda;
import com.br.pdvpostodecombustivel.api.domain.repository.BombaRepository;
import com.br.pdvpostodecombustivel.api.domain.repository.EstoqueRepository;
import com.br.pdvpostodecombustivel.api.domain.repository.PrecoRepository;
import com.br.pdvpostodecombustivel.api.domain.repository.ProdutoRepository;
import com.br.pdvpostodecombustivel.api.domain.repository.VendaRepository;
import com.br.pdvpostodecombustivel.api.venda.dto.VendaRequest;
import com.br.pdvpostodecombustivel.api.venda.dto.VendaResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final BombaRepository bombaRepository;
    private final ProdutoRepository produtoRepository;
    private final PrecoRepository precoRepository;
    private final EstoqueRepository estoqueRepository;

    public VendaService(VendaRepository vendaRepository, BombaRepository bombaRepository,
                        ProdutoRepository produtoRepository, PrecoRepository precoRepository,
                        EstoqueRepository estoqueRepository) {
        this.vendaRepository = vendaRepository;
        this.bombaRepository = bombaRepository;
        this.produtoRepository = produtoRepository;
        this.precoRepository = precoRepository;
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional
    public VendaResponse realizarVenda(VendaRequest req) {
        // 1. Busca bomba
        Bomba bomba = bombaRepository.findById(req.bombaId())
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));

        // 2. Busca produto
        Produto produto = produtoRepository.findById(req.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // 3. Busca preço pelo mesmo ID do produto (ID 1 = ID 1)
        Preco preco = precoRepository.findById(req.produtoId())
                .orElseThrow(() -> new RuntimeException("Preço não encontrado para o produto ID: " + req.produtoId()));

        // 4. ✅ Busca estoque pelo mesmo ID do produto (ID 1 = ID 1)
        Estoque estoque = estoqueRepository.findById(req.produtoId())
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado para o produto ID: " + req.produtoId()));

        // 5. ✅ Subtrai do estoque (valida quantidade e atualiza tipo automaticamente)
        try {
            estoque.subtrairQuantidade(req.litros());
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao processar venda: " + e.getMessage());
        }

        // 6. Calcula valor total
        BigDecimal valorTotal = preco.getValor().multiply(req.litros());

        // 7. Cria a venda
        Venda venda = new Venda(bomba, produto, req.litros(), preco.getValor(),
                valorTotal, LocalDateTime.now(), req.usuarioVendedor());
        venda = vendaRepository.save(venda);

        // 8. ✅ Salva estoque atualizado (quantidade subtraída + tipo recalculado)
        estoqueRepository.save(estoque);

        return mapToResponse(venda);
    }

    public List<VendaResponse> listAll() {
        return vendaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private VendaResponse mapToResponse(Venda v) {
        return new VendaResponse(
                v.getId(),
                v.getBomba().getNumero(),
                v.getProduto().getNome(),
                v.getLitros(),
                v.getValorUnitario(),
                v.getValorTotal(),
                v.getDataHora(),
                v.getUsuarioVendedor()
        );
    }
}