package com.campusVirtual.dto;

public class UserCredentialsDto {

private String documento;
private String password;

public UserCredentialsDto() {
    super();
}

public UserCredentialsDto(String documento, String password) {
    this.documento = documento;
    this.password = password;
}

public UserCredentialsDto(Integer documento, String password) {
    this.documento = ""+documento;
    this.password = password;
}

public String getDocumento() {
    return documento;
}

public void setDocumento(String documento) {
    this.documento = documento;
}

public void setDocumento(Integer documento) {
    this.documento = ""+documento;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}
