package com.constructzaf.project.infrastructure.controllers.AuthController;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.constructzaf.project.Jwt.JwtService;
import com.constructzaf.project.domain.Login;
import com.constructzaf.project.domain.RegistroRequest;
import com.constructzaf.project.domain.Role;
import com.constructzaf.project.domain.Token;
import com.constructzaf.project.domain.Usuarios;
import com.constructzaf.project.exception.AuthenticationException;
import com.constructzaf.project.exception.ResourceNotFoundException;
import com.constructzaf.project.infrastructure.repositorys.usuario.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public Token login(Login login) {

        UserDetails users = usuarioRepository.findByNombre(login.getUsername())
            .orElseThrow(() -> new AuthenticationException("El usuario " + login.getUsername() + " no fue encontrado"));

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        UserDetails user = usuarioRepository.findByNombre(login.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return Token.builder()
            .token(token)
            .build();
    }

    public Token register(RegistroRequest request) {
        Usuarios user = Usuarios.builder()
        .nombre(request.getNombre())
        .contraseña(passwordEncoder.encode(request.getContraseña()))
        .apellido(request.getApellido())
        .correo(request.getCorreo())
        .telefono(request.getTelefono())
        .cedula(request.getCedula())
        .fecha_registro(request.getFecha_registro())
        .rol(Role.USER)
        .build();

        usuarioRepository.save(user);

        return Token.builder()
        .token(jwtService.getToken(user))
        .build();

    }

}
