package es.iesjandula.Universidad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Departamento;
import es.iesjandula.Universidad.models.Profesor;
import es.iesjandula.Universidad.repository.DepartamentoRepository;
import es.iesjandula.Universidad.repository.ProfesorRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProfesorServices 
{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public void insertarProfesor(Integer idProfesor, String nif, String nombre, String apellido1, String apellido2, 
                                 String fechNac, String ciudad, String direccion, String sexo, String telefono, 
                                 Integer idDepartamento) 
    {

        Profesor profesor = new Profesor();

        profesor.setId(idProfesor);
        profesor.setNif(nif);
        profesor.setNombre(nombre);
        profesor.setFechNac(fechNac);  
        profesor.setApellido1(apellido1);  
        profesor.setApellido2(apellido2);  
        profesor.setCiudad(ciudad);  
        profesor.setDireccion(direccion);  
        profesor.setSexo(sexo);  
        profesor.setTelefono(telefono);  

        // Buscar el departamento usando el idDepartamento proporcionado
        Optional<Departamento> optionalDepartamento = this.departamentoRepository.findById(idDepartamento);

        if (!optionalDepartamento.isPresent()) 
        {
            log.error("El departamento con ID " + idDepartamento + " no existe");
        }

        profesor.setIdDepartamento(optionalDepartamento.get());

        this.profesorRepository.saveAndFlush(profesor);
    }
}

