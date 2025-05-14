package com.constructzaf.project.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("construct/fcatures")
public class FacturesController {
    
    @Autowired
    private FacturesService FacturesService;

    /* 
    @GetMapping
    public List<Herramientas> list(){
        return service.findAll();
    }
    */

    @PostMapping
    public ResponseEntity<Facturas> createHerramienta(@RequestBody Facturas factura)  {
        Facturas save = FacturesService.save(factura);

        return new ResponseEntity<>("La factura fue creada " + save);
    }
    
}
