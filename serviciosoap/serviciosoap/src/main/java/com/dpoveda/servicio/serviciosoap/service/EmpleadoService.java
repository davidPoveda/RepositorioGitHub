/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.service;

import com.dpoveda.servicio.serviciosoap.dto.EmpleadoOutDTO;
import com.dpoveda.servicio.serviciosoap.repository.EmpleadoRepository;
import com.dpoveda.servicio.serviciosoap.model.Empleado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
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
    public EmpleadoOutDTO saveEmpleado(SaveEmpleadoRequest empleadoRequest) {
        // cats
        ZoneId defaultZoneId = ZoneId.systemDefault();
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
        
        EmpleadoOutDTO outDTO = new EmpleadoOutDTO();
        String fromDate = convertirFecha(Date.from(fechaIngreso.atStartOfDay(defaultZoneId).toInstant()));
        String toDate = convertirFecha(new Date());

        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive()
            .append(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toFormatter();
        
        Period period = Period.between(LocalDate.parse(fromDate,f), LocalDate.parse(toDate,f));

        StringBuilder fechaVincula = new StringBuilder();
        outDTO.setTiempoVinculacion(fechaVincula.append(period.getYears()).append(" - ")
                .append(period.getMonths()).append(" - ").append(period.getDays()).toString());

        String fromDate2 = convertirFecha(Date.from(fechaNacimiento.atStartOfDay(defaultZoneId).toInstant()));
        period = Period.between(LocalDate.parse(fromDate2,f), LocalDate.parse(toDate,f));
        StringBuilder fechaCumpleanyos = new StringBuilder();
        outDTO.setEdadActual(fechaCumpleanyos.append(period.getYears()).append(" - ")
                .append(period.getMonths()).append(" - ").append(period.getDays()).toString());
        return outDTO;
    }
    
    /**
     * Metodo encargado de convertir fecha a String
     *
     * @param fecha
     * @return
     * @throws ParseException
     */
    private String convertirFecha(Date fecha) {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateToStr = dateFormat.format(fecha);
        return dateToStr;
    }
}
