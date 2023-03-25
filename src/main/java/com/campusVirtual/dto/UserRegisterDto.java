package com.campusVirtual.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter 
@Setter
public class UserRegisterDto {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String mail;

    public UserRegisterDto(){}

}
