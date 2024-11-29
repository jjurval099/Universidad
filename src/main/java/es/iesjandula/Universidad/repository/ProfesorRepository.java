package es.iesjandula.Universidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import es.iesjandula.Universidad.models.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>
{
	public List<Profesor> findBysexo(@Param(value="sexo")String sexo);
	
	public List<Profesor> findByNombreAndApellido1(String nombre, String apellido1);


}
