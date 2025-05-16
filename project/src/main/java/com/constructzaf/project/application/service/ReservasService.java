package com.constructzaf.project.application.service;

import java.util.List;

import com.constructzaf.project.domain.Reservas;

public interface ReservasService {
    List<Reservas> findAll();

    public Reservas crearReservas(Reservas reservaseservas);

    public Reservas actualizarReservas(Long id, Reservas reservas);

    public Reservas eliminarReserva(Long id);
}
