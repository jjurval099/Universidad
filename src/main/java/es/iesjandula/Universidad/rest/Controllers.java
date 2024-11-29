package es.iesjandula.Universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.repository.AlumnoRepository;
import es.iesjandula.Universidad.repository.CursoRepository;
import es.iesjandula.Universidad.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Controllers 
{
	@Autowired
	ProfesorRepository profesorRepository;

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@PostConstruct
	public void init()
	{		
		log.info("Profesor de genero Masculino");
		System.out.println(this.profesorRepository.findBysexo("Masculino"));
		
		log.info("Los 10 profesores mas viejos");
		//System.out.println(this.profesorRepository.findTop10ByOrderByfechNac());
		
		log.info("Profesor por nombre y apellido");
		System.out.println(this.profesorRepository.findByNombreAndApellido1("Carlos","Garcia"));
		
		log.info("Alumnos que contengan un numero en el nif");
		System.out.println(this.alumnoRepository.findBynifContaining("5"));
		
		log.info("Alumnos que contengan un numero en el nif y de una ciudad especifica");
		System.out.println(this.alumnoRepository.findByNifContainingAndCiudad("5","Madrid"));
		
		log.info("Cursos que comiencen por una fecha");
		System.out.println(this.cursoRepository.findByAroInicio(2021));
		
		log.info("Cursos cuya fecha este entre dos años");
		System.out.println(this.cursoRepository.findByAroInicioBetween(2021,2023));
	}
	
}
