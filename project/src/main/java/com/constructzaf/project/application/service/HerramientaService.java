package com.constructzaf.project.application.service;

import java.util.List;
import java.util.Optional;

import com.constructzaf.project.domain.Herramientas;
import com.constructzaf.project.domain.DTO.HerramientaDTO;

public interface HerramientaService {
    List<HerramientaDTO> findAll();

    Optional<HerramientaDTO> findById(Long id);

    public Herramientas crearHerramienta(Herramientas herramienta);

    public Herramientas pathHerramienta(Long id, Herramientas herramienta);

    Optional<Herramientas> update(Long id, Herramientas herramienta);
}
