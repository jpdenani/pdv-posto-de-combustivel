package com.br.pdvpostodecombustivel.api.bomba;

import com.br.pdvpostodecombustivel.api.bomba.dto.BombaRequest;
import com.br.pdvpostodecombustivel.api.bomba.dto.BombaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bombas")
public class BombaController {

    private final BombaService service;

    public BombaController(BombaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BombaResponse create(@RequestBody BombaRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public BombaResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<BombaResponse> list() {
        return service.listAll();
    }

    @PutMapping("/{id}")
    public BombaResponse update(@PathVariable Long id, @RequestBody BombaRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}