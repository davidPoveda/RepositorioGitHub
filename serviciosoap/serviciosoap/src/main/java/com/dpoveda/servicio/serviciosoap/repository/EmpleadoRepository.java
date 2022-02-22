/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.repository;

import com.dpoveda.servicio.serviciosoap.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa de empleado
 * @author david
 */
@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, String>{

}
