package com.nw.util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.nw.model.Correo;
import com.nw.model.Parametro;
import com.nw.model.dao.impl.CorreosDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;

public class EmailUtil 
{
	private Parametro parametro;
	private List<Correo> correos = new ArrayList<Correo>();
	
	private String lista_correos;
	private String smtpHostServer;
	private String emailID;
	private Properties props;
	private Session session;
	
	public void EnviarCorreo(String mensaje, String titulo) 
	{	
		
		lista_correos = "";
		//Valida si el paramatro para envio de correos esta activado
		parametro=new ParametroDAOJpaImpl().getParametroById("1120");
		
		//Permiso para enviar correos
		if (parametro.getPermiso().equals("S"))
		{
			
			correos = new CorreosDAOJpaImpl().getCorreos();
			
			
			//lista_correos = "nintriago@nirsa.com, hnavarrete@nirsa.com";
			//Existen Correos habilitados
			if (correos.size() > 0)
			{
				
				for (Correo o: correos)
				{
					lista_correos = lista_correos + o.getCorreo() + ", ";
				}
				System.out.println(lista_correos);
				//lista_correos = "nintriago@nirsa.com, hnavarrete@nirsa.com";
				//System.out.println("SimpleEmail Start");
				
			    smtpHostServer = "mail.nirsa.com";
			    
			    //String emailID = "nintriago@nirsa.com";
			    emailID = "";
			    
			    props = System.getProperties();

			    props.put("mail.smtp.host", smtpHostServer);

			    session = Session.getInstance(props, null);
			    
			    try {
					sendEmail(session, emailID, titulo, mensaje, lista_correos);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
	}
	

	
	public static void sendEmail(Session session, String toEmail, String subject, String body, String ListaCorreos)
	{
		
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      //msg.setSubject(arg0, arg1);
	      //msg.setFrom(new InternetAddress("alarmasnw@nirsa.com", "AlarmasNw"));
	      msg.setFrom(new InternetAddress("alarmasnw@nirsa.com", "AlarmasNW"));
	      //msg.setContent(message,"text/html");
	      
	      
	      msg.setReplyTo(InternetAddress.parse("alarmasnw@nirsa.com", false));
	      //msg.setReplyTo(InternetAddress.parse("nintriago@nirsa.com", false));
	      

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());
	     // msg.setContent("<div style='background-color:red'> Lote Caido </div>","text/html");
	      
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      msg.addRecipients(Message.RecipientType.TO, ListaCorreos);
	      //System.out.println("Mensaje fue enviado");
    	  Transport.send(msg);  

	      //System.out.println("EMail,enviado satisfactoriamente!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}	
	
}