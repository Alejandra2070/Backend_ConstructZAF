package com.constructzaf.project.infrastructure.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.UsuariosService;
import com.constructzaf.project.domain.Usuarios;


@RestController
@RequestMapping("construc/usuarios")
public class UsuarioController {

    private final UsuariosService usuariosService;

    public UsuarioController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> findAll(){
        return usuariosService.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuarios){
        Usuarios save =  usuariosService.crearUsuario(usuarios);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Long id,Usuarios usuarios){
        return ResponseEntity.ok().body(usuariosService.actualizarUsuario(id, usuarios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuarios> eliminarUsuario(@PathVariable Long id){
        return ResponseEntity.ok().body(usuariosService.eliminarUsuario(id));
    }

}
