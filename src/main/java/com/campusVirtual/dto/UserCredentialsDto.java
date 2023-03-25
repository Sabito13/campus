package com.campusVirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter 
@Setter
public class UserCredentialsDto {

private String username;
private String password;


public UserCredentialsDto() {
    super();
}


}
