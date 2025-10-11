package com.br.pdvpostodecombustivel.api.custo;

import com.br.pdvpostodecombustivel.api.custo.dto.CustoRequest;
import com.br.pdvpostodecombustivel.api.custo.dto.CustoResponse;
import com.br.pdvpostodecombustivel.api.domain.entity.Custo;
import com.br.pdvpostodecombustivel.api.domain.repository.CustoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustoService {

    private final CustoRepository repository;

    public CustoService(CustoRepository repository) {
        this.repository = repository;
    }

    // Criar um novo custo
    public CustoResponse create(CustoRequest req) {
        Custo custo = new Custo(req.imposto(), req.custoVariavel(), req.custoFixo(), req.margemLucro(), req.dataProcessamento());
        repository.save(custo);
        return new CustoResponse(custo.getId(), custo.getImposto(), custo.getCustoVariavel(),
                custo.getCustoFixo(), custo.getMargemLucro(), custo.getDataProcessamento());
    }

    // Buscar por id
    public CustoResponse getById(long id) {
        Custo custo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Custo não encontrado"));
        return new CustoResponse(custo.getId(), custo.getImposto(), custo.getCustoVariavel(),
                custo.getCustoFixo(), custo.getMargemLucro(), custo.getDataProcessamento());
    }

    // Listar custos com paginação
    public List<CustoResponse> list(int page, int size, String sortBy, Sort.Direction dir) {
        return repository.findAll(Sort.by(dir, sortBy)).stream()
                .skip(page * size)
                .limit(size)
                .map(c -> new CustoResponse(c.getId(), c.getImposto(), c.getCustoVariavel(),
                        c.getCustoFixo(), c.getMargemLucro(), c.getDataProcessamento()))
                .collect(Collectors.toList());
    }

    // Atualizar custo
    public CustoResponse update(long id, CustoRequest req) {
        Custo custo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Custo não encontrado"));
        custo.setNome(req.imposto()); // corrigir setter correto
        custo.setCustoVariavel(req.custoVariavel());
        custo.setCustoFixo(req.custoFixo());
        custo.setMargemLucro(req.margemLucro());
        custo.setDataProcessamento(req.dataProcessamento());
        repository.save(custo);
        return new CustoResponse(custo.getId(), custo.getImposto(), custo.getCustoVariavel(),
                custo.getCustoFixo(), custo.getMargemLucro(), custo.getDataProcessamento());
    }

    // Atualização parcial
    public CustoResponse patch(long id, CustoRequest req) {
        Custo custo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Custo não encontrado"));
        if (req.imposto() != null) custo.setNome(req.imposto());
        if (req.custoVariavel() != null) custo.setCustoVariavel(req.custoVariavel());
        if (req.custoFixo() != null) custo.setCustoFixo(req.custoFixo());
        if (req.margemLucro() != null) custo.setMargemLucro(req.margemLucro());
        if (req.dataProcessamento() != null) custo.setDataProcessamento(req.dataProcessamento());
        repository.save(custo);
        return new CustoResponse(custo.getId(), custo.getImposto(), custo.getCustoVariavel(),
                custo.getCustoFixo(), custo.getMargemLucro(), custo.getDataProcessamento());
    }

    // Deletar por id
    public boolean delete(long id) {
        Optional<Custo> custoOpt = repository.findById(id);
        if (custoOpt.isPresent()) {
            repository.delete(custoOpt.get());
            return true;
        }
        return false;
    }
}
