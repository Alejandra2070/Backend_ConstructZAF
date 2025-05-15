package com.constructzaf.project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_login;

    private enum rol{Administrador, Proveefor, Cliente};
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Login() {
    }

    public Login(Long id_login, String username, String password, Usuarios usuario) {
        this.id_login = id_login;
        this.username = username;
        this.password = password;
        this.usuario = usuario;
    }

    public Long getId_login() {
        return id_login;
    }

    public void setId_login(Long id_login) {
        this.id_login = id_login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}