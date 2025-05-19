package com.constructzaf.project.infrastructure.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.HerramientaService;
import com.constructzaf.project.domain.Herramientas;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("construc/herramientas")
public class HerramientasController {
    @Autowired
    private HerramientaService HerramientasService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') or hasAuthority('PROVEEDOR')")
    @GetMapping
    public List<Herramientas> list(){
        return HerramientasService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Herramientas> view(@PathVariable Long id) {
        Optional<Herramientas> herramientaView = HerramientasService.findById(id);
        if (herramientaView.isPresent()) {
            return ResponseEntity.ok(herramientaView.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PostMapping
    public ResponseEntity<Herramientas> createHerramienta(@RequestBody Herramientas herramienta)  {
        Herramientas save = HerramientasService.crearHerramienta(herramienta);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Herramientas> parcialUpdate(@PathVariable Long id, @RequestBody Herramientas herramienta){
        return ResponseEntity.ok().body(HerramientasService.pathHerramienta(id,herramienta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Herramientas herramienta, BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return ResponseEntity.badRequest().body("el usuario no existe");
        }
        Optional<Herramientas> productOptional = HerramientasService.update(id, herramienta);
        if (productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
