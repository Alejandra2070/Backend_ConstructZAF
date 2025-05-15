package com.constructzaf.project.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_herramienta;

    private String nombre;
    private String descripcion;
    private String estado;
    private String imagen;
    private Long precio;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Alquiler> alquiler;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Login login;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Reporte reportes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reservas> reserva;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Factura> factura;
   

    public Usuarios() {
    }
    
    public Usuarios(Long id_herramienta, String nombre, String descripcion, String estado, String imagen, Long precio,
            List<Alquiler> alquiler, Login login, Reporte reportes, List<Reservas> reserva, List<Factura> factura) {
        this.id_herramienta = id_herramienta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.imagen = imagen;
        this.precio = precio;
        this.alquiler = alquiler;
        this.login = login;
        this.reportes = reportes;
        this.reserva = reserva;
        this.factura = factura;
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

    public List<Alquiler> getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(List<Alquiler> alquiler) {
        this.alquiler = alquiler;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Reporte getReportes() {
        return reportes;
    }

    public void setReportes(Reporte reportes) {
        this.reportes = reportes;
    }

    public List<Reservas> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reservas> reserva) {
        this.reserva = reserva;
    }

    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }
}