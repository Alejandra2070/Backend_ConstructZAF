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

    private String nombre_usuario;
    private String nombre_herramienta;
    private LocalDate fecha_incio;
    private LocalDate fecha_fin;
    private Long precio_dia;
    private Long precio_total;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Alquiler() {
    }

    public Alquiler(Long id_alquiler, String nombre_usuario, String nombre_herramienta, LocalDate fecha_incio,
            LocalDate fecha_fin, Long precio_dia, Long precio_total, String estado, Usuarios usuario) {
        this.id_alquiler = id_alquiler;
        this.nombre_usuario = nombre_usuario;
        this.nombre_herramienta = nombre_herramienta;
        this.fecha_incio = fecha_incio;
        this.fecha_fin = fecha_fin;
        this.precio_dia = precio_dia;
        this.precio_total = precio_total;
        this.estado = estado;
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

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre_herramienta() {
        return nombre_herramienta;
    }

    public void setNombre_herramienta(String nombre_herramienta) {
        this.nombre_herramienta = nombre_herramienta;
    }

    public Long getPrecio_dia() {
        return precio_dia;
    }

    public void setPrecio_dia(Long precio_dia) {
        this.precio_dia = precio_dia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}