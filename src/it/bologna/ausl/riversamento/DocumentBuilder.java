/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.riversamento;

import it.bologna.ausl.riversamento.oggetti.ComponenteType;
import it.bologna.ausl.riversamento.oggetti.DocumentoType;
import it.bologna.ausl.riversamento.oggetti.ProfiloDocumentoType;
import it.bologna.ausl.riversamento.oggetti.StrutturaType;
import it.bologna.ausl.riversamento.oggetti.TipoSupportoType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.json.simple.JSONObject;

/**
 *
 * @author andrea
 */
public class DocumentBuilder {

    private DocumentoType doc;

    public DocumentBuilder(String idDocumento,
            String tipoDocumento,
            String autore,
            String descrizione,
            String tipoStruttura,
            String nomeFile,
            String idVersato,
            String formatoFile,
            String URNVersato,
            String hash,
            GregorianCalendar riferimentoTemporale,
            String descRifTemporale) throws DatatypeConfigurationException {
        doc = new DocumentoType();
        doc.setIDDocumento(idDocumento);
        doc.setTipoDocumento(tipoDocumento);
        ProfiloDocumentoType pd = new ProfiloDocumentoType();
        pd.setAutore(autore);
        pd.setDescrizione(descrizione);
        doc.setProfiloDocumento(pd);
        StrutturaType s = new StrutturaType();
        s.setTipoStruttura(tipoStruttura);
        StrutturaType.Componenti cs = new StrutturaType.Componenti();
        ComponenteType ct = new ComponenteType();
        ct.setTipoComponente("Contenuto");
        ct.setID(UUID.randomUUID().toString());
        // ct.setOrdinePresentazione(presentazione_idx++);
        ct.setTipoSupportoComponente(TipoSupportoType.FILE);
        ct.setNomeComponente(nomeFile);
        ct.setFormatoFileVersato(formatoFile);
        ct.setIDComponenteVersato(idVersato);
        ct.setUrnVersato(URNVersato);
        ct.setHashVersato(hash);
        ct.setUtilizzoDataFirmaPerRifTemp(Boolean.FALSE);
        //data protocollo
        if (riferimentoTemporale != null) {
            ct.setRiferimentoTemporale(DatatypeFactory.newInstance().newXMLGregorianCalendar(riferimentoTemporale));
        }
        ct.setDescrizioneRiferimentoTemporale(descRifTemporale);
        cs.getComponente().add(ct);
        s.setComponenti(cs);
        doc.setStrutturaOriginale(s);
    }

    private static GregorianCalendar buildCalendar(String data) throws ParseException {
        if (data == null) {
            return null;
        }
        GregorianCalendar ilCalendario = new GregorianCalendar();
        SimpleDateFormat laDataFacile = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS Z");

        Date laData = laDataFacile.parse(data);

        ilCalendario.setTime(laData);
        return ilCalendario;

    }

    public DocumentBuilder(JSONObject dati) throws ParseException, DatatypeConfigurationException {
        //String idDocumento, String tipoDocumento, String autore, String descrizione, String tipoStruttura,
        //String nomeFile, String idVersato, String formatoFile, String URNVersato, String hash,
        //GregorianCalendar riferimentoTemporale, String descRifTemporale) throws DatatypeConfigurationException {
        this(
                (String) dati.get("idDocumento"),
                (String) dati.get("tipoDocumento"),
                (String) dati.get("autore"),
                (String) dati.get("descrizione"),
                (String) dati.get("tipoStruttura"),
                (String) dati.get("nomeFile"),
                (String) dati.get("idVersato"),
                (String) dati.get("formatoFile"),
                (String) dati.get("URNVersato"),
                (String) dati.get("hash"),
                buildCalendar((String) dati.get("riferimentoTemporale")),
                (String) dati.get("descRifTemporale")
        );

    }

    public DocumentoType getDoc() {
        return doc;
    }

}
