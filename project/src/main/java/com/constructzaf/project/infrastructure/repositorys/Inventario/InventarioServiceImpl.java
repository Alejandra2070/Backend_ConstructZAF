package com.constructzaf.project.infrastructure.repositorys.Inventario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.InventarioService;
import com.constructzaf.project.domain.Inventario;


@Service
public class InventarioServiceImpl implements InventarioService{

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }
    /* 
    @Override
    public Inventario actualizInventario(Long id,Inventario inventario) {
        Inventario inventarioActualizado = inventarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada " + id));;

        if(inventario.getDisponibilidad() !=null){
            inventarioActualizado.setFecha_reserva(inventario.getFecha_reserva());
        }
        if(inventario.getCantidad() !=null){
            inventarioActualizado.setCantidad(inventario.getCantidad());
        }
        

        inventarioRepository.save(inventarioActualizado);

        return inventarioActualizado;
    }
    */

    @Override
    public Inventario actualizInventario(Long id, Inventario inventario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizInventario'");
    }
}
