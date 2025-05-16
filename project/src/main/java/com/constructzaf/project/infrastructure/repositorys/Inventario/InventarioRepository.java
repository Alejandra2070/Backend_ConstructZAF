package com.constructzaf.project.infrastructure.repositorys.Inventario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.constructzaf.project.domain.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long>{

}
