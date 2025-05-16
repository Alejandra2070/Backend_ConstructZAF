package com.constructzaf.project.infrastructure.repositorys.usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.constructzaf.project.application.service.UsuariosService;
import com.constructzaf.project.domain.Usuarios;

import jakarta.persistence.EntityNotFoundException;


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
        if(usuarios.getApellido() !=null){
            usuariosActualizado.setApellido(usuarios.getApellido());
        }
        if(usuarios.getCorreo() !=null){
            usuariosActualizado.setCorreo(usuarios.getCorreo());
        }
        if(usuarios.getTelefono() !=null){
            usuariosActualizado.setTelefono(usuarios.getTelefono());
        }
        if(usuarios.getCedula() !=null){
            usuariosActualizado.setCedula(usuarios.getCedula());
        }
        if(usuarios.getFecha_registro() !=null){
            usuariosActualizado.setFecha_registro(usuarios.getFecha_registro());
        }

        usuarioRepository.save(usuariosActualizado);

        return usuariosActualizado;
    }

    @Override
    public Usuarios eliminarUsuario(Long id) {
       Optional<Usuarios> usuario = usuarioRepository.findById(id);

       if (!usuario.isPresent()) {
            throw new EntityNotFoundException("el usuario no se encuentra registrado");
       }
       usuarioRepository.deleteById(id);
       
       return usuario.get();
    }

}