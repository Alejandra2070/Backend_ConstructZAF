package com.constructzaf.project.application.service;

import java.util.List;

import com.constructzaf.project.domain.Reporte;

public interface ReportesService {

    List<Reporte> findAll();

    Reporte save(Reporte reporte);

    Reporte crearReporteParaHerramienta(Long idHerramienta, Reporte reporte);

}