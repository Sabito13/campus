package com.campusVirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter 
@Setter
public class UserCredentialsDto {

private Long documento;
private String password;


public UserCredentialsDto() {
    super();
}


public String getDocumentoString() {
    return ""+this.documento;
}

}
