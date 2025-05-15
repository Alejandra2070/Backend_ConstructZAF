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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_inventario;

    private boolean disponibilidad;
    private int cantidad;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private List<Reporte> reportes;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramientas herramienta;

    public Inventario(int id_inventario, boolean disponibilidad, int cantidad, List<Reporte> reportes) {
        this.id_inventario = id_inventario;
        this.disponibilidad = disponibilidad;
        this.cantidad = cantidad;
        this.reportes = reportes;
    }
}