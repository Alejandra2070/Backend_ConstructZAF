package com.constructzaf.project.infrastructure.repositorys.Pagos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.constructzaf.project.application.service.PagosService;
import com.constructzaf.project.domain.Pagos;

@Service
public class PagosServiceImlp implements PagosService{

    private PagosRepository pagosRepository;

    public PagosServiceImlp(PagosRepository pagosRepository) {
    this.pagosRepository = pagosRepository;
    }

    @Override
    public List<Pagos> findAll() {
        return (List<Pagos>) pagosRepository.findAll();
    }
    
}
