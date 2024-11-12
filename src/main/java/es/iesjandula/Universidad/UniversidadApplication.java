package es.iesjandula.Universidad;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.Universidad.interfaces.IParseoDepartamento;

@SpringBootApplication
public class UniversidadApplication implements CommandLineRunner
{
	@Autowired
	private IParseoDepartamento iParseoDepartamento;

	public static void main(String[] args)
	{
		SpringApplication.run(UniversidadApplication.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception
	{
		String rutaFichero = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"departamento.csv";
		File file = new File(rutaFichero);
		Scanner scanner = new Scanner(file);
		iParseoDepartamento.parseoDepartamento(scanner);
		
	}

}
