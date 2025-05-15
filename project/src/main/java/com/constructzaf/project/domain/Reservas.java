package com.constructzaf.project.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

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

    public Reservas() {
    }

    public Reservas(Long id_reserva, LocalDate fecha_reserva, Long deposito, LocalDate fecha_expiracion,
            Herramientas herramienta, Usuarios usuario) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.deposito = deposito;
        this.fecha_expiracion = fecha_expiracion;
        this.herramienta = herramienta;
        this.usuario = usuario;
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Long getDeposito() {
        return deposito;
    }

    public void setDeposito(Long deposito) {
        this.deposito = deposito;
    }

    public LocalDate getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(LocalDate fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public Herramientas getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramientas herramienta) {
        this.herramienta = herramienta;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}