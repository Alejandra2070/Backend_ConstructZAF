package com.constructzaf.project.infrastructure.controllers.AuthController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.constructzaf.project.Jwt.JwtService;
import com.constructzaf.project.domain.Login;
import com.constructzaf.project.domain.RegistroRequest;
import com.constructzaf.project.domain.Role;
import com.constructzaf.project.domain.Token;
import com.constructzaf.project.domain.Usuarios;
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
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        UserDetails user = usuarioRepository.findByNombre(login.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);

        List<String> roles = user.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

        return Token.builder()
            .token(token)
            .roles(roles)
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
        .rol(request.getRole())
        .build();

        usuarioRepository.save(user);

        return Token.builder()
        .token(jwtService.getToken(user))
        .build();

    }

}
