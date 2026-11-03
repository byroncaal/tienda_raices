package com.tejiendoraices.api.controller;

import com.tejiendoraices.api.dao.PrendaDao;
import com.tejiendoraices.api.model.Prenda;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prendas")
@CrossOrigin(origins = "*")
public class PrendaController {

    private final PrendaDao dao;

    public PrendaController(PrendaDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Prenda> listar(@RequestParam(required = false) String tipo) {
        if (tipo != null && !tipo.isBlank()) {
            return dao.listarPorTipo(tipo.toUpperCase());
        }
        return dao.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenda> obtener(@PathVariable Long id) {
        return dao.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prenda> crear(@Valid @RequestBody Prenda prenda) {
        prenda.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(dao.guardar(prenda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        return dao.eliminar(id)
                ? ResponseEntity.ok("Eliminado")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }
}