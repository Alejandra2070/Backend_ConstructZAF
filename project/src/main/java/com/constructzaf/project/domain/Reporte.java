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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    public Reporte() {
    }

    public Reporte(Long id_reporte, String herramientas_mas_usadas, Usuarios usuario, Inventario inventario) {
        this.id_reporte = id_reporte;
        this.herramientas_mas_usadas = herramientas_mas_usadas;
        this.usuario = usuario;
        this.inventario = inventario;
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}