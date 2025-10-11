package com.br.pdvpostodecombustivel.api.preco;

import com.br.pdvpostodecombustivel.api.preco.dto.PrecoRequest;
import com.br.pdvpostodecombustivel.api.preco.dto.PrecoResponse;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/precos")
public class PrecoController {

    private final PrecoService service;

    public PrecoController(PrecoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrecoResponse create(@RequestBody PrecoRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public PrecoResponse get(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<PrecoResponse> list(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @RequestParam(defaultValue = "ASC") Sort.Direction dir) {
        return service.list(page, size, sortBy, dir);
    }

    @PutMapping("/{id}")
    public PrecoResponse update(@PathVariable long id, @RequestBody PrecoRequest req) {
        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public PrecoResponse patch(@PathVariable long id, @RequestBody PrecoRequest req) {
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
