package com.constructzaf.project.infrastructure.repositorys.Factura;

import java.util.List;

import org.springframework.stereotype.Service;

import com.constructzaf.project.application.service.FacturasService;
import com.constructzaf.project.domain.Factura;

@Service
public class FacturasServiceImpl implements FacturasService{

    private FacturasRepository facturasRepository;

    public FacturasServiceImpl(FacturasRepository facturasRepository) {
        this.facturasRepository = facturasRepository;
    }


    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturasRepository.findAll();
    }

    @Override
    public Factura crearFactura(Factura factura) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearFactura'");
    }

}
