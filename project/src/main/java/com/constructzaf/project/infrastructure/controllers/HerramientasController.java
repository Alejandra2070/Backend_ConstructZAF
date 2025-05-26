package com.constructzaf.project.infrastructure.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.HerramientaService;
import com.constructzaf.project.domain.Herramientas;
import com.constructzaf.project.domain.DTO.HerramientaDTO;
import com.constructzaf.project.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("construc/herramientas")
public class HerramientasController {
    @Autowired
    private HerramientaService HerramientasService;

    
    @GetMapping
    public List<HerramientaDTO> list(){
        return HerramientasService.findAll();
    }
    
   @GetMapping("/{id}")
    public Optional<HerramientaDTO> mostrarAlquileresId(@PathVariable Long id){
        return HerramientasService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Herramientas> createHerramienta(@Valid @RequestBody Herramientas herramienta)  {
        Herramientas save = HerramientasService.crearHerramienta(herramienta);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Herramientas> parcialUpdate(@PathVariable Long id, @RequestBody Herramientas herramienta){
        return ResponseEntity.ok().body(HerramientasService.pathHerramienta(id,herramienta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Herramientas herramienta, BindingResult result, @PathVariable Long id) {
        Optional<Herramientas> productOptional = HerramientasService.update(id, herramienta);
        if (productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }
        throw new ResourceNotFoundException("herramienta no encontrada: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Herramientas> eliminarHerramienta(@PathVariable Long id){
        Herramientas eliminado = HerramientasService.eliminarHerramienta(id);
        return ResponseEntity.ok(eliminado);
    }
}
