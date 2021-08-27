package com.apirest.alumnos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="materias")
public class Materia {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idMateria;
	
	@Column(name = "califEspanol")
	Integer califEspanol;
	
	@Column(name = "califMatematicas")
	Integer califMatematicas;

	@Column(name = "califQuimica")
	Integer califQuimica;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name =  "idalumno")
	Alumno alumno;
	
	
}
