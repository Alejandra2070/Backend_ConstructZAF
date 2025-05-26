package com.constructzaf.project.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    private String nombre_usuario;
    private LocalDate fecha_pago;
    private Long monto_total;
    private String metodo_pago;

    public Factura() {
    }

    public Factura(Long id_factura, String nombre_usuario, LocalDate fecha_pago, Long monto_total, String metodo_pago) {
        this.id_factura = id_factura;
        this.nombre_usuario = nombre_usuario;
        this.fecha_pago = fecha_pago;
        this.monto_total = monto_total;
        this.metodo_pago = metodo_pago;
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Long getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Long monto_total) {
        this.monto_total = monto_total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}