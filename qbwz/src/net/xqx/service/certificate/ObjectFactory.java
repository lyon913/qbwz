
package net.xqx.service.certificate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.xqx.service.certificate package. 
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

    private final static QName _GetCertificates_QNAME = new QName("http://certificate.service.xqx.net/", "getCertificates");
    private final static QName _GetCertificatesResponse_QNAME = new QName("http://certificate.service.xqx.net/", "getCertificatesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.xqx.service.certificate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCertificatesResponse }
     * 
     */
    public GetCertificatesResponse createGetCertificatesResponse() {
        return new GetCertificatesResponse();
    }

    /**
     * Create an instance of {@link GetCertificates }
     * 
     */
    public GetCertificates createGetCertificates() {
        return new GetCertificates();
    }

    /**
     * Create an instance of {@link CertificateReg }
     * 
     */
    public CertificateReg createCertificateReg() {
        return new CertificateReg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCertificates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://certificate.service.xqx.net/", name = "getCertificates")
    public JAXBElement<GetCertificates> createGetCertificates(GetCertificates value) {
        return new JAXBElement<GetCertificates>(_GetCertificates_QNAME, GetCertificates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCertificatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://certificate.service.xqx.net/", name = "getCertificatesResponse")
    public JAXBElement<GetCertificatesResponse> createGetCertificatesResponse(GetCertificatesResponse value) {
        return new JAXBElement<GetCertificatesResponse>(_GetCertificatesResponse_QNAME, GetCertificatesResponse.class, null, value);
    }

}
