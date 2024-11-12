package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.Universidad.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>
{

}
