package es.iesjandula.Universidad.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.interfaces.IParseoCurso;
import es.iesjandula.Universidad.models.Curso;
import es.iesjandula.Universidad.repository.CursoRepository;
import es.iesjandula.Universidad.utils.UniversidadExceptions;

@Service
public class ParseoCursoImpl implements IParseoCurso
{
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void parseoCurso(Scanner scanner) throws UniversidadExceptions 
	{
		
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Curso curso = new Curso();
			
			curso.setIdCurso(Integer.valueOf(valores[0]));
			
			curso.setAroInicio(Integer.valueOf(valores[1]));
			
			curso.setAroFin(Integer.valueOf(valores[2]));
			
			this.cursoRepository.saveAndFlush(curso);			 			
		}
		
	}
}
