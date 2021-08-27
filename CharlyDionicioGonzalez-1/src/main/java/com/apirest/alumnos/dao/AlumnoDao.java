package com.apirest.alumnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.apirest.alumnos.models.Alumno;

public interface AlumnoDao extends JpaRepository<Alumno, Integer>{

	//@Query(nativeQuery = true,value=""+ "insert into  materias (idalumno,materia)values()   ")
	//Alumno saveCalificacion(@Param(":idA") Integer idalumno, @Param(":califM") Integer materia);
		
	

	

}
