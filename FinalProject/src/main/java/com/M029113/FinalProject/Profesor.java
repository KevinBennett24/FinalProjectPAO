package com.M029113.FinalProject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name, lastname, email;
    Integer edad;

    @OneToOne
    Materia materia;

    public Materia getMateria(){
        if (materia == null){
            materia = new Materia();
        }
        return materia;
    }

    public Profesor(){}

    public Profesor(String name, String lastname, String email, Integer edad){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
