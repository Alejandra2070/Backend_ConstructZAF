package com.constructzaf.project.infrastructure.repositorys.Herramienta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.HerramientaService;
import com.constructzaf.project.domain.Alquiler;
import com.constructzaf.project.domain.Herramientas;
import com.constructzaf.project.domain.DTO.AlquilerDTO;
import com.constructzaf.project.domain.DTO.HerramientaDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HerramientaServiceImpl implements HerramientaService{

    private final HerramientasRepository herramientasRepository;

    public HerramientaServiceImpl(HerramientasRepository herramientasRepository) {
        this.herramientasRepository = herramientasRepository;
    }

    @Override
    public List<HerramientaDTO> findAll() {
        List<Herramientas> herramienta = herramientasRepository.findAll();
        List<HerramientaDTO> herramientaDTO = new ArrayList<>();

        for (Herramientas herra : herramienta) {
            HerramientaDTO dto = new HerramientaDTO(herra); 
            herramientaDTO.add(dto);
        }
        return herramientaDTO;
    }

    @Override
    public Optional<HerramientaDTO> findById(Long id) {
        return herramientasRepository.findById(id).map(herramienta -> new HerramientaDTO(herramienta));
    }

    @Override
    public Herramientas crearHerramienta(Herramientas herramienta) {
       return herramientasRepository.save(herramienta);
    }

    @Override
    public Herramientas pathHerramienta(Long id, Herramientas herramienta) {
        Herramientas herramientaActualizada = herramientasRepository.findById(id).orElseThrow(() -> new RuntimeException("Herramienta no encontrada con id: " + id));;

        if(herramienta.getNombre() !=null){
            herramientaActualizada.setNombre(herramienta.getNombre());
        }
        if(herramienta.getDescripcion() !=null){
            herramientaActualizada.setDescripcion(herramienta.getDescripcion());
        }
        if(herramienta.getEstado() !=null){
            herramientaActualizada.setEstado(herramienta.getEstado());
        }
        if(herramienta.getImagen() !=null){
            herramientaActualizada.setImagen(herramienta.getImagen());
        }
        if(herramienta.getPrecio() !=null){
            herramientaActualizada.setPrecio(herramienta.getPrecio());
        }
        herramientasRepository.save(herramientaActualizada);

        return herramientaActualizada;
    }

    @Override
    public Optional<Herramientas> update(Long id, Herramientas product) {
        Optional<Herramientas> herramientasOptional = herramientasRepository.findById(id);
        if (herramientasOptional.isPresent()) {
            Herramientas herramienta = herramientasOptional.orElseThrow();
            
            herramienta.setNombre(product.getNombre());
            herramienta.setDescripcion(product.getDescripcion());
            herramienta.setEstado(product.getEstado());
            herramienta.setImagen(product.getImagen());
            herramienta.setPrecio(product.getPrecio());
            return Optional.of(herramientasRepository.save(herramienta));
        }
        return herramientasOptional;
    }

    @Override
    public Herramientas eliminarHerramienta(Long id) {
        Optional<Herramientas> herramienta = herramientasRepository.findById(id);

        if (!herramienta.isPresent()) {
            throw new EntityNotFoundException("la herramienta no se encuentra registrada");
        }
        herramientasRepository.deleteById(id);
       
        return herramienta.get();
    }
}
