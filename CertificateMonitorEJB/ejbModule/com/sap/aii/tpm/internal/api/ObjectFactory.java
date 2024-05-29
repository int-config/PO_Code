
package com.sap.aii.tpm.internal.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sap.aii.tpm.internal.api package. 
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

    private final static QName _GetKeystoreCertificates_QNAME = new QName("http://sap.com/aii/tpm/internal/api/", "GetKeystoreCertificates");
    private final static QName _GetKeystoreCertificatesResponse_QNAME = new QName("http://sap.com/aii/tpm/internal/api/", "GetKeystoreCertificatesResponse");
    private final static QName _TPMException_QNAME = new QName("http://sap.com/aii/tpm/internal/api/", "TPMException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sap.aii.tpm.internal.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetKeystoreCertificates }
     * 
     */
    public GetKeystoreCertificates createGetKeystoreCertificates() {
        return new GetKeystoreCertificates();
    }

    /**
     * Create an instance of {@link GetKeystoreCertificatesResponse }
     * 
     */
    public GetKeystoreCertificatesResponse createGetKeystoreCertificatesResponse() {
        return new GetKeystoreCertificatesResponse();
    }

    /**
     * Create an instance of {@link TPMException }
     * 
     */
    public TPMException createTPMException() {
        return new TPMException();
    }

    /**
     * Create an instance of {@link Certificate }
     * 
     */
    public Certificate createCertificate() {
        return new Certificate();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKeystoreCertificates }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetKeystoreCertificates }{@code >}
     */
    @XmlElementDecl(namespace = "http://sap.com/aii/tpm/internal/api/", name = "GetKeystoreCertificates")
    public JAXBElement<GetKeystoreCertificates> createGetKeystoreCertificates(GetKeystoreCertificates value) {
        return new JAXBElement<GetKeystoreCertificates>(_GetKeystoreCertificates_QNAME, GetKeystoreCertificates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKeystoreCertificatesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetKeystoreCertificatesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://sap.com/aii/tpm/internal/api/", name = "GetKeystoreCertificatesResponse")
    public JAXBElement<GetKeystoreCertificatesResponse> createGetKeystoreCertificatesResponse(GetKeystoreCertificatesResponse value) {
        return new JAXBElement<GetKeystoreCertificatesResponse>(_GetKeystoreCertificatesResponse_QNAME, GetKeystoreCertificatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPMException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TPMException }{@code >}
     */
    @XmlElementDecl(namespace = "http://sap.com/aii/tpm/internal/api/", name = "TPMException")
    public JAXBElement<TPMException> createTPMException(TPMException value) {
        return new JAXBElement<TPMException>(_TPMException_QNAME, TPMException.class, null, value);
    }

}
