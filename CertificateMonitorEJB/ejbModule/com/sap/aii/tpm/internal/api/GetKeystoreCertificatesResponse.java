
package com.sap.aii.tpm.internal.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetKeystoreCertificatesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetKeystoreCertificatesResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KeystoreCertsList" type="{http://sap.com/aii/tpm/internal/api/}Certificate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetKeystoreCertificatesResponse", propOrder = {
    "keystoreCertsList"
})
public class GetKeystoreCertificatesResponse {

    @XmlElement(name = "KeystoreCertsList")
    protected List<Certificate> keystoreCertsList;

    /**
     * Gets the value of the keystoreCertsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keystoreCertsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeystoreCertsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Certificate }
     * 
     * 
     */
    public List<Certificate> getKeystoreCertsList() {
        if (keystoreCertsList == null) {
            keystoreCertsList = new ArrayList<Certificate>();
        }
        return this.keystoreCertsList;
    }

}
