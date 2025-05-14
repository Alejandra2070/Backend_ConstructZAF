package com.constructzaf.project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_login;

    private enum rol{Administrador, Proveefor, Cliente};
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Login(int id_login, String username, String password, Usuarios usuario) {
        this.id_login = id_login;
        this.username = username;
        this.password = password;
        this.usuario = usuario;
    }
}