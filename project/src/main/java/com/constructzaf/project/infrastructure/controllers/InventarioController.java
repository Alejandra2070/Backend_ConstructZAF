package com.constructzaf.project.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("construc/inventario")
public class InventarioController {
     
    @Autowired
    private InventarioServide InventarioService;

    /* 
    @GetMapping
    public List<Inventario> list(){
        return inventarioservice.findAll();
    }
    */

    @PostMapping
    public ResponseEntity<Inventario> create(@RequestBody Inventario inventario)  {
        Inventario save = InventarioService.save(inventario);

        return new ResponseEntity<>("La factura fue creada " + save);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Invnetario> actualizarInventario(@Valid @RequestBody Herramienta herramienta,@PathVariable Long id )  {
        
        Optional<Herramienta> herramientaUpdate = HerramientasService.update(id);

        if(herramientaUpdate.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED);
        }
        return ResponseEntity.notFound();
    }

}
