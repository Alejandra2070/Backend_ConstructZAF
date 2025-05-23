package com.constructzaf.project.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroRequest {
   private String nombre;
    private String contraseña;
    private String apellido;
    private String correo;
    private Long telefono;
    private Long cedula;
    private LocalDate fecha_registro;
    Role role;
    
}
