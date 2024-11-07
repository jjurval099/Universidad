package es.iesjandula.Universidad.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="curso")
public class Curso
{	
	@Id
	@Column(length = 10)
	private Long id;
	
	@Column(length = 4, nullable = false)
	private int aroInicio;
	
	@Column(length = 4, nullable = false)
	private int aroFin;
	
	@OneToMany(mappedBy = "idCurso")
	private List<Matricula>matricula;

}
