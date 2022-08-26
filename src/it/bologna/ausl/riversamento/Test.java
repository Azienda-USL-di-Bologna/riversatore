/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.riversamento;

import it.bologna.ausl.riversamento.oggetti.UnitaDocumentaria;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.XPathContext;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author andrea
 */
public class Test {

    public static void main(String[] args) throws JAXBException, DatatypeConfigurationException, IOException, ParsingException {
        BasicConfigurator.configure();
        Pacco p = new Pacco();
        PaccoFile pf = new PaccoFile();
        XmlGenerator x = new XmlGenerator();
        UnitaDocumentaria ud = x.getXml();
        x.setUnitaDocumentaria(ud);

        pf.setFile(new File("/tmp/test.pdf"));
        pf.setMime("application/pdf");
        pf.setFileName(pf.getFile().getName());

        x.linkaDcocumentoPrincipale(pf);

        p.setLoginName("versatore_aslbo");
        p.setLoginName("gedi_ausl_bo");
        p.setPassword("password");
        p.setPassword("la password");

        p.addFile(pf);

        DocumentBuilder db = new DocumentBuilder("ID_01",
                "Generico",
                "Zucchellini",
                "test allegato",
                "DocumentoGenerico",
                "allegato01.pdf",
                "ID_01_versato",
                "PDF",
                "urn:babel:0451450523",
                "hash",
                null,
                null);
        PaccoFile allegato = new PaccoFile();

        allegato.setFile(new File("/tmp/test.pdf"));
        allegato.setMime("application/pdf");
        allegato.setFileName(pf.getFile().getName());

        x.addAllegato(db.getDoc(), allegato);
        p.addFile(allegato);
        p.setXmlsip(x.toString());
        RiVersatore r = new RiVersatore();
        String res = r.riversa(p);

        Builder parser = new Builder();
        Document resd = parser.build(res, null);

        // parsare con XOM l'esito
        XPathContext context = new XPathContext("EsitoVersamento", "");
        Nodes risultato = resd.query("//CodiceEsito/text()", context);

        System.out.println("Esito di riversamento: " + risultato.get(0).toXML());
        System.out.println(RiVersatore.checkEsito(res));
    }

}
