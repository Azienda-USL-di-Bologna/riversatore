//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.25 at 01:27:41 PM CEST 
//


package it.bologna.ausl.riversamento.oggetti;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoConservazioneType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoConservazioneType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="SOSTITUTIVA"/>
 *     &lt;enumeration value="FISCALE"/>
 *     &lt;enumeration value="MIGRAZIONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoConservazioneType")
@XmlEnum
public enum TipoConservazioneType {

    SOSTITUTIVA,
    FISCALE,
    MIGRAZIONE;

    public String value() {
        return name();
    }

    public static TipoConservazioneType fromValue(String v) {
        return valueOf(v);
    }

}
