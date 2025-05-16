package com.constructzaf.project.infrastructure.repositorys.Reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.ReportesService;
import com.constructzaf.project.domain.Reporte;

@Service
public class ReporteServiceImpl implements ReportesService {
     
    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public List<Reporte> findAll() {
       return reporteRepository.findAll();
    }

    
}
