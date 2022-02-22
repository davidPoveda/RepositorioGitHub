/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciorest.controller;

import com.dpoveda.servicio.serviciorest.dto.EmpleadoDTO;
import com.dpoveda.servicio.serviciorest.dto.EmpleadoOutDTO;
import com.dpoveda.servicio.serviciorest.service.EmpleadoService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/empleador")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/nuevo/{numeroIdentifica}/{tipoIdentifica}/{nombres}/{apellidos}/{fechaNacimiento}/{fechaVincula}/{cargo}/{salario}")
    public ResponseEntity invocarServicioEmpleadoSoap(@PathVariable("numeroIdentifica") String numeroIdentifica,
            @PathVariable("tipoIdentifica") String tipoIdentifica, @PathVariable("nombres") String nombres,
            @PathVariable("apellidos") String apellidos, @PathVariable("fechaNacimiento") String fechaNacimiento,
            @PathVariable("fechaVincula") String fechaVincula, @PathVariable("cargo") String cargo,
            @PathVariable("salario") String salario) {

        EmpleadoOutDTO validarEmpleado = empleadoService.validarAlmacenarEmpleado(numeroIdentifica, 
                tipoIdentifica, nombres, apellidos, fechaNacimiento, fechaVincula, cargo, salario);

        if (validarEmpleado.getMensajeError() != null) {
            return ResponseEntity.ok(validarEmpleado);
        }
        return ResponseEntity.ok().body(validarEmpleado);

    }
}
