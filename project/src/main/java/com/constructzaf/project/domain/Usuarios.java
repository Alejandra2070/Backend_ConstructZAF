package com.constructzaf.project.domain;

import java.time.LocalDate;
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
    private String apellido;
    private String correo;
    private Long telefono;
    private Long cedula;
    private enum rol{Administrador, Proveedor, Cliente};
    private LocalDate fecha_registro;

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

    public Usuarios(Long id_herramienta, String nombre, String apellido, String correo, Long telefono, Long cedula,
            LocalDate fecha_registro, List<Alquiler> alquiler, Login login, Reporte reportes, List<Reservas> reserva,
            List<Factura> factura) {
        this.id_herramienta = id_herramienta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.fecha_registro = fecha_registro;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
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