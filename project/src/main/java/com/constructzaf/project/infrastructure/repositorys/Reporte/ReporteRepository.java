package com.constructzaf.project.infrastructure.repositorys.Reporte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.constructzaf.project.domain.Reporte;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long>{

}
