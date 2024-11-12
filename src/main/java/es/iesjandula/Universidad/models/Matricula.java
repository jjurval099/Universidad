package es.iesjandula.Universidad.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="matricula")
public class Matricula 
{
	@EmbeddedId
	private MatriculaId matriculaId;
	
	@ManyToOne
	@JoinColumn(name = "idAlumno")
	@MapsId("idAlumno")
	private Alumno idAlumno;
	
	@ManyToOne
	@JoinColumn(name = "idAsignatura")
	@MapsId("idAsignatura")
	private Asignatura idAsignatura;
	
	@ManyToOne
	@JoinColumn(name = "idCurso")
	@MapsId("idCurso")
	private Curso idCurso;
	
}
