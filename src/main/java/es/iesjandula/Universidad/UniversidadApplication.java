package es.iesjandula.Universidad;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.Universidad.interfaces.IParseoAlumno;
import es.iesjandula.Universidad.interfaces.IParseoCurso;
import es.iesjandula.Universidad.interfaces.IParseoDepartamento;
import es.iesjandula.Universidad.interfaces.IParseoGrado;

@SpringBootApplication
public class UniversidadApplication implements CommandLineRunner
{
	@Autowired
	private IParseoDepartamento iParseoDepartamento;
	
	@Autowired
	private IParseoAlumno iParseoAlumno;
	
	@Autowired
	private IParseoCurso iParseoCurso;
	
	@Autowired
	private IParseoGrado iParseoGrado;

	public static void main(String[] args)
	{
		SpringApplication.run(UniversidadApplication.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception
	{
		String rutaFicheroDepartamento = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"departamento.csv";
		File fileDepartamento = new File(rutaFicheroDepartamento);
		Scanner scanner = new Scanner(fileDepartamento);
		iParseoDepartamento.parseoDepartamento(scanner);
		
		String rutaFicheroAlumno = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"alumno.csv";
		File fileAlumno = new File(rutaFicheroAlumno);
		Scanner scanner2 = new Scanner(fileAlumno);
		iParseoAlumno.parseoAlumno(scanner2);
		
		String rutaFicheroCurso = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"curso.csv";
		File fileCurso = new File(rutaFicheroCurso);
		Scanner scanner3 = new Scanner(fileCurso);
		iParseoCurso.parseoCurso(scanner3);
		
		String rutaFicheroGrado = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"grado.csv";
		File fileGrado = new File(rutaFicheroGrado);
		Scanner scanner4 = new Scanner(fileGrado);
		iParseoGrado.parseoGrado(scanner4);
		
	}

}
