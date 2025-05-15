package com.constructzaf.project.application.service;

import java.util.List;
import java.util.Optional;
import com.constructzaf.project.domain.Usuarios;

public interface UsuariosService {
    List<Usuarios> findAll();

    Optional<Usuarios> findById(Long id);

    public Usuarios crearUsuario(Usuarios usuarios);

    public Usuarios actualizarUsuario(Long id,Usuarios usuarios);
}
