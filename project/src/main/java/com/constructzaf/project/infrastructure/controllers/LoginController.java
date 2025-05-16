package com.constructzaf.project.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.LoginService;
import com.constructzaf.project.domain.Login;

@RestController
@RequestMapping("construc/login")
public class LoginController {
    
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Login> crearLogin(@RequestBody Login login){
        Login save = loginService.crearLogin(login);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
    
}
