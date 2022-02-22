/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.service;

import com.dpoveda.servicio.serviciosoap.repository.EmpleadoRepository;
import com.dpoveda.servicio.serviciosoap.model.Empleado;
import java.math.BigDecimal;
import java.time.LocalDate;
import localhost._8080.SaveEmpleadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de negocio de empleador
 *
 * @author david
 */
@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * Metodo encargado de guardar el empleado en bd
     *
     * @param empleadoRequest
     */
    public void saveEmpleado(SaveEmpleadoRequest empleadoRequest) {
        // cats
        Empleado empleado = new Empleado();
        empleado.setCargo(empleadoRequest.getPost());
        LocalDate fechaIngreso = LocalDate.of(
                empleadoRequest.getAdmissiondate().getYear(),
                empleadoRequest.getAdmissiondate().getMonth(),
                empleadoRequest.getAdmissiondate().getDay());
        empleado.setFechaIngreso(fechaIngreso);
        LocalDate fechaNacimiento = LocalDate.of(
                empleadoRequest.getBirthdate().getYear(),
                empleadoRequest.getBirthdate().getMonth(),
                empleadoRequest.getBirthdate().getDay());
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setNumeroIdentificacion(empleadoRequest.getNumberdocument());
        empleado.setPrimerSegundoApellido(empleadoRequest.getFastname());
        empleado.setPrimerSegundoNombre(empleadoRequest.getNames());
        empleado.setSalario(empleadoRequest.getSalary());
        empleado.setTipoIdentificacion(empleadoRequest.getTypedocument());

        System.out.println(" EmpleadoService.empleadoRepository SOAP");
        empleadoRepository.save(empleado);
    }
}
