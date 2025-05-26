package com.constructzaf.project.application.service;

import java.util.List;
import java.util.Optional;
import com.constructzaf.project.domain.Usuarios;
import com.constructzaf.project.domain.DTO.UsuarioDTO;

public interface UsuariosService {
    List<UsuarioDTO> findAll();

    Optional<Usuarios> findById(Long id);

    public Usuarios crearUsuario(Usuarios usuarios);

    public Usuarios actualizarUsuario(Long id,Usuarios usuarios);

    public Usuarios eliminarUsuario(Long id);
}
