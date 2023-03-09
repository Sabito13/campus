package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.model.UserCredentials;
import com.campusVirtual.security.userPasswordFilter.UserDetailServiceImplementacion;



@RestController
@RequestMapping("v1/auth")
public class AutentificacionController {

    @Autowired
    UserDetailServiceImplementacion userDetailServiceImplementacion;
    
    @PostMapping(path ="/login")
    public String login(){
        return "login succesful";
    }

    @PostMapping(path ="/register")
    public String register(@RequestBody UserCredentials uc){
        return userDetailServiceImplementacion.saveUser(uc);
    }
}
