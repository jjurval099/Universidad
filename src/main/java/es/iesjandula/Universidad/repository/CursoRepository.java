package es.iesjandula.Universidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.Universidad.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>
{
	Curso findByAroInicio(Integer aroInicio);
	
	List<Curso> findByAroInicioBetween(Integer aroInicio, Integer aroFin);

}
