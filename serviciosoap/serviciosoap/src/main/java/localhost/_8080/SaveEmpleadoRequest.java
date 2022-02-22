//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.02.20 a las 07:47:05 PM COT 
//


package localhost._8080;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="names" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fastname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="typedocument" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numberdocument" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="admissiondate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="post" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="salary" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "names",
    "fastname",
    "typedocument",
    "numberdocument",
    "birthdate",
    "admissiondate",
    "post",
    "salary"
})
@XmlRootElement(name = "saveEmpleadoRequest")
public class SaveEmpleadoRequest {

    @XmlElement(required = true)
    protected String names;
    @XmlElement(required = true)
    protected String fastname;
    @XmlElement(required = true)
    protected String typedocument;
    @XmlElement(required = true)
    protected String numberdocument;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthdate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar admissiondate;
    @XmlElement(required = true)
    protected String post;
    @XmlElement(required = true)
    protected BigDecimal salary;

    /**
     * Obtiene el valor de la propiedad names.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNames() {
        return names;
    }

    /**
     * Define el valor de la propiedad names.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNames(String value) {
        this.names = value;
    }

    /**
     * Obtiene el valor de la propiedad fastname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFastname() {
        return fastname;
    }

    /**
     * Define el valor de la propiedad fastname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFastname(String value) {
        this.fastname = value;
    }

    /**
     * Obtiene el valor de la propiedad typedocument.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypedocument() {
        return typedocument;
    }

    /**
     * Define el valor de la propiedad typedocument.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypedocument(String value) {
        this.typedocument = value;
    }

    /**
     * Obtiene el valor de la propiedad numberdocument.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberdocument() {
        return numberdocument;
    }

    /**
     * Define el valor de la propiedad numberdocument.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberdocument(String value) {
        this.numberdocument = value;
    }

    /**
     * Obtiene el valor de la propiedad birthdate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthdate() {
        return birthdate;
    }

    /**
     * Define el valor de la propiedad birthdate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthdate(XMLGregorianCalendar value) {
        this.birthdate = value;
    }

    /**
     * Obtiene el valor de la propiedad admissiondate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAdmissiondate() {
        return admissiondate;
    }

    /**
     * Define el valor de la propiedad admissiondate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAdmissiondate(XMLGregorianCalendar value) {
        this.admissiondate = value;
    }

    /**
     * Obtiene el valor de la propiedad post.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPost() {
        return post;
    }

    /**
     * Define el valor de la propiedad post.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPost(String value) {
        this.post = value;
    }

    /**
     * Obtiene el valor de la propiedad salary.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Define el valor de la propiedad salary.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSalary(BigDecimal value) {
        this.salary = value;
    }

}
