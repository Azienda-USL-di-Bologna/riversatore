//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.09.25 at 01:27:41 PM CEST
//
package it.bologna.ausl.riversamento.oggetti;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Intestazione" type="{}IntestazioneType"/>
 *         &lt;element name="Configurazione" type="{}ConfigType" minOccurs="0"/>
 *         &lt;element name="ProfiloArchivistico" type="{}ProfiloArchivisticoType" minOccurs="0"/>
 *         &lt;element name="ProfiloUnitaDocumentaria" type="{}ProfiloUnitaDocumentariaType" minOccurs="0"/>
 *         &lt;element name="DatiSpecifici" type="{}DatiSpecificiType" minOccurs="0"/>
 *         &lt;element name="DatiSpecificiMigrazione" type="{}DatiSpecificiType" minOccurs="0"/>
 *         &lt;element name="DocumentiCollegati" type="{}DocumentoCollegatoType" minOccurs="0"/>
 *         &lt;element name="NumeroAllegati" type="{}IntMax4DgtType" minOccurs="0"/>
 *         &lt;element name="NumeroAnnessi" type="{}IntMax4DgtType" minOccurs="0"/>
 *         &lt;element name="NumeroAnnotazioni" type="{}IntMax4DgtType" minOccurs="0"/>
 *         &lt;element name="DocumentoPrincipale" type="{}DocumentoType"/>
 *         &lt;element name="Allegati" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Allegato" type="{}DocumentoType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Annessi" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Annesso" type="{}DocumentoType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Annotazioni" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Annotazione" type="{}DocumentoType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "intestazione",
    "configurazione",
    "profiloArchivistico",
    "profiloUnitaDocumentaria",
    "datiSpecifici",
    "datiSpecificiMigrazione",
    "documentiCollegati",
    "numeroAllegati",
    "numeroAnnessi",
    "numeroAnnotazioni",
    "documentoPrincipale",
    "allegati",
    "annessi",
    "annotazioni"
})
@XmlRootElement(name = "UnitaDocumentaria", namespace = "URN:PARER_VERSAMENTO:1.3")
public class UnitaDocumentaria {

    @XmlElement(name = "Intestazione", required = true)
    protected IntestazioneType intestazione;
    @XmlElement(name = "Configurazione")
    protected ConfigType configurazione;
    @XmlElement(name = "ProfiloArchivistico")
    protected ProfiloArchivisticoType profiloArchivistico;
    @XmlElement(name = "ProfiloUnitaDocumentaria")
    protected ProfiloUnitaDocumentariaType profiloUnitaDocumentaria;
    @XmlElementRef(name = "DatiSpecifici", type = JAXBElement.class, required = false)
    protected JAXBElement<DatiSpecificiType> datiSpecifici;
    @XmlElementRef(name = "DatiSpecificiMigrazione", type = JAXBElement.class, required = false)
    protected JAXBElement<DatiSpecificiType> datiSpecificiMigrazione;
    @XmlElement(name = "DocumentiCollegati")
    protected DocumentoCollegatoType documentiCollegati;
    @XmlElement(name = "NumeroAllegati")
    protected Integer numeroAllegati;
    @XmlElement(name = "NumeroAnnessi")
    protected Integer numeroAnnessi;
    @XmlElement(name = "NumeroAnnotazioni")
    protected Integer numeroAnnotazioni;
    @XmlElement(name = "DocumentoPrincipale", required = true)
    protected DocumentoType documentoPrincipale;
    @XmlElement(name = "Allegati")
    protected UnitaDocumentaria.Allegati allegati;
    @XmlElement(name = "Annessi")
    protected UnitaDocumentaria.Annessi annessi;
    @XmlElement(name = "Annotazioni")
    protected UnitaDocumentaria.Annotazioni annotazioni;

    /**
     * Gets the value of the intestazione property.
     *
     * @return possible object is {@link IntestazioneType }
     *
     */
    public IntestazioneType getIntestazione() {
        return intestazione;
    }

    /**
     * Sets the value of the intestazione property.
     *
     * @param value allowed object is {@link IntestazioneType }
     *
     */
    public void setIntestazione(IntestazioneType value) {
        this.intestazione = value;
    }

    /**
     * Gets the value of the configurazione property.
     *
     * @return possible object is {@link ConfigType }
     *
     */
    public ConfigType getConfigurazione() {
        return configurazione;
    }

    /**
     * Sets the value of the configurazione property.
     *
     * @param value allowed object is {@link ConfigType }
     *
     */
    public void setConfigurazione(ConfigType value) {
        this.configurazione = value;
    }

    /**
     * Gets the value of the profiloArchivistico property.
     *
     * @return possible object is {@link ProfiloArchivisticoType }
     *
     */
    public ProfiloArchivisticoType getProfiloArchivistico() {
        return profiloArchivistico;
    }

    /**
     * Sets the value of the profiloArchivistico property.
     *
     * @param value allowed object is {@link ProfiloArchivisticoType }
     *
     */
    public void setProfiloArchivistico(ProfiloArchivisticoType value) {
        this.profiloArchivistico = value;
    }

    /**
     * Gets the value of the profiloUnitaDocumentaria property.
     *
     * @return possible object is {@link ProfiloUnitaDocumentariaType }
     *
     */
    public ProfiloUnitaDocumentariaType getProfiloUnitaDocumentaria() {
        return profiloUnitaDocumentaria;
    }

    /**
     * Sets the value of the profiloUnitaDocumentaria property.
     *
     * @param value allowed object is {@link ProfiloUnitaDocumentariaType }
     *
     */
    public void setProfiloUnitaDocumentaria(ProfiloUnitaDocumentariaType value) {
        this.profiloUnitaDocumentaria = value;
    }

    /**
     * Gets the value of the datiSpecifici property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link DatiSpecificiType }{@code >}
     *
     */
    public JAXBElement<DatiSpecificiType> getDatiSpecifici() {
        return datiSpecifici;
    }

    /**
     * Sets the value of the datiSpecifici property.
     *
     * @param value allowed object is
     * {@link JAXBElement }{@code <}{@link DatiSpecificiType }{@code >}
     *
     */
    public void setDatiSpecifici(JAXBElement<DatiSpecificiType> value) {
        this.datiSpecifici = value;
    }

    /**
     * Gets the value of the datiSpecificiMigrazione property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link DatiSpecificiType }{@code >}
     *
     */
    public JAXBElement<DatiSpecificiType> getDatiSpecificiMigrazione() {
        return datiSpecificiMigrazione;
    }

    /**
     * Sets the value of the datiSpecificiMigrazione property.
     *
     * @param value allowed object is
     * {@link JAXBElement }{@code <}{@link DatiSpecificiType }{@code >}
     *
     */
    public void setDatiSpecificiMigrazione(JAXBElement<DatiSpecificiType> value) {
        this.datiSpecificiMigrazione = value;
    }

    /**
     * Gets the value of the documentiCollegati property.
     *
     * @return possible object is {@link DocumentoCollegatoType }
     *
     */
    public DocumentoCollegatoType getDocumentiCollegati() {
        return documentiCollegati;
    }

    /**
     * Sets the value of the documentiCollegati property.
     *
     * @param value allowed object is {@link DocumentoCollegatoType }
     *
     */
    public void setDocumentiCollegati(DocumentoCollegatoType value) {
        this.documentiCollegati = value;
    }

    /**
     * Gets the value of the numeroAllegati property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getNumeroAllegati() {
        return numeroAllegati;
    }

    /**
     * Sets the value of the numeroAllegati property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setNumeroAllegati(Integer value) {
        this.numeroAllegati = value;
    }

    /**
     * Gets the value of the numeroAnnessi property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getNumeroAnnessi() {
        return numeroAnnessi;
    }

    /**
     * Sets the value of the numeroAnnessi property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setNumeroAnnessi(Integer value) {
        this.numeroAnnessi = value;
    }

    /**
     * Gets the value of the numeroAnnotazioni property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getNumeroAnnotazioni() {
        return numeroAnnotazioni;
    }

    /**
     * Sets the value of the numeroAnnotazioni property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setNumeroAnnotazioni(Integer value) {
        this.numeroAnnotazioni = value;
    }

    /**
     * Gets the value of the documentoPrincipale property.
     *
     * @return possible object is {@link DocumentoType }
     *
     */
    public DocumentoType getDocumentoPrincipale() {
        return documentoPrincipale;
    }

    /**
     * Sets the value of the documentoPrincipale property.
     *
     * @param value allowed object is {@link DocumentoType }
     *
     */
    public void setDocumentoPrincipale(DocumentoType value) {
        this.documentoPrincipale = value;
    }

    /**
     * Gets the value of the allegati property.
     *
     * @return possible object is {@link UnitaDocumentaria.Allegati }
     *
     */
    public UnitaDocumentaria.Allegati getAllegati() {
        return allegati;
    }

    /**
     * Sets the value of the allegati property.
     *
     * @param value allowed object is {@link UnitaDocumentaria.Allegati }
     *
     */
    public void setAllegati(UnitaDocumentaria.Allegati value) {
        this.allegati = value;
    }

    /**
     * Gets the value of the annessi property.
     *
     * @return possible object is {@link UnitaDocumentaria.Annessi }
     *
     */
    public UnitaDocumentaria.Annessi getAnnessi() {
        return annessi;
    }

    /**
     * Sets the value of the annessi property.
     *
     * @param value allowed object is {@link UnitaDocumentaria.Annessi }
     *
     */
    public void setAnnessi(UnitaDocumentaria.Annessi value) {
        this.annessi = value;
    }

    /**
     * Gets the value of the annotazioni property.
     *
     * @return possible object is {@link UnitaDocumentaria.Annotazioni }
     *
     */
    public UnitaDocumentaria.Annotazioni getAnnotazioni() {
        return annotazioni;
    }

    /**
     * Sets the value of the annotazioni property.
     *
     * @param value allowed object is {@link UnitaDocumentaria.Annotazioni }
     *
     */
    public void setAnnotazioni(UnitaDocumentaria.Annotazioni value) {
        this.annotazioni = value;
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained
     * within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Allegato" type="{}DocumentoType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "allegato"
    })
    public static class Allegati {

        @XmlElement(name = "Allegato", required = true)
        protected List<DocumentoType> allegato;

        /**
         * Gets the value of the allegato property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the allegato property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAllegato().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentoType }
         *
         *
         */
        public List<DocumentoType> getAllegato() {
            if (allegato == null) {
                allegato = new ArrayList<DocumentoType>();
            }
            return this.allegato;
        }
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained
     * within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Annesso" type="{}DocumentoType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "annesso"
    })
    public static class Annessi {

        @XmlElement(name = "Annesso", required = true)
        protected List<DocumentoType> annesso;

        /**
         * Gets the value of the annesso property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the annesso property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAnnesso().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentoType }
         *
         *
         */
        public List<DocumentoType> getAnnesso() {
            if (annesso == null) {
                annesso = new ArrayList<DocumentoType>();
            }
            return this.annesso;
        }
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained
     * within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Annotazione" type="{}DocumentoType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "annotazione"
    })
    public static class Annotazioni {

        @XmlElement(name = "Annotazione", required = true)
        protected List<DocumentoType> annotazione;

        /**
         * Gets the value of the annotazione property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the annotazione property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAnnotazione().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentoType }
         *
         *
         */
        public List<DocumentoType> getAnnotazione() {
            if (annotazione == null) {
                annotazione = new ArrayList<DocumentoType>();
            }
            return this.annotazione;
        }
    }
}
