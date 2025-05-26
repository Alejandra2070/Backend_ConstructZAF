package com.constructzaf.project.infrastructure.repositorys.Reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.ReportesService;
import com.constructzaf.project.domain.Herramientas;
import com.constructzaf.project.domain.Reporte;
import com.constructzaf.project.infrastructure.repositorys.Herramienta.HerramientasRepository;

@Service
public class ReporteServiceImpl implements ReportesService {
     
    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private HerramientasRepository herramientasRepository;

    @Override
    public List<Reporte> findAll() {
       return reporteRepository.findAll();
    }

    @Override
    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    @Override
    public Reporte crearReporteParaHerramienta(Long idHerramienta, Reporte reporte) {
        Herramientas herramienta = herramientasRepository.findById(idHerramienta).orElseThrow(() -> new RuntimeException("Herramienta no encontrada con ID: " + idHerramienta));
        
        reporte.setHerramienta(herramienta);
        return reporteRepository.save(reporte);
    }

    
}
