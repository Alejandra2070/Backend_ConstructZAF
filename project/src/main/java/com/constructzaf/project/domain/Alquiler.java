package com.constructzaf.project.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Alquiler {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alquiler;

    private LocalDate fecha_incio;
    private LocalDate fecha_fin;
    private Long precio_total;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuarios usuario;

    public Alquiler(int id_alquiler, LocalDate fecha_incio, LocalDate fecha_fin, Long precio_total, Usuarios usuario) {
        this.id_alquiler = id_alquiler;
        this.fecha_incio = fecha_incio;
        this.fecha_fin = fecha_fin;
        this.precio_total = precio_total;
        this.usuario = usuario;
    }
}
