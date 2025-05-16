package com.constructzaf.project.application.service;

import java.util.List;

import com.constructzaf.project.domain.Inventario;

public interface InventarioService {

    List<Inventario> findAll();

    public Inventario actualizInventario(Long id,Inventario inventario);
    
}
