package com.constructzaf.project.infrastructure.repositorys.alquiler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructzaf.project.application.service.AlquilerService;
import com.constructzaf.project.domain.Alquiler;

@Service
public class AlquilerServiceImpl implements AlquilerService{

    @Autowired
    private AlquilerRepository alquilerRepository;


    public AlquilerServiceImpl(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @Override
    public List<Alquiler> findAll() {
        return (List<Alquiler>) alquilerRepository.findAll();
    }

    @Override
    public Alquiler crearAlquiler(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    @Override
    public Optional<Alquiler> findById(Long id) {
        return alquilerRepository.findById(id);
    }

}
