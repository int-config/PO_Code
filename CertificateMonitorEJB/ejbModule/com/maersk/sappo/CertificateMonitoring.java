package com.maersk.sappo;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import com.sap.aii.tpm.internal.api.Certificate;
import com.sap.aii.tpm.internal.api.KeystoreServiceApi;
import com.sap.aii.tpm.internal.api.KeystoreServiceApiService;
import com.sap.httpclient.HostConfiguration;
import com.sap.httpclient.HttpClient;
import com.sap.httpclient.http.HttpStatus;
import com.sap.httpclient.http.methods.InputStreamRequestData;
import com.sap.httpclient.http.methods.POST;
import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

/**
 * Message-Driven Bean implementation class for: CertificateMonitoring
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='CertificateMonitoring' AND ApplicationName='sap.com/CertificateMonitorEAR'") })
public class CertificateMonitoring extends MDBJobImplementation {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see MDBJobImplementation#MDBJobImplementation()
     */
	@WebServiceRef(name="KeystoreServiceApi")KeystoreServiceApiService service;
	
	@Resource(name="ServiceURL")String ServiceURL;
	@Resource(name="ServiceUser")String ServiceUser;
	@Resource(name="ServicePassword")String ServicePassword;
	@Resource(name="EnableProxy")Boolean EnableProxy;
	@Resource(name="ProxyHost")String ProxyHost;
	@Resource(name="ProxyPort")Integer ProxyPort;
	
	@Resource(name="SendGridURL")String SendGridURL;
	@Resource(name="SendGridAPIKey")String SendGridAPIKey;
	//@Resource(name="mail/MailSession")Session session;
	
    public CertificateMonitoring() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void onJob(JobContext jobContext) throws Exception
	{
		try
		{
			//Test Comment
			//New Comment
			//New Update
			//Hello World
			//SAP New Changes
			//Contributor
			//Feature
			//Protection
			//InitialContext ctx = new InitialContext();
			//ApplicationPropertiesAccess prop = (ApplicationPropertiesAccess)ctx.lookup("ApplicationConfiguration");
			//Properties appProp = prop.getApplicationProperties();
			String KSViews[] = jobContext.getJobParameter("KeyStoreViews").getStringValue().split("\\|", -1);
			String DaysToExpire = jobContext.getJobParameter("DaysToExpire").getStringValue();
			String EmailID = jobContext.getJobParameter("EmailID").getStringValue();
			//String ServicePassword = jobContext.getJobParameter("ServicePassword").getStringValue();
			//String ServiceEndPoint = jobContext.getJobParameter("ServiceEndPoint").getStringValue();
			Logger log = jobContext.getLogger();
			log.info("Starting!!!");
			
			KeystoreServiceApi port = service.getKeystoreServiceApi_Port();
			BindingProvider bp = (BindingProvider)port;
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, ServiceUser);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, ServicePassword);
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ServiceURL);
			List<Certificate> expringCerts = new ArrayList<Certificate>();
			for(int j=0;j<KSViews.length;j++)
			{
				List<Certificate> certs = port.getKeystoreCertificates(KSViews[j].trim(), "*");
				//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
				LocalDate localCurrentDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				for(int i=0;i<certs.size();i++)
				{
					Date certEndDate = certs.get(i).getEndDate().toGregorianCalendar().getTime();
					LocalDate localCertEndDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(certEndDate));
					long days = ChronoUnit.DAYS.between(localCurrentDate,localCertEndDate);
					if(days >= 0 && days <= Integer.valueOf(DaysToExpire))
					{
						expringCerts.add(certs.get(i));
					}
					log.info("Certificate Alias = "+certs.get(i).getAliasName()+" | Certificate End Date = "+localCertEndDate+" | Local Current Date = "+localCurrentDate+" | "+days);
				}
			}
			
			if(expringCerts.size() == 0)
			{
				log.info("No expiring certificates found!");
			}
			else
			{
				for(int i=0;i<expringCerts.size();i++)
				{
					log.warning("Certificate alias "+expringCerts.get(i).getAliasName()+" in keystore view "+expringCerts.get(i).getViewName()+" is expiring within next " +DaysToExpire+" days!");
				}
			}
			/*MimeMessage mm = new MimeMessage(session);
			mm.setSubject("THis is Subject");
			mm.setContent("Hello!!","text/html;charset=UTF-8");
			mm.setRecipients(Message.RecipientType.TO, EmailID);
			InternetAddress[] From = new InternetAddress[]{new InternetAddress("NP6@maersk.com")};
			mm.addFrom(From);
			//Transport.send(mm);
			session.getTransport("smtp").send(mm);*/
			this.sendMailNotification(EmailID, expringCerts, log);
			log.info("Exiting!!!");
		}
		catch(Exception e)
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			throw new Exception("Error in CertificateMonitoring : "+sw.toString());
		}
	}
	
	public void sendMailNotification(String to,List<Certificate> expiringCerts, Logger log) throws Exception
	{
		try
		{
			HttpClient client = new HttpClient();
			if(EnableProxy)
			{
				HostConfiguration hostConfig = new HostConfiguration("api.sendgrid.com",443);
				hostConfig.setProxy(ProxyHost,ProxyPort);
				client.setHostConfiguration(hostConfig);
			}
			POST post = new POST(SendGridURL);
			String table = "<table><tr><th>S/N</th></tr><tr><th>KeyStore View</th></tr><tr><th>Alias</th></tr><tr><th>Certificate End Date</th></tr>";
			for(int i=0;i<expiringCerts.size();i++)
			{
				table+="<tr><td>"+(i+1)+"</td></tr><tr><td>"+expiringCerts.get(i).getViewName()+"</td></tr><tr><td>"+expiringCerts.get(i).getAliasName()+"</td></tr><tr><td>"+expiringCerts.get(i).getEndDate()+"</td></tr><tr><td>Days To Expire</td></tr>";
			}
			table+="</table>";
			String htmlBody = "<html><body>Hello,<br><br>This notification is to inform you that below mentioned certificates are about to expire soon. Kindly take action accordingly.<br><br>"+table+"<br><br><br>Thanks,<br>SAP Integration Team</body></html>";
			String input = "{\"personalizations\": [{\"to\": [{\"email\": \""+to+"\",\"name\": \"\"}],\"subject\": \"Certification Expiry Notification\"}],\"content\": [{\"type\": \"text/html\",\"value\": \""+htmlBody+"\"}],\"from\": {\"email\": \"NP6@maersk.com\",\"name\": \"SAP NP6\"}}";
			ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
			post.setRequestHeader("Authorization", "Bearer "+SendGridAPIKey);
			post.setRequestHeader("Content-Type", "application/json");
			post.setRequestData(new InputStreamRequestData(bais));
			client.executeMethod(post);
			if(post.getStatusCode() == HttpStatus.SC_OK)
			{
				log.info("Mail Sent Successfully!");
			}
			else
			{
				log.warning("Error : "+post.getStatusLine().toString());
			}
		}
		catch(Exception e)
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			throw new Exception("Error in SendMailNotification : "+sw.toString());
		}
	}
}