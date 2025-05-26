package com.constructzaf.project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reporte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reporte;

    private String herramientas_mas_usadas;
    private String descripcion_daño;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "herramienta_id")
    private Herramientas herramienta;

    public Reporte() {
    }

    public Reporte(Long id_reporte, String herramientas_mas_usadas, String descripcion_daño, Usuarios usuario,
        Herramientas herramienta) {
        this.id_reporte = id_reporte;
        this.herramientas_mas_usadas = herramientas_mas_usadas;
        this.descripcion_daño = descripcion_daño;
        this.usuario = usuario;
        this.herramienta = herramienta;
    }

    public Long getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(Long id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getHerramientas_mas_usadas() {
        return herramientas_mas_usadas;
    }

    public void setHerramientas_mas_usadas(String herramientas_mas_usadas) {
        this.herramientas_mas_usadas = herramientas_mas_usadas;
    }

    public String getDescripcion_daño() {
        return descripcion_daño;
    }

    public void setDescripcion_daño(String descripcion_daño) {
        this.descripcion_daño = descripcion_daño;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Herramientas getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramientas herramienta) {
        this.herramienta = herramienta;
    }
}