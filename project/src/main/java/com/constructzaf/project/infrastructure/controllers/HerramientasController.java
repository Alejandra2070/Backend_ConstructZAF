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
import com.constructzaf.project.domain.Herramienta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("construc/herramientas")
public class HerramientasController {
    @Autowired
    private HerramientaService HerramientasService;

    
    @GetMapping
    public List<Herramienta> list(){
        return HerramientasService.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Herramienta> view(@PathVariable Long id) {
        Optional<Herramienta> herramientaView = HerramientasService.findById(id);
        if (herramientaView.isPresent()) {
            return ResponseEntity.ok(herramientaView.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PostMapping
    public ResponseEntity<Herramienta> createHerramienta(@RequestBody Herramienta herramienta)  {
        Herramienta save = HerramientasService.crearHerramienta(herramienta);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Herramienta> parcialUpdate(@PathVariable Long id, @RequestBody Herramienta herramienta){
        return ResponseEntity.ok().body(HerramientasService.pathHerramienta(id,herramienta));
    }

    /* 
    @PutMapping("/{id}")
    public ResponseEntity<Herramienta> actualizarHerramientas(@Valid @RequestBody Herramienta herramienta,@PathVariable Long id )  {
        
        Optional<Herramienta> herramientaUpdate = HerramientasService.update(id);

        if(herramientaUpdate.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED);
        }
        return ResponseEntity.notFound();
    }
    */
}
