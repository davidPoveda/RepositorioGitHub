/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciorest.service;

import com.dpoveda.servicio.serviciorest.dto.EmpleadoDTO;
import com.dpoveda.servicio.serviciorest.wsdl.SaveEmpleadoRequest;
import com.dpoveda.servicio.serviciorest.wsdl.SaveEmpleadoResponse;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author david
 */
@Service
@Component("EmpleadoClient")
public class EmpleadoClient extends WebServiceGatewaySupport {

    // TODO esto va en el application.properties
    private String endPoint = "http://localhost:8080/ws/empleadoWsdl.wsdl";

    public SaveEmpleadoResponse invocarEmpleado(EmpleadoDTO empleadoDTO) {
        
        SaveEmpleadoRequest request = new SaveEmpleadoRequest();
        SaveEmpleadoResponse response = null;
        try {
            request.setNumberdocument(empleadoDTO.getNumberdocument());
            GregorianCalendar fechaIngreso = new GregorianCalendar();
            fechaIngreso.setTime(empleadoDTO.getAdmissiondate());
            XMLGregorianCalendar admissionDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaIngreso);
            request.setAdmissiondate(admissionDate);
            GregorianCalendar fechaNacimiento = new GregorianCalendar();
            fechaNacimiento.setTime(empleadoDTO.getBirthdate());
            XMLGregorianCalendar birthDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaNacimiento);
            request.setBirthdate(birthDate);
            request.setNames(empleadoDTO.getNames());
            request.setFastname(empleadoDTO.getFastname());
            request.setNumberdocument(empleadoDTO.getNumberdocument());
            request.setPost(empleadoDTO.getPost());
            request.setTypedocument(empleadoDTO.getTypedocument());
            request.setSalary(empleadoDTO.getSalary());
            response = (SaveEmpleadoResponse) getWebServiceTemplate().marshalSendAndReceive(endPoint, request);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(EmpleadoClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }
}
