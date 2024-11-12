package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.Universidad.models.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>
{

}
