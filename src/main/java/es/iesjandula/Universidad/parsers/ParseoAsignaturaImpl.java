package es.iesjandula.Universidad.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.interfaces.IParseoAsignatura;
import es.iesjandula.Universidad.models.Asignatura;
import es.iesjandula.Universidad.models.Departamento;
import es.iesjandula.Universidad.models.Grado;
import es.iesjandula.Universidad.models.Profesor;
import es.iesjandula.Universidad.repository.AsignaturaRepository;
import es.iesjandula.Universidad.repository.GradoRepository;
import es.iesjandula.Universidad.repository.ProfesorRepository;
import es.iesjandula.Universidad.utils.UniversidadExceptions;

@Service
public class ParseoAsignaturaImpl implements IParseoAsignatura
{
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private GradoRepository gradoRepository;

	@Override
	public void parseoCurso(Scanner scanner) throws UniversidadExceptions
	{
		scanner.nextLine();
		
		while (scanner.hasNext())
		{
			
			while (scanner.hasNext()) 
			{
				String linea = scanner.nextLine();
				
				String [] valores = linea.split(",");
				
				Asignatura asignatura = new Asignatura();
				
				asignatura.setIdAsignatura(Integer.valueOf(valores[0]));
				
				asignatura.setCreditos(Integer.valueOf(valores[1]));
				
				asignatura.setCuatrimestre(Integer.valueOf(valores[2]));
				
				asignatura.setCurso(Integer.valueOf(valores[3]));
				
				asignatura.setNombre(valores[4]);
				
				asignatura.setTipo(valores[5]);
				
				Optional<Profesor> optionalProfesor = this.profesorRepository.findById(Integer.valueOf(valores[6]));
				asignatura.setIdProfesor(optionalProfesor.get());
				
				Optional<Grado> optionalGrado = this.gradoRepository.findById(Integer.valueOf(valores[7]));
				asignatura.setIdGrado(optionalGrado.get());
				
				this.asignaturaRepository.saveAndFlush(asignatura);			 			
			}			
		}
		
	}

}
