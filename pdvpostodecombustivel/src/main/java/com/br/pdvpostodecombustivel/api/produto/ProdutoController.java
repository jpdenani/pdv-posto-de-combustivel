package com.br.pdvpostodecombustivel.api.produto;

import com.br.pdvpostodecombustivel.api.produto.dto.ProdutoRequest;
import com.br.pdvpostodecombustivel.api.produto.dto.ProdutoResponse;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse create(@RequestBody ProdutoRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public ProdutoResponse get(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ProdutoResponse> list(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String sortBy,
                                      @RequestParam(defaultValue = "ASC") Sort.Direction dir) {
        return service.list(page, size, sortBy, dir);
    }

    @PutMapping("/{id}")
    public ProdutoResponse update(@PathVariable long id, @RequestBody ProdutoRequest req) {
        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public ProdutoResponse patch(@PathVariable long id, @RequestBody ProdutoRequest req) {
        return service.patch(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean excluido = service.delete(id);
        if (excluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
