package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="v2")
public class ProfesorController {
    @GetMapping(path="/profesor")
    public String getProfesores(){
       return "profesor 123";
    }
}
