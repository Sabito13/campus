package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.*;



@RestController("/v1/autentificar")
public class AutentificacionController {
    
    @GetMapping("/login")
    public String getHola(){
        return "hola";
    }
}
