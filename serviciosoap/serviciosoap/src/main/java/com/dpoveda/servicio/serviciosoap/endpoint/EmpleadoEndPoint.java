/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.endpoint;

import com.dpoveda.servicio.serviciosoap.service.EmpleadoService;
import localhost._8080.SaveEmpleadoRequest;
import localhost._8080.SaveEmpleadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Capturador que recibe las peticiones
 * @author david
 */
@Endpoint
public class EmpleadoEndPoint {
    
    private static final String NAMESPACE_URI = "http://localhost:8080/";
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveEmpleadoRequest")
  @ResponsePayload
  public SaveEmpleadoResponse saveEmpleado(@RequestPayload SaveEmpleadoRequest request) {
    SaveEmpleadoResponse response = new SaveEmpleadoResponse();
    empleadoService.saveEmpleado(request);
    
    return response;
  }
}
