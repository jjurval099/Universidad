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
@Table(name = "departamento")
public class Departamento 
{
	@Id
	@Column(length = 10)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "idDepartamento")
	private List<Profesor>profesor;
	
}
