package com.constructzaf.project.application.service;

import java.util.List;
import java.util.Optional;

import com.constructzaf.project.domain.Alquiler;

public interface AlquilerService {

    List<Alquiler> findAll();

    public Alquiler crearAlquiler(Alquiler alquiler);

    public Optional<Alquiler> findById(Long id);
    
}
