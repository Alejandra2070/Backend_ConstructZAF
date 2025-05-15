package com.constructzaf.project.infrastructure.repositorys.usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.UsuariosService;
import com.constructzaf.project.domain.Usuarios;


@Service
public class usuarioServiceImpl implements UsuariosService{

    private UsuarioRepository usuarioRepository;

    public usuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuarios> findAll() {
       return (List<Usuarios>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuarios> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuarios crearUsuario(Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }

    @Override
    public Usuarios actualizarUsuario(Long id, Usuarios usuarios) {
        Usuarios usuariosActualizado = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("usuario no encontrado con id:" + id));;

        if(usuarios.getNombre() !=null){
            usuariosActualizado.setNombre(usuarios.getNombre());
        }
        if(usuarios.getDescripcion() !=null){
            usuariosActualizado.setDescripcion(usuarios.getDescripcion());
        }
        if(usuarios.getEstado() !=null){
            usuariosActualizado.setEstado(usuarios.getEstado());
        }
        if(usuarios.getImagen() !=null){
            usuariosActualizado.setImagen(usuarios.getImagen());
        }
        if(usuarios.getPrecio() !=null){
            usuariosActualizado.setPrecio(usuarios.getPrecio());
        }

        usuarioRepository.save(usuariosActualizado);

        return usuariosActualizado;
    }

}