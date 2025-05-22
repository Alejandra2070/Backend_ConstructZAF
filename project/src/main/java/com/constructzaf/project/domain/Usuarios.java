package com.constructzaf.project.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;

@Entity
@Builder
public class Usuarios implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    private String nombre;
    private String contraseña;
    private String apellido;
    private String correo;
    private Long telefono;
    private Long cedula;
    
    @Enumerated(EnumType.STRING)
    Role rol;
    
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

    public Usuarios(Long id_usuario, String nombre, String contraseña, String apellido, String correo, Long telefono,
            Long cedula, Role rol, LocalDate fecha_registro, List<Alquiler> alquiler, Login login, Reporte reportes,
            List<Reservas> reserva, List<Factura> factura) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.rol = rol;
        this.fecha_registro = fecha_registro;
        this.alquiler = alquiler;
        this.login = login;
        this.reportes = reportes;
        this.reserva = reserva;
        this.factura = factura;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getPassword() {
        return this.contraseña;
    }

    @Override
    public String getUsername() {
       return this.nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    

    
}