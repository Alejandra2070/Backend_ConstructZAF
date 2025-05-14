package com.constructzaf.project.domain;

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
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_factura;

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
}
