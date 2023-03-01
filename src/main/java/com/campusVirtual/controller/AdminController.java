package com.campusVirtual.controller;




import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="v1/api/admin")
public class AdminController {

    @PostMapping
    public String crearAdmin(){
        return "ADMIN CREADO";
    }

   



}
