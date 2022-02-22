/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciorest.service;

import com.dpoveda.servicio.serviciorest.dto.EmpleadoDTO;
import com.dpoveda.servicio.serviciorest.dto.EmpleadoOutDTO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoClient soapClient;

    public EmpleadoOutDTO validarAlmacenarEmpleado(String numeroIdentifica,
            String tipoIdentifica, String nombres,
            String apellidos, String fechaNacimiento,
            String fechaVincula, String cargo,
            String salario) {

        EmpleadoDTO empleadoDTO = cargarDTO(numeroIdentifica, tipoIdentifica, nombres, apellidos, cargo);

        EmpleadoOutDTO validarEmpleado = validarEmpleado(empleadoDTO, fechaNacimiento,
            fechaVincula, salario);
        if (validarEmpleado.getMensajeError() != null) {
            return validarEmpleado;
        }
        soapClient.invocarEmpleado(empleadoDTO);
        return validarEmpleado;

    }

    /**
     * Metodo encargado de validar desde el servicio REST
     *
     * @param empleadoDTO
     * @return
     */
    private EmpleadoOutDTO validarEmpleado(EmpleadoDTO empleadoDTO, String fechaNacimiento,
            String fechaVincula, String salario) {
        EmpleadoOutDTO outDTO = new EmpleadoOutDTO();

        String validaObligatorios = validarObligatorios(empleadoDTO, fechaNacimiento, fechaVincula, salario);

        if (validaObligatorios != null) {
            outDTO.setMensajeError(validaObligatorios);
            return outDTO;
        }
        return retornoMensajeExito(empleadoDTO);
    }

    /**
     * Metodo encargado de retornar el mensaje de exito al servicio REST
     *
     * @param empleadoDTO
     * @return
     */
    private EmpleadoOutDTO retornoMensajeExito(EmpleadoDTO empleadoDTO) {
        EmpleadoOutDTO outDTO = new EmpleadoOutDTO();

        String fromDate = convertirFecha(empleadoDTO.getAdmissiondate());
        String toDate = convertirFecha(new Date());

        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive()
            .append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
        
        Period period = Period.between(LocalDate.parse(fromDate,f), LocalDate.parse(toDate,f));

        StringBuilder fechaIngreso = new StringBuilder();
        outDTO.setTiempoVinculacion(fechaIngreso.append(period.getYears()).append(" - ")
                .append(period.getMonths()).append(" - ").append(period.getDays()).toString());

        String fromDate2 = convertirFecha(empleadoDTO.getBirthdate());
        period = Period.between(LocalDate.parse(fromDate2,f), LocalDate.parse(toDate,f));
        StringBuilder fechaCumpleanyos = new StringBuilder();
        outDTO.setEdadActual(fechaCumpleanyos.append(period.getYears()).append(" - ")
                .append(period.getMonths()).append(" - ").append(period.getDays()).toString());

        outDTO.setAdmissiondate(empleadoDTO.getAdmissiondate());
        outDTO.setBirthdate(empleadoDTO.getBirthdate());
        outDTO.setFastname(empleadoDTO.getFastname());
        outDTO.setNames(empleadoDTO.getNames());
        outDTO.setNumberdocument(empleadoDTO.getNumberdocument());
        outDTO.setPost(empleadoDTO.getPost());
        outDTO.setSalary(empleadoDTO.getSalary());
        outDTO.setTypedocument(empleadoDTO.getTypedocument());

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

    /**
     * Metodo encargado de validar los campos obligatorios del servicio REST
     *
     * @param empleadoDTO
     * @return
     */
    private String validarObligatorios(EmpleadoDTO empleadoDTO, String fechaNacimiento,
            String fechaVincula, String salario) {

        if (empleadoDTO.getFastname() == null || empleadoDTO.getFastname().isEmpty()) {
            return "El campo fastname es obligatorio";
        }
        if (empleadoDTO.getNames() == null || empleadoDTO.getNames().isEmpty()) {
            return "El campo names es obligatorio";
        }
        if (empleadoDTO.getNumberdocument() == null || empleadoDTO.getNumberdocument().isEmpty()) {
            return "El campo numberdocument es obligatorio";
        }
        if (empleadoDTO.getPost() == null || empleadoDTO.getPost().isEmpty()) {
            return "El campo post es obligatorio";
        }
        if (empleadoDTO.getTypedocument() == null || empleadoDTO.getTypedocument().isEmpty()) {
            return "El campo typedocument es obligatorio";
        }

        String validarFecha = validarFechasSalario(empleadoDTO, fechaNacimiento, fechaVincula, salario);

        if (validarFecha != null) {
            return validarFecha;
        }

        return null;
    }

    /**
     * Metodo que carga el DTO
     * @param numeroIdentifica
     * @param tipoIdentifica
     * @param nombres
     * @param apellidos
     * @param cargo
     * @return 
     */
    private EmpleadoDTO cargarDTO(String numeroIdentifica,
            String tipoIdentifica, String nombres,
            String apellidos, String cargo) {

        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setFastname(apellidos);
        dto.setNames(nombres);
        dto.setNumberdocument(numeroIdentifica);
        dto.setPost(cargo);
        dto.setTypedocument(tipoIdentifica);

        return dto;
    }

    private String validarFechasSalario(EmpleadoDTO empleadoDTO, String fechaNacimiento, String fechaVincula, String salario) {

        try {
            // se valida el formato de fechas
            if (fechaVincula == null) {
                return "El campo admissiondate es obligatorio";
            }

            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = formato.parse(fechaVincula);
            empleadoDTO.setAdmissiondate(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, null, ex);
            return "El campo admissiondate es invalido";
        }
        try {
            // se valida el formato de fechas
            if (fechaNacimiento == null) {
                return "El campo birthdate es obligatorio";
            }

            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaDos = formato.parse(fechaNacimiento);
            empleadoDTO.setBirthdate(fechaDos);
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, null, ex);
            return "El campo admissiondate es invalido";
        }
        // se valida el salario
        if (salario == null) {
            return "El campo salary es obligatorio";
        }
        empleadoDTO.setSalary(new BigDecimal(salario));

        return null;

    }

}
