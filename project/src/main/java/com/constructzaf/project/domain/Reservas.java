package com.constructzaf.project.domain;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    private String nombre_herramienta;
    private String nombre_usuario;
    private boolean confirmacion;
    private LocalDate fecha_reserva;
    
    private String estado_devolucion;
    
    private Long deposito;
    private LocalDate fecha_expiracion;
    
    @ManyToOne
    @JoinColumn(name = "herramienta_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Herramientas herramienta;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuarios usuario;
    
    public Reservas() {}
    
    public Reservas(Long id_reserva, String nombre_herramienta, String nombre_usuario, boolean confirmacion,
    LocalDate fecha_reserva, String estado_devolucion, Long deposito, LocalDate fecha_expiracion,
    Herramientas herramienta, Usuarios usuario) {
        this.id_reserva = id_reserva;
        this.nombre_herramienta = nombre_herramienta;
        this.nombre_usuario = nombre_usuario;
        this.confirmacion = confirmacion;
        this.fecha_reserva = fecha_reserva;
        this.estado_devolucion = estado_devolucion;
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
    
    public String getNombreHerramienta() {
        return nombre_herramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombre_herramienta = nombreHerramienta;
    }
    public boolean isConfirmacion() {
        return confirmacion;
    }
    
    public void setConfirmacion(boolean confirmacion) {
        this.confirmacion = confirmacion;
    }
    public String getNombreUsuario() {
        return nombre_usuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombre_usuario = nombreUsuario;
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

    public String getEstado_devolucion() {
        return estado_devolucion;
    }

    public void setEstado_devolucion(String estado_devolucion) {
        this.estado_devolucion = estado_devolucion;
    }
}