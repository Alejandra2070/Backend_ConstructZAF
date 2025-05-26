package com.constructzaf.project.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.AlquilerService;
import com.constructzaf.project.domain.DTO.AlquilerDTO;


@RestController
@CrossOrigin
@RequestMapping("construc/alquiler")
public class AlquilerController {
    
    @Autowired
    private AlquilerService alquilerService;

    @GetMapping
    public List<AlquilerDTO> mostratAlquileres(){
        return alquilerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AlquilerDTO> mostrarAlquileresId(@PathVariable Long id){
        return alquilerService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlquilerDTO> actualizarEstado(@PathVariable Long id, @RequestBody AlquilerDTO alquilerDTO) {
        Optional<AlquilerDTO> alquilerActualizado = alquilerService.update(id, alquilerDTO);
        
        if (alquilerActualizado.isPresent()) {
            return ResponseEntity.ok(alquilerActualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
