package es.iesjandula.Universidad.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.interfaces.IParseoAlumno;
import es.iesjandula.Universidad.models.Alumno;
import es.iesjandula.Universidad.repository.AlumnoRepository;
import es.iesjandula.Universidad.utils.UniversidadExceptions;

@Service
public class ParseoAlumnoImpl implements IParseoAlumno
{
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public void parseoAlumno(Scanner scanner) throws UniversidadExceptions 
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Alumno alumno = new Alumno();
			
			alumno.setIdAlumno(Integer.valueOf(valores[0]));
			
			alumno.setNif(valores[1]);
			
			alumno.setNombre(valores[2]);
			
			alumno.setFechNac(valores[3]);
			
			alumno.setApellido1(valores[4]);
			
			alumno.setApellido2(valores[5]);
			
			alumno.setCiudad(valores[6]);
			
			alumno.setDireccion(valores[7]);
			
			alumno.setSexo(valores[8]);
			
			alumno.setTelefono(valores[9]);
			
			this.alumnoRepository.saveAndFlush(alumno);			 			
		}
		
	}

}
