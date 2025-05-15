package com.constructzaf.project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    private enum metodo_pago{Tarjeta, Transacción, Efectivo};

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reservas reserva;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "alquiler_id")
    private Alquiler alquiler;

    public Factura() {
    }

    public Factura(Long id_factura, Reservas reserva, Usuarios usuario, Alquiler alquiler) {
        this.id_factura = id_factura;
        this.reserva = reserva;
        this.usuario = usuario;
        this.alquiler = alquiler;
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
}