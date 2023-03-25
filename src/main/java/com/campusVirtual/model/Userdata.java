package com.campusVirtual.model;

import javax.persistence.*;


@Entity(name = "Userdata")
@Table(
    name="user_data",
    uniqueConstraints = {
        @UniqueConstraint(name="user_dni_constraint",columnNames = "user_name")
    })
public class Userdata {
    @Id
    @Column(
        name = "user_name",
        updatable = false,
        nullable = false,
        unique = true
    )
    private String username;


    @Column(
        name="password",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String password;

    @Column(
        name="mail",
        updatable = true,
        nullable = false,
        unique = true
    )
    private String mail;


    @Column(
        name="authorities",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String authorities = "ROLE_STUDENT";

    @Column(
        name="name",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String name;

    @Column(
        name="lastname",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String lastName;

    
    @OneToOne(
        mappedBy = "user",
        orphanRemoval = true
    )
    private Student student;

    @OneToOne(
        mappedBy = "user",
        orphanRemoval = true
    )
    private Professor professor;

    public Userdata(){}
    public Userdata(
        String username,
        String password,
        String name,
        String lastName,
        String mail){
        this.username = username;
        this.password = password;
        this.authorities = "ROLE_STUDENT";
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
    }


    public String getUsername() {
        return this.username;
    }


    public String getPassword() {
        return this.password;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public Student getStudent() {
        return this.student;
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

 
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addAuthorities(String authorities) {
        this.authorities += ","+authorities;
    }




}
