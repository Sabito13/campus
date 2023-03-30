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
    private String name;
    private String lastName;
    private String mail;
    private String role;

    public UserRegisterDto(){}

}
