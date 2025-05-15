package com.constructzaf.project.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Alquiler {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alquiler;

    private LocalDate fecha_incio;
    private LocalDate fecha_fin;
    private Long precio_total;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuarios usuario;

    public Alquiler() {
    }

    public Alquiler(Long id_alquiler, LocalDate fecha_incio, LocalDate fecha_fin, Long precio_total, Usuarios usuario) {
        this.id_alquiler = id_alquiler;
        this.fecha_incio = fecha_incio;
        this.fecha_fin = fecha_fin;
        this.precio_total = precio_total;
        this.usuario = usuario;
    }

    public Long getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(Long id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public LocalDate getFecha_incio() {
        return fecha_incio;
    }

    public void setFecha_incio(LocalDate fecha_incio) {
        this.fecha_incio = fecha_incio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Long getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Long precio_total) {
        this.precio_total = precio_total;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
}