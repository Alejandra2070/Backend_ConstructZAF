package com.constructzaf.project.application.service;

import java.util.List;

import com.constructzaf.project.domain.Alquiler;

public interface AlquilerService {

    List<Alquiler> findAll();

    public Alquiler crearAlquiler(Alquiler alquiler);
    
}
