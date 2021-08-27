package com.apirest.alumnos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.alumnos.dao.AlumnoDao;
import com.apirest.alumnos.dao.MateriaDao;
import com.apirest.alumnos.models.Alumno;
import com.apirest.alumnos.models.Materia;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/registro")
public class AlumnoController {

	@Autowired
	private AlumnoDao alumnoDAO;
	@Autowired
	private MateriaDao materiaDao;

	// regresa un objeto
	@RequestMapping("obtiene/alumnos") //endpoint que obtiene los alumnos registrados
	public ResponseEntity<List<Alumno>> obtieneAlumnos() {
		List<Alumno> alumnos = alumnoDAO.findAll();
		return ResponseEntity.ok(alumnos);
	}

	@PostMapping("/nuevo/alumno")//endpoint que permite registrar un nuevo alumno
	public ResponseEntity<Alumno> registraAlumno(@RequestBody Alumno alumno) {
		Alumno nuevoRegistro = alumnoDAO.save(alumno);
		return ResponseEntity.ok(nuevoRegistro);
	}

	@PostMapping("/registra/calificacion") //endpoint que permite registrar una calificacion 
	public ResponseEntity<Materia> registraCalificacion(@RequestBody Materia materia) {
		Materia califMateria = materiaDao.save(materia);
		return ResponseEntity.ok(califMateria);
	}

	@PutMapping("/actualiza/calificacion/{idMateria}") //endpoint que permite actualizar la calificacon de las materias 
	public ResponseEntity<Materia> actualizaMateria(@RequestBody Materia materia, @PathVariable Integer idMateria) {
		Optional<Materia> Opcionmateria = materiaDao.findById(idMateria);

		Materia actualizaMateria = Opcionmateria.get();
		actualizaMateria.setCalifEspanol(materia.getCalifEspanol());
		actualizaMateria.setCalifMatematicas(materia.getCalifMatematicas());
		actualizaMateria.setCalifQuimica(materia.getCalifQuimica());
		materiaDao.save(actualizaMateria);
		return ResponseEntity.ok(actualizaMateria);
	}

	@DeleteMapping("/elimina/calificacion/{id}") //endpoint que permite eliminar una materia
	public ResponseEntity<Void> eliminaCalificacion(@PathVariable("id") Integer idMateria) {
		materiaDao.deleteById(idMateria);
		return ResponseEntity.ok(null);
	}

//	@RequestMapping("obtiene/alumnos/calif") //endpoint que obtiene los alumnos registrados con sus materias ****
//	public ResponseEntity<List<Materia>> obtienealunosCalif() {
//		List<Materia> calificacion = materiaDao.findAll();
//		return ResponseEntity.ok(calificacion);
//	}

}


