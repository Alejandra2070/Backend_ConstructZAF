package com.constructzaf.project.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("construc/herramientas")
public class HerramientasController {
    @Autowired
    private HerramientasService HerramientasService;

    
    @GetMapping
    public List<Herramientas> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Herramientas> herramientaView = HerramientasService.findById(id);
        if (herramientas.isPresent()) {
            return ResponseEntity.ok(herramientaView);
        }
        return ResponseEntity.notFound();
    }

    @PostMapping
    public ResponseEntity<Herramientas> createHerramienta(@RequestBody Herramienta herramienta)  {
        Herramienta save = HerramientasService.save(herramienta);

        return new ResponseEntity<>("La herramienta " + save);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Herramienta> actualizarHerramientas(@Valid @RequestBody Herramienta herramienta,@PathVariable Long id )  {
        
        Optional<Herramienta> herramientaUpdate = HerramientasService.update(id);

        if(herramientaUpdate.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED);
        }
        return ResponseEntity.notFound();
    }
    
}
