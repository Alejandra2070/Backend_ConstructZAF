package com.constructzaf.project.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.constructzaf.project.application.service.PagosService;
import com.constructzaf.project.domain.Pagos;

@RestController
@CrossOrigin
@RequestMapping("construc/pagos")
public class PagosController {

    @Autowired
    private PagosService PagosService;

    @GetMapping
    public List<Pagos> list(){
        return PagosService.findAll();
    }

}
