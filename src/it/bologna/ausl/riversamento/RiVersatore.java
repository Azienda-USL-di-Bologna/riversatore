/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.riversamento;

import it.bologna.ausl.riversamento.oggetti.UnitaDocumentaria;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.XPathContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author andrea
 */
public class RiVersatore {
//http://parer.ibc.regione.emilia-romagna.it/servizi/documenti-servizi/specifiche-tecniche-dei-servizi-di-versamento/at_download/file/Specifiche%20tecniche%20versione%201punto3%20errata%20corrige.zip
//
//indirizzo web service: https://parerlab.regione.emilia-romagna.it/sacerpre/VersamentoSync
//
//Ambiente: PARER_TEST
//Ente: AUSL_BO
//Struttura: ASL_BO
//UserID: versatore_aslbo
//Password: password

    private static Logger log = Logger.getLogger(RiVersatore.class);

    /**
     * @param args the command line arguments
     */
    private HttpClient c;
    private String uri, username, password;

    public RiVersatore() {
        this.uri = "https://gedi_ausl_bo:lapassword@parerlab.regione.emilia-romagna.it/sacerpre/VersamentoSync";
        this.username = "gedi_ausl_bo";
        this.password = "la password";
        HttpClientBuilder cb = HttpClientBuilder.create();
        this.c = cb.build();
        trustAllSSL(c);
    }

    public RiVersatore(String uri, String username, String password) {
        this.uri = uri;
        this.username = username;
        this.password = password;
        HttpClientBuilder cb = HttpClientBuilder.create();
        this.c = cb.build();
        trustAllSSL(c);
    }

    public String riversa(Pacco p) throws ClientProtocolException, IOException {

        MultipartEntity me = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        List<NameValuePair> formparams = p.getFormValues();

        log.debug("Building name values pairs to post:");
        for (NameValuePair nvp : formparams) {
            if (nvp.getValue() != null) {
                log.debug(nvp.getName() + " : " + nvp.getValue());
                me.addPart(nvp.getName(), new StringBody(nvp.getValue()));
            } else {
                log.debug(nvp.getName() + " non valorizzato!");
            }
        }

        if (p.getFiles() != null) {
            for (PaccoFile a : p.getFiles()) {
                me.addPart(a.getId().toString(), new FileBody(a.getFile(), a.getFileName(), a.getMime(), "UTF-8"));
                log.debug("Attached file: " + a.getFileName());

            }
        }

        HttpPost httppost = new HttpPost(this.uri);
        httppost.setEntity(me);
        try {
            log.debug("Sending mail to: " + this.uri);
            HttpResponse response = c.execute(httppost);
            HttpEntity res = response.getEntity();
            if (handleStatus(response)) {
                return EntityUtils.toString(res);
            } else {
                httppost.abort();
                return null;
            }
        } catch (IOException e) {
            log.warn(e);
        }

        return null;
    }

    private boolean handleStatus(HttpResponse response) throws IOException {
        //check status
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode < 300 && statusCode >= 200) {
            return true;
        } else if (statusCode == 404) {
            response.getEntity().getContent().close();
            return false;
        } else if (statusCode < 500 && statusCode >= 400) {
            throw new IllegalArgumentException("Bad request:\nStatus: " + statusCode + "Error:\n" + EntityUtils.toString(response.getEntity()));
        } else if (statusCode >= 500 && statusCode < 600) {
            response.getEntity().getContent().close();
            return false;
        }
        throw new IllegalArgumentException("Unhandled statusCode :" + statusCode);
    }

    private static void trustAllSSL(HttpClient c) {
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS");

            // set up a TrustManager that trusts everything
            try {
                sslContext.init(null,
                        new TrustManager[]{new X509TrustManager() {
                            @Override
                            public X509Certificate[] getAcceptedIssuers() {
                                log.debug("getAcceptedIssuers =============");
                                return null;
                            }

                            @Override
                            public void checkClientTrusted(
                                    X509Certificate[] certs, String authType) {
                                        log.debug("checkClientTrusted =============");
                                    }

                                    @Override
                                    public void checkServerTrusted(
                                            X509Certificate[] certs, String authType) {
                                                log.debug("checkServerTrusted =============");
                                            }
                        }}, new SecureRandom());
            } catch (KeyManagementException e) {
                log.error(e);
            }
            SSLSocketFactory ssf = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = c.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", 443, ssf));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    public static boolean checkEsito(String res) {
        Builder parser = new Builder();
        Document resd;
        try {
            resd = parser.build(res, null);
        } catch (ParsingException | IOException ex) {
            log.error(ex);
            return false;
        }
        // parsare con XOM l'esito
        XPathContext context = new XPathContext("EsitoVersamento", "");
        Nodes risultato = resd.query("//CodiceEsito/text()", context);

        return risultato.get(0).toXML().equals("POSITIVO");
    }
}
