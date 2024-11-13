package es.iesjandula.Universidad.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.interfaces.IParseoProfesor;
import es.iesjandula.Universidad.models.Departamento;
import es.iesjandula.Universidad.models.Profesor;
import es.iesjandula.Universidad.repository.DepartamentoRepository;
import es.iesjandula.Universidad.repository.ProfesorRepository;
import es.iesjandula.Universidad.utils.UniversidadExceptions;

@Service
public class ParseoProfesorImpl implements IParseoProfesor
{
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public void parseoProfesor(Scanner scanner) throws UniversidadExceptions 
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Profesor profesor = new Profesor();
			
			profesor.setId(Integer.valueOf(valores[0]));
			
			profesor.setNif(valores[1]);
			
			profesor.setNombre(valores[2]);
			
			profesor.setFechNac(valores[3]);
			
			profesor.setApellido1(valores[4]);
			
			profesor.setApellido2(valores[5]);
			
			profesor.setCiudad(valores[6]);
			
			profesor.setDireccion(valores[7]);
			
			profesor.setSexo(valores[8]);
			
			profesor.setTelefono(valores[9]);
			
			Optional<Departamento> optionalDepartamento = this.departamentoRepository.findById(Integer.valueOf(valores[10]));
			profesor.setIdDepartamento(optionalDepartamento.get());
			
			this.profesorRepository.saveAndFlush(profesor);			 			
		}
	}

}
