package com.constructzaf.project.infrastructure.controllers.AuthController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.domain.Login;
import com.constructzaf.project.domain.RegistroRequest;
import com.constructzaf.project.domain.Token;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<Token> Login(@RequestBody Login login){

        return ResponseEntity.ok(authService.login(login));
    }

    @PostMapping(value = "registro")
    public ResponseEntity<Token> registro(@RequestBody RegistroRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }
    
}
