
package com.br.pdvpostodecombustivel.api.acesso;

import com.br.pdvpostodecombustivel.api.domain.entity.Acesso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/acessos")
public class AcessoController {

    private final AcessoService service;

    public AcessoController(AcessoService service) {
        this.service = service;
    }

    @PostMapping
    public Acesso create(@RequestBody Acesso acesso) {
        return service.create(acesso);
    }

    @GetMapping
    public List<Acesso> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acesso> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acesso> update(@PathVariable Long id, @RequestBody Acesso acesso) {
        try {
            Acesso updated = service.update(id, acesso);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}