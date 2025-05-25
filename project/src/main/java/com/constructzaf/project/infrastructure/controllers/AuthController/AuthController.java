package com.constructzaf.project.infrastructure.controllers.AuthController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<?> Login(@RequestBody Login login) {
        try {
            return ResponseEntity.ok(authService.login(login));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al iniciar sesión");
        }
    }

    @PostMapping(value = "registro")    
    public ResponseEntity<?> registro(@RequestBody RegistroRequest request) {
        try{
            return ResponseEntity.ok(authService.register(request));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al registrar el usuario");
        }
    }
    
}
