package com.constructzaf.project.domain;

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
public class Reporte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reporte;

    private String herramientas_mas_usadas;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    public Reporte(int id_reporte, String herramientas_mas_usadas, Usuarios usuarios, Inventario inventario) {
        this.id_reporte = id_reporte;
        this.herramientas_mas_usadas = herramientas_mas_usadas;
        this.usuario = usuarios;
        this.inventario = inventario;
    }
}