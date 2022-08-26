/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.riversamento;

import it.bologna.ausl.riversamento.oggetti.CamiciaFascicoloType;
import it.bologna.ausl.riversamento.oggetti.ChiaveType;
import it.bologna.ausl.riversamento.oggetti.ComponenteType;
import it.bologna.ausl.riversamento.oggetti.ConfigType;
import it.bologna.ausl.riversamento.oggetti.DocumentoType;
import it.bologna.ausl.riversamento.oggetti.FascicoloType;
import it.bologna.ausl.riversamento.oggetti.IntestazioneType;
import it.bologna.ausl.riversamento.oggetti.ObjectFactory;
import it.bologna.ausl.riversamento.oggetti.ProfiloArchivisticoType;
import it.bologna.ausl.riversamento.oggetti.ProfiloDocumentoType;
import it.bologna.ausl.riversamento.oggetti.ProfiloUnitaDocumentariaType;
import it.bologna.ausl.riversamento.oggetti.StrutturaType;
import it.bologna.ausl.riversamento.oggetti.TipoConservazioneType;
import it.bologna.ausl.riversamento.oggetti.TipoSupportoType;
import it.bologna.ausl.riversamento.oggetti.UnitaDocumentaria;
import it.bologna.ausl.riversamento.oggetti.UnitaDocumentaria.Allegati;
import it.bologna.ausl.riversamento.oggetti.UnitaDocumentaria.Annessi;
import it.bologna.ausl.riversamento.oggetti.UnitaDocumentaria.Annotazioni;
import it.bologna.ausl.riversamento.oggetti.VersatoreType;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author andrea
 */
public class XmlGenerator {

    private Marshaller marshaller;
    private UnitaDocumentaria ud;
    private int presentazione_idx = 1;
    private Annessi annessi = null;
    private Allegati allegati = null;
    private Annotazioni annotazioni = null;

    public XmlGenerator() throws JAXBException {
        JAXBContext jaxb = JAXBContext.newInstance(UnitaDocumentaria.class);
        marshaller = jaxb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    public void setUnitaDocumentaria(UnitaDocumentaria ud) {
        this.ud = ud;
    }

    public UnitaDocumentaria linkaDcocumentoPrincipale(PaccoFile dp) throws JAXBException {

        ud.getDocumentoPrincipale().getStrutturaOriginale().getComponenti().getComponente().get(0).setID(dp.getId().toString());
        // ud.getDocumentoPrincipale().getStrutturaOriginale().getComponenti().getComponente().get(0).setUrnVersato(dp.getFile().toString());

        return ud;
    }

    @Override
    public String toString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            marshaller.marshal(ud, baos);
        } catch (JAXBException e) {
            return "Document Error unable to serialize: " + e;
        }
        return new String(baos.toByteArray());
    }

    public UnitaDocumentaria getXml() throws DatatypeConfigurationException, JAXBException {
        ObjectFactory of = new ObjectFactory();
        UnitaDocumentaria ud = of.createUnitaDocumentaria();
        IntestazioneType i = new IntestazioneType();
        i.setVersione("1.3");

        VersatoreType v = new VersatoreType();
        v.setAmbiente("PARER_TEST");
        v.setEnte("AUSL_BO");
        v.setStruttura("ASL_BO");
        v.setUserID("gedi_ausl_bo");
        i.setVersatore(v);
        i.setTipologiaUnitaDocumentaria("Documento protocollato in entrata");
        ChiaveType c = new ChiaveType();
        c.setNumero("12345");
        c.setAnno(Calendar.getInstance().get(Calendar.YEAR));
        c.setTipoRegistro("PG");
        i.setChiave(c);

        ud.setIntestazione(i);

        ConfigType conf = new ConfigType();
        conf.setForzaAccettazione(Boolean.FALSE);
        conf.setForzaCollegamento(Boolean.FALSE);
        conf.setForzaConservazione(Boolean.FALSE);
        conf.setTipoConservazione(TipoConservazioneType.SOSTITUTIVA);
        conf.setSimulaSalvataggioDatiInDB(Boolean.TRUE);
        ud.setConfigurazione(conf);

        ProfiloArchivisticoType pa = new ProfiloArchivisticoType();

        CamiciaFascicoloType cfp = new CamiciaFascicoloType();
        cfp.setClassifica("2013-000001");
        FascicoloType fp = new FascicoloType();
        fp.setIdentificativo("ID Fascicolo Principale");
        fp.setOggetto("Oggetto fascicolo principale");
        cfp.setFascicolo(fp);
        pa.setFascicoloPrincipale(cfp);
        ud.setProfiloArchivistico(pa);

        ProfiloUnitaDocumentariaType pud = new ProfiloUnitaDocumentariaType();
        pud.setOggetto("Oggetto unita' docmentaria");

        pud.setData(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        pud.setCartaceo(Boolean.FALSE);
        ud.setProfiloUnitaDocumentaria(pud);

        //NON USATO PER ORA
        /*
         DocumentoCollegatoType dct = new DocumentoCollegatoType();
         List<DocumentoCollegatoType.DocumentoCollegato> documentoCollegato = dct.getDocumentoCollegato();
         DocumentoCollegatoType.DocumentoCollegato dc = new DocumentoCollegatoType.DocumentoCollegato();
         */
        DocumentoType docPrincipale = new DocumentoType();

        docPrincipale.setIDDocumento("ID_PICO");
        docPrincipale.setTipoDocumento("Documento protocollato");

        ProfiloDocumentoType pd = new ProfiloDocumentoType();
        pd.setAutore("Autore protocollo");
        pd.setDescrizione("Descrizione protocollo (oggetto???)");
        docPrincipale.setProfiloDocumento(pd);

        StrutturaType s = new StrutturaType();
        s.setTipoStruttura("DocumentoGenerico");
        StrutturaType.Componenti cs = new StrutturaType.Componenti();
        ComponenteType ct = new ComponenteType();
        ct.setTipoComponente("Contenuto");
        ct.setID(UUID.randomUUID().toString());
        ct.setOrdinePresentazione(presentazione_idx++);
        ct.setTipoSupportoComponente(TipoSupportoType.FILE);
        ct.setNomeComponente("nome_file_versato");
        ct.setFormatoFileVersato("PDF");
        ct.setIDComponenteVersato("ID_PICO");
        ct.setUrnVersato("path_in_mongo");
        ct.setHashVersato("HASH");
        ct.setUtilizzoDataFirmaPerRifTemp(Boolean.FALSE);
        //data protocollo
        GregorianCalendar gc = new GregorianCalendar(2013, 10, 7, 12, 1, 0);
        ct.setRiferimentoTemporale(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
        ct.setDescrizioneRiferimentoTemporale("Data Protocollo");

        cs.getComponente().add(ct);

        s.setComponenti(cs);

        docPrincipale.setStrutturaOriginale(s);

        ud.setDocumentoPrincipale(docPrincipale);
        return ud;
    }

    public void addAllegato(DocumentoType a, PaccoFile pf) {
        if (allegati == null) {
            allegati = new Allegati();
            ud.setAllegati(allegati);
        }
        a.getStrutturaOriginale().getComponenti().getComponente().get(0).setOrdinePresentazione(presentazione_idx++);
        a.getStrutturaOriginale().getComponenti().getComponente().get(0).setID(pf.getId().toString());

        allegati.getAllegato().add(a);
        ud.setNumeroAllegati(allegati.getAllegato().size());
    }

    public void addAnnesso(DocumentoType a, PaccoFile pf) {
        if (annessi == null) {
            annessi = new Annessi();
            ud.setAnnessi(annessi);
        }
        a.getStrutturaOriginale().getComponenti().getComponente().get(0).setOrdinePresentazione(presentazione_idx++);
        a.getStrutturaOriginale().getComponenti().getComponente().get(0).setID(pf.getId().toString());

        annessi.getAnnesso().add(a);
        ud.setNumeroAnnessi(annessi.getAnnesso().size());

    }

    public void addAnnotazione(DocumentoType a, PaccoFile pf) {
        if (annotazioni == null) {
            annotazioni = new Annotazioni();
            ud.setAnnotazioni(annotazioni);
        }
        a.getStrutturaOriginale().getComponenti().getComponente().get(0).setOrdinePresentazione(presentazione_idx++);
        a.getStrutturaOriginale().getComponenti().getComponente().get(0).setID(pf.getId().toString());

        annotazioni.getAnnotazione().add(a);
        ud.setNumeroAnnotazioni(annotazioni.getAnnotazione().size());
    }

}
