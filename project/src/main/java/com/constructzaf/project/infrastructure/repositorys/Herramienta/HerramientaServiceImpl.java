package com.constructzaf.project.infrastructure.repositorys.Herramienta;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.HerramientaService;
import com.constructzaf.project.domain.Herramientas;

@Service
public class HerramientaServiceImpl implements HerramientaService{

    private final HerramientasRepository herramientasRepository;

    public HerramientaServiceImpl(HerramientasRepository herramientasRepository) {
        this.herramientasRepository = herramientasRepository;
    }

    @Override
    public List<Herramientas> findAll(){
        return (List<Herramientas>) herramientasRepository.findAll();
    }

    @Override
    public Optional<Herramientas> findById(Long id) { 
        return herramientasRepository.findById(id);
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
}
