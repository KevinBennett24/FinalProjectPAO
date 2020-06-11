package com.M029113.FinalProject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MateriaRepository extends CrudRepository<Materia,Integer> {
    List<Materia> findByNameOrderByNameDesc(String s);

}
