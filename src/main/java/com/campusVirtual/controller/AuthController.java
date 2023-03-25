package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.dto.UserCredentialsDto;
import com.campusVirtual.security.userPasswordFilter.UserDetailServiceImplementacion;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("v1/auth")
public class AuthController {

    @Autowired
    UserDetailServiceImplementacion userDetailServiceImplementacion;
    
    @Operation(summary = "Log in user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserCredentialsDto.class)) }),
  })
    @PostMapping(path ="/login")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String register(@RequestBody UserCredentialsDto urdto){
       return "login";
    }


    @Operation(summary = "Register new User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserRegisterDto.class)) }),
  })
    @PostMapping(path ="/register")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String register(@RequestBody UserRegisterDto urdto){
        return userDetailServiceImplementacion.saveUser(urdto);
    }
}
