package es.iesjandula.Universidad.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.Universidad.utils.UniversidadExceptions;
import prueba.MatriculaServices;

@RequestMapping(value = "universidad")
@RestController
public class RestHandler 
{
	
	private MatriculaServices matriculaServices;
	
	@RequestMapping(method = RequestMethod.POST, value = "/matricula/{idAlumno}/{idAsignatura}/{idCurso}")
    public ResponseEntity<?> insercionMatricula(@PathVariable("idAlumno") Integer idAlumno,
    											@PathVariable("idAsignatura") Integer idAsignatura,
    											@PathVariable("idCurso") Integer idCurso) throws UniversidadExceptions 
	{
		this.matriculaServices.insertarMatricula(idAlumno,idAsignatura,idCurso);
		
		return ResponseEntity.status(200).body("Insertado correctamente");		
    }

}
