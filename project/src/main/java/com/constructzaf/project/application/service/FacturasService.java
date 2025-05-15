package com.constructzaf.project.application.service;

import java.util.List;

import com.constructzaf.project.domain.Factura;

public interface FacturasService{

    List<Factura> findAll();
    
    public Factura crearFactura(Factura factura);

}
