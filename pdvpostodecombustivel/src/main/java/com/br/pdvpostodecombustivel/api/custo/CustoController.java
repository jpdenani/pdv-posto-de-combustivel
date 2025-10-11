package com.br.pdvpostodecombustivel.api.custo;

import com.br.pdvpostodecombustivel.api.custo.dto.CustoRequest;
import com.br.pdvpostodecombustivel.api.custo.dto.CustoResponse;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/custos")
public class CustoController {

    private final CustoService service;

    public CustoController(CustoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustoResponse create(@RequestBody CustoRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public CustoResponse get(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CustoResponse> list(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @RequestParam(defaultValue = "ASC") Sort.Direction dir) {
        return service.list(page, size, sortBy, dir);
    }

    @PutMapping("/{id}")
    public CustoResponse update(@PathVariable long id, @RequestBody CustoRequest req) {
        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public CustoResponse patch(@PathVariable long id, @RequestBody CustoRequest req) {
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
