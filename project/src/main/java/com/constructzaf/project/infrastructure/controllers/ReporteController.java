package com.constructzaf.project.infrastructure.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.ReportesService;
import com.constructzaf.project.domain.Reporte;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/construc/reportes")
@CrossOrigin
public class ReporteController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping
    public List<Reporte> obtenerTodosLosReportes() {
        return reportesService.findAll();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Reporte> crearReporteParaHerramienta(
        @PathVariable("id") Long idHerramienta,
        @RequestBody Reporte reporte) {

        Reporte nuevoReporte = reportesService.crearReporteParaHerramienta(idHerramienta, reporte);
        return ResponseEntity.ok(nuevoReporte);
    }
    
}
