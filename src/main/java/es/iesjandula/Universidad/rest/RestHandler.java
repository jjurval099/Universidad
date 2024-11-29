package es.iesjandula.Universidad.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.Universidad.services.ProfesorServices;
import es.iesjandula.Universidad.utils.UniversidadExceptions;
import prueba.MatriculaServices;

@RequestMapping(value = "universidad")
@RestController
public class RestHandler 
{
	
	private MatriculaServices matriculaServices;
	
	private ProfesorServices profesorServices;
	
	@RequestMapping(method = RequestMethod.POST, value = "/matricula/{idAlumno}/{idAsignatura}/{idCurso}")
    public ResponseEntity<?> insercionMatricula(@PathVariable("idAlumno") Integer idAlumno,
    											@PathVariable("idAsignatura") Integer idAsignatura,
    											@PathVariable("idCurso") Integer idCurso) throws UniversidadExceptions 
	{
		this.matriculaServices.insertarMatricula(idAlumno,idAsignatura,idCurso);
		
		return ResponseEntity.status(200).body("Insertado correctamente");		
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/profesor")
	public ResponseEntity<?> insercionProfesor(
	    @RequestHeader("idProfesor") Integer idProfesor,
	    @RequestHeader("nif") String nif,
	    @RequestHeader("nombre") String nombre,
	    @RequestHeader("apellido1") String apellido1,
	    @RequestHeader("apellido2") String apellido2,
	    @RequestHeader("fechNac") String fechNac,
	    @RequestHeader("ciudad") String ciudad,
	    @RequestHeader("direccion") String direccion,
	    @RequestHeader("sexo") String sexo,
	    @RequestHeader("telefono") String telefono,
	    @RequestHeader("idDepartamento") Integer idDepartamento
	) throws UniversidadExceptions 
	{
	    
	    // Llamamos al servicio para insertar el profesor
	    this.profesorServices.insertarProfesor(idProfesor, nif, nombre, apellido1, apellido2, fechNac, ciudad, direccion, sexo, telefono, idDepartamento);
	    
	    // Retornamos una respuesta indicando que la inserción fue exitosa
	    return ResponseEntity.status(200).body("Profesor insertado correctamente");
	}
}
