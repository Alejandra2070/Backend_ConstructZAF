package com.constructzaf.project.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constructzaf.project.application.service.ReservasService;
import com.constructzaf.project.domain.Reservas;

@RestController
@RequestMapping("construc/reserva")
public class ReservaController {

    @Autowired
    private ReservasService reservasService;

    @GetMapping
    public List<Reservas> mostrarReservas(){
        return (List<Reservas>) reservasService.findAll();
    }

    @PostMapping
    public ResponseEntity<Reservas> crearReserva(@RequestBody Reservas reserva){
        Reservas save = reservasService.crearReservas(reserva);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Reservas> actualizarReserva(@PathVariable Long id, Reservas reservas){
        return ResponseEntity.ok().body(reservasService.actualizarReservas(id, reservas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservas> eliminarReserva(Long id){
        return ResponseEntity.ok().body(reservasService.eliminarReserva(id));
    }
}
