package com.campusVirtual.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.service.IAdminService;




@RestController
@RequestMapping(path="v1/admin")
public class AdminController {
    

    @Autowired
    private IAdminService adminService;


   
    @PostMapping(path ="user/{username}/role/admin")
    public void asignarRoleUser(
        @PathVariable("username") String username){
         this.adminService.setRoleUser("ROLE_ADMIN", username);             
        }

        @PostMapping(path ="user/{id}/role/professor")
    public void asignarRoleProfessorUser(
        @PathVariable("username") String username){
         this.adminService.setRoleUser("ROLE_PROFESSOR", username);             
        }

}
