package com.sap.aii.tpm.internal.api;

/**
 * Exception class for service fault.
 */
@javax.xml.ws.WebFault(name = "TPMException", targetNamespace = "http://sap.com/aii/tpm/internal/api/", faultBean = "com.sap.aii.tpm.internal.api.TPMException")
public class GetKeystoreCertificatesFault extends java.lang.Exception {

  private com.sap.aii.tpm.internal.api.TPMException _GetKeystoreCertificatesFault;

  public GetKeystoreCertificatesFault(String message, com.sap.aii.tpm.internal.api.TPMException faultInfo){
    super(message);
    this._GetKeystoreCertificatesFault = faultInfo;
  }

  public GetKeystoreCertificatesFault(String message, com.sap.aii.tpm.internal.api.TPMException faultInfo, Throwable cause){
    super(message);
    this._GetKeystoreCertificatesFault = faultInfo;
  }

  public com.sap.aii.tpm.internal.api.TPMException getFaultInfo(){
    return this._GetKeystoreCertificatesFault;
  }

}
