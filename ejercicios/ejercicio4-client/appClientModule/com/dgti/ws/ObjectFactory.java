
package com.dgti.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dgti.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistraArtista_QNAME = new QName("http://ejb.dgti.com/", "registraArtista");
    private final static QName _RegistraArtistaResponse_QNAME = new QName("http://ejb.dgti.com/", "registraArtistaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dgti.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistraArtista }
     * 
     */
    public RegistraArtista createRegistraArtista() {
        return new RegistraArtista();
    }

    /**
     * Create an instance of {@link RegistraArtistaResponse }
     * 
     */
    public RegistraArtistaResponse createRegistraArtistaResponse() {
        return new RegistraArtistaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistraArtista }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.dgti.com/", name = "registraArtista")
    public JAXBElement<RegistraArtista> createRegistraArtista(RegistraArtista value) {
        return new JAXBElement<RegistraArtista>(_RegistraArtista_QNAME, RegistraArtista.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistraArtistaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.dgti.com/", name = "registraArtistaResponse")
    public JAXBElement<RegistraArtistaResponse> createRegistraArtistaResponse(RegistraArtistaResponse value) {
        return new JAXBElement<RegistraArtistaResponse>(_RegistraArtistaResponse_QNAME, RegistraArtistaResponse.class, null, value);
    }

}
