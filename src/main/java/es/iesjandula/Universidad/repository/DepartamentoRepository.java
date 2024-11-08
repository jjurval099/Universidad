package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.Universidad.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>
{

}
