package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.Universidad.models.Matricula;
import es.iesjandula.Universidad.models.MatriculaId;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaId>
{

}
