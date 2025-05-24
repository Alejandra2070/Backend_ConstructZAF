package com.constructzaf.project.domain.DTO;

public class AlquilerDTO {

    public String nombre_usuario;
    public String nombre_herramienta;
    public String fecha_inicio;
    public String fecha_fin;
    public Long precio_dia;
    public Long precio_total;
    public String estado;
    public Long id_usuario;
    
    public AlquilerDTO() {
    }
    public AlquilerDTO(String nombre_usuario, String nombre_herramienta, String fecha_inicio, String fecha_fin,
            Long precio_dia, Long precio_total, String estado, Long id_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.nombre_herramienta = nombre_herramienta;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.precio_dia = precio_dia;
        this.precio_total = precio_total;
        this.estado = estado;
        this.id_usuario = id_usuario;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public String getNombre_herramienta() {
        return nombre_herramienta;
    }
    public void setNombre_herramienta(String nombre_herramienta) {
        this.nombre_herramienta = nombre_herramienta;
    }
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public String getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public Long getPrecio_dia() {
        return precio_dia;
    }
    public void setPrecio_dia(Long precio_dia) {
        this.precio_dia = precio_dia;
    }
    public Long getPrecio_total() {
        return precio_total;
    }
    public void setPrecio_total(Long precio_total) {
        this.precio_total = precio_total;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    
}
