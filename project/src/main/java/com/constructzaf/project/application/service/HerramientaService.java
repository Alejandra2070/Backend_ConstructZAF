package com.constructzaf.project.application.service;

import java.util.List;
import java.util.Optional;

import com.constructzaf.project.domain.Herramientas;

public interface HerramientaService {
    List<Herramientas> findAll();

    Optional<Herramientas> findById(Long id);

    public Herramientas crearHerramienta(Herramientas herramienta);

    public Herramientas pathHerramienta(Long id, Herramientas herramienta);
}
