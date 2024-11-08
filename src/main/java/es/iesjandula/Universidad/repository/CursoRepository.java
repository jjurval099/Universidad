package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.Universidad.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>
{

}
