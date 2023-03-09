package com.campusVirtual.model;

import javax.persistence.*;


@Entity(name = "AuthCredentials")
@Table(
    name="authcredentials",
    uniqueConstraints = {
        @UniqueConstraint(name="user_dni_constraint",columnNames = "dni")
    })
public class AuthCredentials {
    @Id
    @Column(
        name = "dni",
        updatable = false,
        nullable = false,
        unique = true
    )
    private Long dni;

    @Column(
        name="nombre",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String nombre;


    @Column(
        name="password",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String password;

    public AuthCredentials(){}
    public AuthCredentials(Long dni,String nombre,String password){
        this.dni = dni;
        this.nombre = nombre;
        this.password = password;
    }


    public Long getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
