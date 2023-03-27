package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.exception.ErrorDetails;
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
    
    @Operation(summary = "Get an user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the user",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDetails.class))}),
        @ApiResponse(responseCode = "404", description = "User not found",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDetails.class))})
                        })
    @PostMapping(path ="/login")
    public String register(@RequestBody UserCredentialsDto urdto){
       return "login";
    }


    @Operation(summary = "Add a new user to the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Create user",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = UserRegisterDto.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid field",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDetails.class))}),
        @ApiResponse(responseCode = "400", description = "User Already Exists ",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDetails.class))})
                        })

    @PostMapping(path ="/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDto urdto){
        userDetailServiceImplementacion.saveUser(urdto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
         
    }
}
