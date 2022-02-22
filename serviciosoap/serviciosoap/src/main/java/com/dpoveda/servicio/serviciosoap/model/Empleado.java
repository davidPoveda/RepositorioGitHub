/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;




/**
 *
 * @author david
 */
@Entity
@Table(name="empleador")
public class Empleado {
    
    @Id
    @Column(name = "numerodocumento")
    private String numeroIdentificacion;
    
    @Column(name = "tipodocumento")
    private String tipoIdentificacion;
    
    @Column(name = "nombres")
    private String primerSegundoNombre;
    
    @Column(name = "apellidos")
    private String primerSegundoApellido;
    
    private String cargo;
    
    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name = "fechavinculaempresa")
    private LocalDate fechaIngreso;
    
    private BigDecimal salario;

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getPrimerSegundoNombre() {
        return primerSegundoNombre;
    }

    public void setPrimerSegundoNombre(String primerSegundoNombre) {
        this.primerSegundoNombre = primerSegundoNombre;
    }

    public String getPrimerSegundoApellido() {
        return primerSegundoApellido;
    }

    public void setPrimerSegundoApellido(String primerSegundoApellido) {
        this.primerSegundoApellido = primerSegundoApellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    
}
