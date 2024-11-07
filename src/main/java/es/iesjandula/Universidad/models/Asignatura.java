package es.iesjandula.Universidad.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="asignatura")
public class Asignatura 
{
	@Id
	@Column(length = 10)
	private Long id;
	
	@Column(length = 10)
	private int creditos;
	
	@Column(length = 10)
	private int cuatrimestre;
	
	@Column(length = 10)
	private int curso;
	
	@Column(length = 15)
	private String nombre;
	
	@Column(length = 10)
	private String tipo;
	
	@ManyToOne
	private Grado idGrado;
	
	@ManyToOne
	private Profesor idProfesor;
	
	@OneToMany(mappedBy = "idAsignatura")
	private List<Matricula>matricula;

}