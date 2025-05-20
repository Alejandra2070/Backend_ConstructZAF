package com.constructzaf.project.exception;

public class AuthenticationException extends RuntimeException{

    // Credenciales del login sean invalidad
    public AuthenticationException(String message){
        super(message);
    }

}
