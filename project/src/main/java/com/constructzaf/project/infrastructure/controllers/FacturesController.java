package com.constructzaf.project.infrastructure.controllers;
/* 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.FacturasService;
import com.constructzaf.project.domain.Factura;

@RestController
@RequestMapping("construct/factures")
public class FacturesController {
    
    @Autowired
    private FacturasService FacturasService;

    @GetMapping
    public List<Factura> list(){
        return FacturasService.findAll();
    }    

    @PostMapping
    public ResponseEntity<Factura> crearfactura(@RequestBody Factura factura)  {
        Factura save = FacturasService.crearFactura(factura);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

}
*/