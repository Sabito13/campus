package com.campusVirtual.dto;

public class ProfesorDto {
    private Long id;
    private String nombre;
    private String especialidad;

    public ProfesorDto(){}
    public ProfesorDto(
        Long id,
        String nombre,
        String especialidad){
            this.id=id;
            this.nombre=nombre;
            this.especialidad=especialidad;
        }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }
}
