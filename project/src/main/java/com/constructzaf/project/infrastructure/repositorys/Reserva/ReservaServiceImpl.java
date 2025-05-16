package com.constructzaf.project.infrastructure.repositorys.Reserva;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructzaf.project.application.service.ReservasService;
import com.constructzaf.project.domain.Reservas;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaServiceImpl implements ReservasService{

    @Autowired
    private ReservaRepository reservaRepository;


    @Override
    public List<Reservas> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Reservas crearReservas(Reservas reservaseservas) {
       return reservaRepository.save(reservaseservas);
    }

    @Override
    public Reservas actualizarReservas(Long id, Reservas reservas) {
       Reservas reservaActualizada = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada " + id));;

        if(reservas.getFecha_reserva() !=null){
            reservaActualizada.setFecha_reserva(reservas.getFecha_reserva());
        }
        if(reservas.getDeposito() !=null){
            reservaActualizada.setDeposito(reservas.getDeposito());
        }
        if(reservas.getFecha_expiracion() !=null){
            reservaActualizada.setFecha_expiracion(reservas.getFecha_expiracion());
        }

        reservaRepository.save(reservaActualizada);

        return reservaActualizada;
       
    }

    @Override
    public Reservas eliminarReserva(Long id) {
        Optional<Reservas> reserva = reservaRepository.findById(id);

        if (!reserva.isPresent()) {
            throw new EntityNotFoundException("La reserva no se encuentra registrada");
        }

        reservaRepository.deleteById(id);

        return reserva.get();
    }

}
