package com.constructzaf.project.infrastructure.repositorys.alquiler;

import java.util.List;

import org.springframework.stereotype.Service;

import com.constructzaf.project.application.service.AlquilerService;
import com.constructzaf.project.domain.Alquiler;

@Service
public class AlquilerServiceImpl implements AlquilerService{

    private AlquilerRepository alquilerRepository;

    @Override
    public List<Alquiler> findAll() {
        return (List<Alquiler>) alquilerRepository.findAll();
    }

    @Override
    public Alquiler crearAlquiler(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

}
