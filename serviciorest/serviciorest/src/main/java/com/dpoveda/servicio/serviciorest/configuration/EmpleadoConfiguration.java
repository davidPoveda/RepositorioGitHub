/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciorest.configuration;

import com.dpoveda.servicio.serviciorest.service.EmpleadoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 *
 * @author david
 */
@Configuration
public class EmpleadoConfiguration {
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.dpoveda.servicio.serviciorest.wsdl");
        return marshaller;
    }

    @Bean
    public EmpleadoClient soapClient(Jaxb2Marshaller marshaller) {
        EmpleadoClient client = new EmpleadoClient();
//        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    
}
