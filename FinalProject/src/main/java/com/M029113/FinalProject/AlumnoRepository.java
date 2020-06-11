package com.M029113.FinalProject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer> {
    List<Alumno> findByNameOrderByNameDesc(String s);

    List<Alumno> findByNameContainingOrderByNameDesc(String s);

    List<Alumno> findByEdadGreaterThanEqual(int i);

    List<Alumno> findByNameContainingAndEdadGreaterThanEqual(String s, int i);

}
