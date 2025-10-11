package com.br.pdvpostodecombustivel.api.acesso;

import com.br.pdvpostodecombustivel.api.acesso.dto.AcessoRequest;
import com.br.pdvpostodecombustivel.api.acesso.dto.AcessoResponse;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/acessos")
public class AcessoController {

    private final AcessoService service;

    public AcessoController(AcessoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcessoResponse create(@RequestBody AcessoRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public AcessoResponse getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/usuario/{usuario}")
    public AcessoResponse getByUsuario(@PathVariable String usuario) {
        return service.getByUsuario(usuario);
    }

    @GetMapping
    public List<AcessoResponse> list(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sortBy,
                                     @RequestParam(defaultValue = "ASC") Sort.Direction dir) {
        return service.list(page, size, sortBy, dir);
    }

    @PutMapping("/{id}")
    public AcessoResponse update(@PathVariable long id, @RequestBody AcessoRequest req) {
        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public AcessoResponse patch(@PathVariable long id, @RequestBody AcessoRequest req) {
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
