
package edu.dgsca.ws.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.dgsca.ws.cliente package. 
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

    private final static QName _RegistraPeticionResponse_QNAME = new QName("http://edu.dgsca.ws", "registraPeticionResponse");
    private final static QName _RegistraPeticion_QNAME = new QName("http://edu.dgsca.ws", "registraPeticion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.dgsca.ws.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistraPeticionResponse }
     * 
     */
    public RegistraPeticionResponse createRegistraPeticionResponse() {
        return new RegistraPeticionResponse();
    }

    /**
     * Create an instance of {@link RegistraPeticion }
     * 
     */
    public RegistraPeticion createRegistraPeticion() {
        return new RegistraPeticion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistraPeticionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://edu.dgsca.ws", name = "registraPeticionResponse")
    public JAXBElement<RegistraPeticionResponse> createRegistraPeticionResponse(RegistraPeticionResponse value) {
        return new JAXBElement<RegistraPeticionResponse>(_RegistraPeticionResponse_QNAME, RegistraPeticionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistraPeticion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://edu.dgsca.ws", name = "registraPeticion")
    public JAXBElement<RegistraPeticion> createRegistraPeticion(RegistraPeticion value) {
        return new JAXBElement<RegistraPeticion>(_RegistraPeticion_QNAME, RegistraPeticion.class, null, value);
    }

}
