package com.br.pdvpostodecombustivel.api.produto;

import com.br.pdvpostodecombustivel.api.domain.entity.Produto;
import com.br.pdvpostodecombustivel.api.domain.repository.ProdutoRepository;
import com.br.pdvpostodecombustivel.api.produto.dto.ProdutoRequest;
import com.br.pdvpostodecombustivel.api.produto.dto.ProdutoResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoResponse create(ProdutoRequest req) {
        // ✅ CORRIGIDO: era req.TipoProduto() (com T maiúsculo), agora é tipoProduto()
        Produto produto = new Produto(req.nome(), req.referencia(), req.categoria(),
                req.fornecedor(), req.marca(), req.tipoProduto());
        produto = repository.save(produto); // ✅ Pega o retorno do save
        return mapToResponse(produto);
    }

    public ProdutoResponse getById(long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return mapToResponse(produto);
    }

    public List<ProdutoResponse> list(int page, int size, String sortBy, Sort.Direction dir) {
        return repository.findAll(Sort.by(dir, sortBy)).stream()
                .skip((long) page * size)
                .limit(size)
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ProdutoResponse update(long id, ProdutoRequest req) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(req.nome());
        produto.setReferencia(req.referencia());
        produto.setCategoria(req.categoria());
        produto.setFornecedor(req.fornecedor());
        produto.setMarca(req.marca());
        produto.setTipoProduto(req.tipoProduto()); // ✅ CORRIGIDO
        produto = repository.save(produto);
        return mapToResponse(produto);
    }

    public ProdutoResponse patch(long id, ProdutoRequest req) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        if (req.nome() != null) produto.setNome(req.nome());
        if (req.referencia() != null) produto.setReferencia(req.referencia());
        if (req.categoria() != null) produto.setCategoria(req.categoria());
        if (req.fornecedor() != null) produto.setFornecedor(req.fornecedor());
        if (req.marca() != null) produto.setMarca(req.marca());
        if (req.tipoProduto() != null) produto.setTipoProduto(req.tipoProduto()); // ✅ CORRIGIDO
        produto = repository.save(produto);
        return mapToResponse(produto);
    }

    public boolean delete(long id) {
        Optional<Produto> produtoOpt = repository.findById(id);
        if (produtoOpt.isPresent()) {
            repository.delete(produtoOpt.get());
            return true;
        }
        return false;
    }

    private ProdutoResponse mapToResponse(Produto p) {
        return new ProdutoResponse(p.getId(), p.getNome(), p.getReferencia(),
                p.getCategoria(), p.getFornecedor(), p.getMarca(), p.getTipoProduto());
    }
}