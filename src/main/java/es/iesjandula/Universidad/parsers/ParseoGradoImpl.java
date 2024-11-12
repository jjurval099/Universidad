package es.iesjandula.Universidad.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.interfaces.IParseoGrado;
import es.iesjandula.Universidad.models.Grado;
import es.iesjandula.Universidad.repository.GradoRepository;
import es.iesjandula.Universidad.utils.UniversidadExceptions;

@Service
public class ParseoGradoImpl implements IParseoGrado
{
	@Autowired
	private GradoRepository gradoRepository;

	@Override
	public void parseoGrado(Scanner scanner) throws UniversidadExceptions
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Grado grado = new Grado();
			
			grado.setId(Integer.valueOf(valores[0]));
			
			grado.setNombre(valores[1]);
			
			this.gradoRepository.saveAndFlush(grado);			 			
		}	
		
	}

}
