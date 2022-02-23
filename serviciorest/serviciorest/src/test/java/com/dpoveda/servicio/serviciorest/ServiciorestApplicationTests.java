package com.dpoveda.servicio.serviciorest;

import com.dpoveda.servicio.serviciorest.dto.EmpleadoOutDTO;
import com.dpoveda.servicio.serviciorest.service.EmpleadoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Clase que ejecuta pruebas unitarias del servicio rest de validacion de negocio
 * @author david
 */
@SpringBootTest
class ServiciorestApplicationTests {

    @Autowired
    private EmpleadoService empleadoService;

    /**
     * Metodo encargado de validar el obligatorio de numero de identificacion
     */
    @Test
    void contextLoads() {

        EmpleadoOutDTO outDTO = empleadoService.validarAlmacenarEmpleado(null, null, null, null, null, null, null, null);
        Assertions.assertThat(outDTO.getMensajeError().equals("El campo numberdocument es obligatorio"));
    }
    
    /**
     * Metodo encargado devalidar el tipo de documento
     */
    @Test
    void contextLoads2() {

        EmpleadoOutDTO outDTO = empleadoService.validarAlmacenarEmpleado("909090", null, null, null, null, null, null, null);
        // se valida tipo identificacion null
        Assertions.assertThat(outDTO.getMensajeError().equals("El campo typedocument es obligatorio"));
    }

    /**
     * Metodo encargado de validar el obligatorio de nombre
     */
    @Test
    void contextLoads3() {

        EmpleadoOutDTO outDTO = empleadoService.validarAlmacenarEmpleado("909090", "Cedula", null, null, null, null, null, null);
        Assertions.assertThat(outDTO.getMensajeError().equals("El campo names es obligatorio"));
    }

    /**
     * Metodo encargado de validar apellidos
     */
    @Test
    void contextLoads4() {

        EmpleadoOutDTO outDTO = empleadoService.validarAlmacenarEmpleado("909090", "Cedula", "Carlos", null, null, null, null, null);
        Assertions.assertThat(outDTO.getMensajeError().equals("El campo fastname es obligatorio"));
    }

    /**
     * Metodo encargado de validar el obligatorio de fecha nacimiento
     */
    @Test
    void contextLoads5() {

        EmpleadoOutDTO outDTO = empleadoService.validarAlmacenarEmpleado("909090", "Cedula", "Carlos", "Ponce", null, null, null, null);
        Assertions.assertThat(outDTO.getMensajeError().equals("El campo birthdate es obligatorio"));
    }

    /**
     * Metodo encargado de validar la fecha invalida en cumpleanyos
     */
    @Test
    void contextLoads6() {

        EmpleadoOutDTO outDTO = empleadoService.validarAlmacenarEmpleado("909090", "Cedula", "Carlos", "Ponce", "02-13-2022", "01-02-2001", null, null);
        Assertions.assertThat(outDTO.getMensajeError().equals("El campo admissiondate es invalido"));
    }
    
    /**
     * Se valida que el servicio retorne exitoso cuando los valores ingresados son diferentes de null y validos
     */
    @Test
    void contextLoads7() {

        EmpleadoOutDTO outDTO = empleadoService.validarAlmacenarEmpleado("909090", "Cedula", "Carlos", "Ponce", "02-13-2022", "01-02-2001", "Ingeniero", "50000");
        Assertions.assertThat(outDTO.getMensajeError() == null);
        Assertions.assertThat(outDTO.getTiempoVinculacion() != null);
        Assertions.assertThat(outDTO.getEdadActual() != null);
    }

}
