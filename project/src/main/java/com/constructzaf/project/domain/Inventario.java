package com.constructzaf.project.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inventario;

    private boolean disponibilidad;
    private int cantidad;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private List<Reporte> reportes;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramientas herramienta;

    public Inventario() {
    }

    public Inventario(Long id_inventario, boolean disponibilidad, int cantidad, List<Reporte> reportes,
            Herramientas herramienta) {
        this.id_inventario = id_inventario;
        this.disponibilidad = disponibilidad;
        this.cantidad = cantidad;
        this.reportes = reportes;
        this.herramienta = herramienta;
    }

    public Long getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(Long id_inventario) {
        this.id_inventario = id_inventario;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    public Herramientas getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramientas herramienta) {
        this.herramienta = herramienta;
    }
}