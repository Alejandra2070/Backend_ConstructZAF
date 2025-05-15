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
public class Herramientas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_herramienta;

    private String nombre;
    private String descripcion;
    private String estado;
    private String imagen;
    private Long precio;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    private List<Reservas> reserva;

    public Herramientas(int id_herramienta, String nombre, String descripcion, String estado, String imagen,
            Long precio, Inventario inventario, List<Reservas> reserva) {
        this.id_herramienta = id_herramienta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.imagen = imagen;
        this.precio = precio;
        this.inventario = inventario;
        this.reserva = reserva;
    }
}