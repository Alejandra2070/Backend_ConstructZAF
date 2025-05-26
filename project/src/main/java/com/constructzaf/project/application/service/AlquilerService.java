package com.constructzaf.project.application.service;

import java.util.List;
import java.util.Optional;
import com.constructzaf.project.domain.DTO.AlquilerDTO;

public interface AlquilerService {

    List<AlquilerDTO> findAll();

    Optional<AlquilerDTO> findById(Long id);

    Optional<AlquilerDTO> update(Long id, AlquilerDTO alquiler);
    
}
