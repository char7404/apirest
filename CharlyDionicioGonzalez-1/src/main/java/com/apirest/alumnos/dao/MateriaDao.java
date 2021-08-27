package com.apirest.alumnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.apirest.alumnos.models.Materia;

public interface MateriaDao extends JpaRepository<Materia, Integer>{

}
