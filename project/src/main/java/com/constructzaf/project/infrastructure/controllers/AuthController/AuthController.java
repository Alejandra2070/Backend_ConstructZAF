package com.constructzaf.project.infrastructure.controllers.AuthController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constructzaf.project.application.service.AuthService;
import com.constructzaf.project.domain.Login;
import com.constructzaf.project.domain.Token;
import com.constructzaf.project.domain.Usuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<Token> Login(@RequestBody Login login){

        return ResponseEntity.ok(authService.login(login));
    }

    @PostMapping(value = "registro")
    public ResponseEntity<Token> registro(@RequestBody Usuarios usuarios) {

        return ResponseEntity.ok(authService.register(usuarios));
    }
    
}
