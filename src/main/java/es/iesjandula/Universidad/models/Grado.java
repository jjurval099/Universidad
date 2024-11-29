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
@Table(name= "grado")
public class Grado 
{
	@Id
	@Column(length = 10)
	private Integer id;
	
	@Column(length = 5)
	private String nombre;
	
	//@OneToMany(mappedBy = "idGrado")
	//private List<Asignatura> asignatura;
	
}
