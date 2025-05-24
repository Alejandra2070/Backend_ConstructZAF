package com.constructzaf.project.infrastructure.repositorys.Pagos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constructzaf.project.domain.Pagos;

public interface PagosRepository extends JpaRepository<Pagos,Long> {
    
}
