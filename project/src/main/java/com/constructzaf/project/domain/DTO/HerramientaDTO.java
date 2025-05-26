package com.constructzaf.project.domain.DTO;

import com.constructzaf.project.domain.Herramientas;

public class HerramientaDTO {
    public Long id_herramienta;
    public String nombre;
    public String descripcion;
    public String estado;
    public String imagen;
    public Long precio;

    public HerramientaDTO() {
    }

    public HerramientaDTO(Herramientas herramienta) {
        this.id_herramienta = herramienta.getId_herramienta();
        this.nombre = herramienta.getNombre();
        this.descripcion = herramienta.getDescripcion();
        this.estado = herramienta.getEstado();
        this.imagen = herramienta.getImagen();
        this.precio = herramienta.getPrecio();
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
}
