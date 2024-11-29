package es.iesjandula.Universidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.Universidad.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>
{
	public List<Alumno> findBynifContaining(String nif);
	
	List<Alumno> findByNifContainingAndCiudad(String nif, String ciudad);
}
