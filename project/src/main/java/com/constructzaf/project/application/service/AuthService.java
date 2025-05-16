package com.constructzaf.project.application.service;

import org.springframework.stereotype.Service;

import com.constructzaf.project.domain.Login;
import com.constructzaf.project.domain.Usuarios;

import ch.qos.logback.core.subst.Token;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    public Token login(Login login){
        return null;
    }

    public Token register(Usuarios usuarios){
        return null;
    }
}
