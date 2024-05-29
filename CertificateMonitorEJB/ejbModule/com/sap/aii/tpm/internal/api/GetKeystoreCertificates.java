
package com.sap.aii.tpm.internal.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetKeystoreCertificates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetKeystoreCertificates"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KeystoreName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CertificateAlias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetKeystoreCertificates", propOrder = {
    "keystoreName",
    "certificateAlias"
})
public class GetKeystoreCertificates {

    @XmlElement(name = "KeystoreName")
    protected String keystoreName;
    @XmlElement(name = "CertificateAlias")
    protected String certificateAlias;

    /**
     * Gets the value of the keystoreName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeystoreName() {
        return keystoreName;
    }

    /**
     * Sets the value of the keystoreName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeystoreName(String value) {
        this.keystoreName = value;
    }

    /**
     * Gets the value of the certificateAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateAlias() {
        return certificateAlias;
    }

    /**
     * Sets the value of the certificateAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateAlias(String value) {
        this.certificateAlias = value;
    }

}
