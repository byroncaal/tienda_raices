package com.tejiendoraices.api.controller;

import com.tejiendoraices.api.dao.EstiloRepository;
import com.tejiendoraices.api.model.Estilo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estilos")
@CrossOrigin(origins = "*")
public class EstiloController {

    private final EstiloRepository repo;

    public EstiloController(EstiloRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Estilo> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estilo> obtener(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estilo> crear(@Valid @RequestBody Estilo estilo) {
        estilo.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(estilo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
        repo.deleteById(id);
        return ResponseEntity.ok("Eliminado");
    }
}