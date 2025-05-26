package com.constructzaf.project.infrastructure.repositorys.alquiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.AlquilerService;
import com.constructzaf.project.domain.Alquiler;
import com.constructzaf.project.domain.Herramientas;
import com.constructzaf.project.domain.DTO.AlquilerDTO;


@Service
public class AlquilerServiceImpl implements AlquilerService{

    @Autowired
    private AlquilerRepository alquilerRepository;


    public AlquilerServiceImpl(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }


    @Override
    public List<AlquilerDTO> findAll() {
    List<Alquiler> alquileres = alquilerRepository.findAll();
    List<AlquilerDTO> alquileresDTO = new ArrayList<>();

        for (Alquiler alquiler : alquileres) {
            AlquilerDTO dto = new AlquilerDTO(alquiler); 
            alquileresDTO.add(dto);
        }
        return alquileresDTO;
    }


    @Override
    public Optional<AlquilerDTO> findById(Long id) {
        return alquilerRepository.findById(id).map(alquiler -> new AlquilerDTO(alquiler));
    }

    private Alquiler toEntity(AlquilerDTO dto) {
    Alquiler alquiler = new Alquiler();
    alquiler.setId_alquiler(dto.getId_alquiler());
    alquiler.setEstado(dto.getEstado());
    return alquiler;
    }

    private AlquilerDTO toDTO(Alquiler alquiler) {
        AlquilerDTO dto = new AlquilerDTO();
        dto.setId_alquiler(alquiler.getId_alquiler());
        dto.setEstado(alquiler.getEstado());
        return dto;
    }

    
    @Override
    public Optional<AlquilerDTO> update(Long id, AlquilerDTO herra) {
    Optional<Alquiler> alquilerOptional = alquilerRepository.findById(id);

    if (alquilerOptional.isPresent()) {
        Alquiler alquiler = alquilerOptional.get();
        alquiler.setEstado(herra.getEstado());
        Alquiler actualizado = alquilerRepository.save(alquiler);

        return Optional.of(toDTO(actualizado));
    }

    return Optional.empty();
    }

}
