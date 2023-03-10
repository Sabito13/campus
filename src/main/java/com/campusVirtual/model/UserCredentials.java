package com.campusVirtual.model;

import javax.persistence.*;


@Entity(name = "AuthCredentials")
@Table(
    name="authcredentials",
    uniqueConstraints = {
        @UniqueConstraint(name="user_dni_constraint",columnNames = "documento")
    })
public class UserCredentials {
    @Id
    @Column(
        name = "documento",
        updatable = false,
        nullable = false,
        unique = true
    )
    private Long documento;


    @Column(
        name="password",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String password;


    @Column(
        name="authorities",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String authorities = "ROLE_ALUMNO";


    public UserCredentials(){}
    public UserCredentials(Long documento,String password){
        this.documento = documento;
        this.password = password;
        this.authorities = "ROLE_ALUMNO";
    }


    public Long getDocumento() {
        return this.documento;
    }


    public String getPassword() {
        return this.password;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public void addAuthorities(String authorities) {
        this.authorities += ","+authorities;
    }




}
