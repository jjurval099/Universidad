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
@Table(name = "alumno" )
public class Alumno
{
	@Id
	@Column(length = 10)
	private Long id;
	
	@Column(length = 9, nullable = false)
	private String nif;
	
	@Column(length = 25, nullable = false)
	private String nombre;
	
	@Column(length = 10, nullable = false)
	private String fechNac;

	@Column(length = 25)
	private String apellido1;
	
	@Column(length = 25)
	private String apellido2;
	
	@Column(length = 25)
	private String ciudad;
	
	@Column(length = 25)
	private String direccion;
	
	@Column(length = 25)
	private String sexo;
	
	@Column(length = 25)
	private String telefono;
	
	@OneToMany(mappedBy = "idAlumno")
	private List<Matricula>matricula;
	
}
