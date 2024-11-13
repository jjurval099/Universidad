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
import es.iesjandula.Universidad.interfaces.IParseoProfesor;

@SpringBootApplication
public class UniversidadApplication implements CommandLineRunner
{
	@Autowired
	private IParseoDepartamento iParseoDepartamento;
	
	@Autowired
	private IParseoProfesor iParseoProfesor;
	
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
		
		String rutaFicheroProfesor = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"profesor.csv";
		File fileProfesor = new File(rutaFicheroProfesor);
		Scanner scanner1 = new Scanner(fileProfesor);
		iParseoProfesor.parseoProfesor(scanner1);
		
		String rutaFicheroGrado = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"grado.csv";
		File fileGrado = new File(rutaFicheroGrado);
		Scanner scanner2 = new Scanner(fileGrado);
		iParseoGrado.parseoGrado(scanner2);
		
		String rutaFicheroAsignaura = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"asignatura.csv";
		File fileAsignaura = new File(rutaFicheroAsignaura);
		Scanner scanner3 = new Scanner(fileAsignaura);
		iParseoGrado.parseoGrado(scanner3);
		
		String rutaFicheroAlumno = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"alumno.csv";
		File fileAlumno = new File(rutaFicheroAlumno);
		Scanner scanner4 = new Scanner(fileAlumno);
		iParseoAlumno.parseoAlumno(scanner4);
		
		String rutaFicheroCurso = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"curso.csv";
		File fileCurso = new File(rutaFicheroCurso);
		Scanner scanner5 = new Scanner(fileCurso);
		iParseoCurso.parseoCurso(scanner5);
		
		
		
	}

}
