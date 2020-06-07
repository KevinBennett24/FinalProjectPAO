package com.M029113.FinalProject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String nombre, apellido, email;
    Integer edad;

    @ManyToOne
    Materia materia;

    public Materia getMateria(){
        if (materia == null){
            materia = new Materia();
        }
        return materia;
    }

    public Profesor(){}

    public Profesor(String nombre, String apellido, String email, Integer edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
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

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
