package com.M029113.FinalProject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name, lastname, email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Alumno(String name, String lastname, String email, Integer edad){
        this.name = name;
        this.lastname = lastname;
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
