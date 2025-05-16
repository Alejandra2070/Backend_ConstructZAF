package com.constructzaf.project.infrastructure.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.AlquilerService;
import com.constructzaf.project.domain.Alquiler;

@RestController
@RequestMapping("construc/login")
public class AlquilerController {
    
    @Autowired
    private AlquilerService alquilerService;

    @GetMapping
    public List<Alquiler> mostratAlquileres(){
        return alquilerService.findAll();
    }

    @PostMapping
    public ResponseEntity<Alquiler> crearAlquiler(@RequestBody Alquiler alquiler){
        Alquiler save = alquilerService.crearAlquiler(alquiler);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
