package com.M029113.FinalProject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfesorRepository extends CrudRepository<Profesor,Integer> {
    List<Profesor> findByEmailOrderByNameDesc(String s);

    List<Profesor> findByEmailContainingOrderByNameDesc(String s);

    List<Profesor> findByAgeGreaterThanEqual(int i);

    List<Profesor> findByEmailContainingAndAgeGreaterThanEqual(String s, int i);

}
