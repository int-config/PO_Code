package com.sap.aii.tpm.internal.api;

/**
 * Service implementation of {KeystoreServiceApi_Service} (generated by SAP WSDL to Java generator).
 */
@javax.xml.ws.WebServiceClient(name = "KeystoreServiceApi_Service", targetNamespace = "http://sap.com/aii/tpm/internal/api/", wsdlLocation = "META-INF/wsdl/com/sap/aii/tpm/internal/api/rootwsdl_KeystoreService_KeystoreServiceApi/rootwsdl_KeystoreService_KeystoreServiceApi.wsdl")
public class KeystoreServiceApiService extends javax.xml.ws.Service {

  private final static java.net.URL KEYSTORESERVICEAPISERVICE_WSDL_LOCATION = null;
  /**
   * Default service constructor.
   */
  public KeystoreServiceApiService() throws java.net.MalformedURLException {
    super(KEYSTORESERVICEAPISERVICE_WSDL_LOCATION, new javax.xml.namespace.QName("http://sap.com/aii/tpm/internal/api/", "KeystoreServiceApi_Service"));
  }
  public KeystoreServiceApiService(java.net.URL wsdlLocation, javax.xml.namespace.QName serviceName) {
    super(wsdlLocation, serviceName);
  }
  /**
   * Get method for webservice port [KeystoreServiceApi_Port].
   */
  @javax.xml.ws.WebEndpoint(name = "KeystoreServiceApi_Port")
  public com.sap.aii.tpm.internal.api.KeystoreServiceApi getKeystoreServiceApi_Port() {
    javax.xml.namespace.QName portName = new javax.xml.namespace.QName("http://sap.com/aii/tpm/internal/api/","KeystoreServiceApi_Port");
    return (com.sap.aii.tpm.internal.api.KeystoreServiceApi) super.getPort(portName,com.sap.aii.tpm.internal.api.KeystoreServiceApi.class);
  }
}
