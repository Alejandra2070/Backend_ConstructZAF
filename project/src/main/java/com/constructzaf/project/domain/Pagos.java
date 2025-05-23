package com.constructzaf.project.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;

    private String nombre_usuario;
    private Long monto_total;
    private String estado;
    private LocalDate fecha_pago;
    private int dias_alquilados;
    private String metodo_pago;

    @OneToMany(mappedBy = "pagos", cascade = CascadeType.ALL)
    private List<Herramientas> herramienta;

    public Pagos(Long id_pago, String nombre_usuario, Long monto_total, String estado, LocalDate fecha_pago,
            int dias_alquilados, String metodo_pago, List<Herramientas> herramienta) {
        this.id_pago = id_pago;
        this.nombre_usuario = nombre_usuario;
        this.monto_total = monto_total;
        this.estado = estado;
        this.fecha_pago = fecha_pago;
        this.dias_alquilados = dias_alquilados;
        this.metodo_pago = metodo_pago;
        this.herramienta = herramienta;
    }
    
    public Long getId_pago() {
        return id_pago;
    }
    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public Long getMonto_total() {
        return monto_total;
    }
    public void setMonto_total(Long monto_total) {
        this.monto_total = monto_total;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getFecha_pago() {
        return fecha_pago;
    }
    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    public int getDias_alquilados() {
        return dias_alquilados;
    }
    public void setDias_alquilados(int dias_alquilados) {
        this.dias_alquilados = dias_alquilados;
    }
    public String getMetodo_pago() {
        return metodo_pago;
    }
    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public List<Herramientas> getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(List<Herramientas> herramienta) {
        this.herramienta = herramienta;
    }
}