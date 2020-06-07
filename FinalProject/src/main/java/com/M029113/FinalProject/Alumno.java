package com.M029113.FinalProject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String nombre, apellido, email;
    Integer edad, semestre;

    @ManyToMany
    List<Materia> materias;

    public List<Materia> getMaterias(){
        if (materias == null){
            materias = new ArrayList<>();
        }
        return materias;
    }

    public Alumno(){}

    public Alumno(String nombre, String apellido, String email, Integer edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.semestre = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
}
