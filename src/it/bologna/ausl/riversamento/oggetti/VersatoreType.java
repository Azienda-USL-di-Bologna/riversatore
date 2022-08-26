//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.25 at 01:27:41 PM CEST 
//


package it.bologna.ausl.riversamento.oggetti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersatoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersatoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ambiente" type="{}StringNVMax100Type"/>
 *         &lt;element name="Ente" type="{}StringNVMax100Type"/>
 *         &lt;element name="Struttura" type="{}StringNVMax100Type"/>
 *         &lt;element name="UserID" type="{}StringNVMax100Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersatoreType", propOrder = {
    "ambiente",
    "ente",
    "struttura",
    "userID"
})
public class VersatoreType {

    @XmlElement(name = "Ambiente", required = true)
    protected String ambiente;
    @XmlElement(name = "Ente", required = true)
    protected String ente;
    @XmlElement(name = "Struttura", required = true)
    protected String struttura;
    @XmlElement(name = "UserID", required = true)
    protected String userID;

    /**
     * Gets the value of the ambiente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * Sets the value of the ambiente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmbiente(String value) {
        this.ambiente = value;
    }

    /**
     * Gets the value of the ente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnte() {
        return ente;
    }

    /**
     * Sets the value of the ente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnte(String value) {
        this.ente = value;
    }

    /**
     * Gets the value of the struttura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStruttura() {
        return struttura;
    }

    /**
     * Sets the value of the struttura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStruttura(String value) {
        this.struttura = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

}
