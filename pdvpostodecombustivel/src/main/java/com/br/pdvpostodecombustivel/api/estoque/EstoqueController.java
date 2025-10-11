package com.br.pdvpostodecombustivel.api.estoque;

import com.br.pdvpostodecombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostodecombustivel.api.estoque.dto.EstoqueResponse;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estoques")
public class EstoqueController {

    private final EstoqueService service;

    public EstoqueController(EstoqueService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstoqueResponse create(@RequestBody EstoqueRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public EstoqueResponse get(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<EstoqueResponse> list(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String sortBy,
                                      @RequestParam(defaultValue = "ASC") Sort.Direction dir) {
        return service.list(page, size, sortBy, dir);
    }

    @PutMapping("/{id}")
    public EstoqueResponse update(@PathVariable long id, @RequestBody EstoqueRequest req) {
        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public EstoqueResponse patch(@PathVariable long id, @RequestBody EstoqueRequest req) {
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
