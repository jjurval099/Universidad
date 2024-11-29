package es.iesjandula.Universidad.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Embeddable
public class MatriculaId implements Serializable
{
	/** Serial Version UID */
	private static final long serialVersionUID = -433468710270308424L;
	
	/** Atributo - ID Alumno */
	private Integer idAlumno;
	
	/** Atributo - ID Asignatura */
	private Integer idAsignatura;
	
	/** Atributo - ID Curso */
	private Integer idCurso;

}
