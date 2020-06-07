package com.M029113.FinalProject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer> {
    List<Alumno> findByEmailOrderByNameDesc(String s);

    List<Alumno> findByEmailContainingOrderByNameDesc(String s);

    List<Alumno> findByAgeGreaterThanEqual(int i);

    List<Alumno> findByEmailContainingAndAgeGreaterThanEqual(String s, int i);

}
