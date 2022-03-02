/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.dto;

/**
 *
 * @author david
 */
public class EmpleadoOutDTO {

    private String mensajeError;
    private String edadActual;
    private String tiempoVinculacion;

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getEdadActual() {
        return edadActual;
    }

    public void setEdadActual(String edadActual) {
        this.edadActual = edadActual;
    }

    public String getTiempoVinculacion() {
        return tiempoVinculacion;
    }

    public void setTiempoVinculacion(String tiempoVinculacion) {
        this.tiempoVinculacion = tiempoVinculacion;
    }

}
