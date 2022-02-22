/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dpoveda.servicio.serviciosoap.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author david
 */
public class EmpleadoDTO {

    private String names;
    private String fastname;
    private String typedocument;
    private String numberdocument;
    private Date birthdate;
    private Date admissiondate;
    private String post;
    private BigDecimal salary;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFastname() {
        return fastname;
    }

    public void setFastname(String fastname) {
        this.fastname = fastname;
    }

    public String getTypedocument() {
        return typedocument;
    }

    public void setTypedocument(String typedocument) {
        this.typedocument = typedocument;
    }

    public String getNumberdocument() {
        return numberdocument;
    }

    public void setNumberdocument(String numberdocument) {
        this.numberdocument = numberdocument;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getAdmissiondate() {
        return admissiondate;
    }

    public void setAdmissiondate(Date admissiondate) {
        this.admissiondate = admissiondate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
