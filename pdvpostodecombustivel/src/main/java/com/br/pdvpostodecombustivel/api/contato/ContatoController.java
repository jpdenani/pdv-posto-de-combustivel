package com.br.pdvpostodecombustivel.api.contato;

import com.br.pdvpostodecombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostodecombustivel.api.contato.dto.ContatoResponse;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contatos")
public class ContatoController {

    private final ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoResponse create(@RequestBody ContatoRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public ContatoResponse get(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ContatoResponse> list(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String sortBy,
                                      @RequestParam(defaultValue = "ASC") Sort.Direction dir) {
        return service.list(page, size, sortBy, dir);
    }

    @PutMapping("/{id}")
    public ContatoResponse update(@PathVariable long id, @RequestBody ContatoRequest req) {
        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public ContatoResponse patch(@PathVariable long id, @RequestBody ContatoRequest req) {
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
