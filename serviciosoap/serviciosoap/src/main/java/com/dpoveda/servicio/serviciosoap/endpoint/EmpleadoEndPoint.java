/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.endpoint;

import com.dpoveda.servicio.serviciosoap.dto.EmpleadoOutDTO;
import com.dpoveda.servicio.serviciosoap.service.EmpleadoService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import localhost._8080.SaveEmpleadoRequest;
import localhost._8080.SaveEmpleadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Capturador que recibe las peticiones
 *
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
        EmpleadoOutDTO outDTO = empleadoService.saveEmpleado(request);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = format.parse(outDTO.getEdadActual());
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);

            XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            response.setBirthdate(xmlGregCal);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(EmpleadoEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadoEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            date = format.parse(outDTO.getTiempoVinculacion());
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);

            XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            response.setLinkingTimeCompany(xmlGregCal);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(EmpleadoEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadoEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }
}
