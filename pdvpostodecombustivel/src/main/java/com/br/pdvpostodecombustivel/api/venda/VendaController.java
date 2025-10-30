package com.br.pdvpostodecombustivel.api.venda;

import com.br.pdvpostodecombustivel.api.venda.dto.VendaRequest;
import com.br.pdvpostodecombustivel.api.venda.dto.VendaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaResponse realizarVenda(@RequestBody VendaRequest req) {
        return service.realizarVenda(req);
    }

    @GetMapping
    public List<VendaResponse> list() {
        return service.listAll();
    }
}