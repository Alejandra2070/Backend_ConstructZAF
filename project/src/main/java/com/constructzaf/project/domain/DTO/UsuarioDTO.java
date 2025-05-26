package com.constructzaf.project.domain.DTO;

import com.constructzaf.project.domain.Role;
import com.constructzaf.project.domain.Usuarios;

import java.time.LocalDate;

public class UsuarioDTO {
    private Long id_usuario;
    public String nombre;
    public String contraseña;
    public String apellido;
    public String correo;
    public Long  telefono;
    public Long cedula;
    public Role rol;
    public LocalDate fecha_registro;
    
    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id_usuario, String nombre, String contraseña, String apellido, String correo, Long telefono,
        Long cedula, Role rol, LocalDate fecha_registro) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.rol = rol;
        this.fecha_registro = fecha_registro;
    }

    public UsuarioDTO(Usuarios usuario) {
        this.id_usuario = usuario.getId_usuario();
        this.nombre = usuario.getNombre();
        this.contraseña = usuario.getContraseña();
        this.apellido = usuario.getApellido();
        this.correo = usuario.getCorreo();
        this.telefono = usuario.getTelefono();
        this.cedula = usuario.getCedula();
        this.rol = usuario.getRol();
        this.fecha_registro = usuario.getFecha_registro();
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

}
