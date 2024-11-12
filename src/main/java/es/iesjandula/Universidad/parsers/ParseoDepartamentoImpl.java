package es.iesjandula.Universidad.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.interfaces.IParseoDepartamento;
import es.iesjandula.Universidad.models.Departamento;
import es.iesjandula.Universidad.repository.DepartamentoRepository;
import es.iesjandula.Universidad.utils.UniversidadExceptions;

@Service
public class ParseoDepartamentoImpl implements IParseoDepartamento
{
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public void parseoDepartamento(Scanner scanner) throws UniversidadExceptions 
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Departamento departamento = new Departamento();
			
			departamento.setId(Integer.valueOf(valores[0]));
			
			departamento.setNombre(valores[1]);
			
			this.departamentoRepository.saveAndFlush(departamento);			 			
		}		
	}
}
