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
public class Herramientas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_herramienta;

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

    public Herramientas() {
    }

    public Herramientas(Long id_herramienta, String nombre, String descripcion, String estado, String imagen,
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

    public Long getId_herramienta() {
        return id_herramienta;
    }

    public void setId_herramienta(Long id_herramienta) {
        this.id_herramienta = id_herramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Reservas> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reservas> reserva) {
        this.reserva = reserva;
    }
}