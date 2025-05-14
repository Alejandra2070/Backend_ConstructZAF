package com.constructzaf.project.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;

    private LocalDate fecha_reserva;
    private enum estado_devolucion{pendiente, activa, finalizada, cancelada};
    private Long deposito;
    private LocalDate fecha_expiracion;

    @ManyToOne
    @JoinColumn(name = "herramienta_id")
    private Herramientas herramienta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Reservas(int id_reserva, LocalDate fecha_reserva, Long deposito, LocalDate fecha_expiracion,
            Herramientas herramientas, Usuarios usuarios) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.deposito = deposito;
        this.fecha_expiracion = fecha_expiracion;
        this.herramienta = herramientas;
        this.usuario = usuarios;
    }
}