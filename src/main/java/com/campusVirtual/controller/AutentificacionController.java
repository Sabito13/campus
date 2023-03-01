package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("v1/auth")
public class AutentificacionController {
    
    @GetMapping(path ="/login")
    public String getLogin(){
        return "login succesful";
    }
}
