package com.constructzaf.project.infrastructure.repositorys.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import com.constructzaf.project.domain.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{

    
}
