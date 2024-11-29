package prueba;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Alumno;
import es.iesjandula.Universidad.models.Asignatura;
import es.iesjandula.Universidad.models.Curso;
import es.iesjandula.Universidad.models.Matricula;
import es.iesjandula.Universidad.repository.AlumnoRepository;
import es.iesjandula.Universidad.repository.AsignaturaRepository;
import es.iesjandula.Universidad.repository.CursoRepository;
import es.iesjandula.Universidad.repository.MatriculaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MatriculaServices 
{

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
		
	Matricula matricula = new Matricula();
	
	Asignatura asignatura = new Asignatura();

	public void insertarMatricula(Integer idAlumno, Integer idAsignatura, Integer idCurso)
	{
		Optional<Alumno>optionalAlumno = this.alumnoRepository.findById(Integer.valueOf(idAlumno));
		
		if(!optionalAlumno.isPresent())
		{
			log.error("Alumno no existe");
		}
		
		matricula.setIdAlumno(optionalAlumno.get());
		
		Optional<Asignatura>optionalAsignatura = this.asignaturaRepository.findById(Integer.valueOf(idAsignatura));
		
		if(!optionalAsignatura.isPresent())
		{
			log.error("Asignatura no existe");
		}
		
		matricula.setIdAsignatura(optionalAsignatura.get());
		
		Optional<Curso>optionalCurso = this.cursoRepository.findById(Integer.valueOf(idCurso));
		
		if(!optionalCurso.isPresent())
		{
			log.error("Curso no existe");
		}
		
		matricula.setIdCurso(optionalCurso.get());
		
		//MatriculaId matriculaId = new MatriculaId(optionalAlumno.get(),optionalAsignatura.get(),optionalCurso.get());
				
		//matricula.setMatriculaId(matriculaId);
		
		this.matriculaRepository.saveAndFlush(matricula);
	    
	} 

}
