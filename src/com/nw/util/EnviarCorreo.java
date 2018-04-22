package com.nw.util;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.util.Properties;

public class EnviarCorreo {

	static String cuenta = "soportesistemanw@gmail.com";
	static String clave ="nirsa2014";

	
//	static String vdescor = "hnavarrete@nirsa.com";
//	static String vclacor ="hn013pja";

	
	public EnviarCorreo() {
	 
	}
	
	
	/**
	 * @param args
	 */
	public void enviar(String contenidoMensaje, String correoRepresentante) {
       
		//Obtenemos los datos del Usuario				
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
//            props.setProperty("mail.smtp.host", "mailpja.nirsa.com");
//            props.setProperty("mail.smtp.starttls.enable", "true");
//            props.setProperty("mail.smtp.port", "465");
            
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            
            
            props.setProperty("mail.smtp.user", cuenta);
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);

            //Quien lo envia //
    		message.setFrom(new InternetAddress(cuenta));
            
            //A quien va dirigdo
            message.addRecipient(
    
            	Message.RecipientType.TO,new InternetAddress(correoRepresentante.trim()));   //txtCorreo.getValue()//flavioalfaro
            
            message.setSubject("Sistema NW - NOTIFICACION ADMINISTRADOR");
            message.setText(contenidoMensaje);

            // Lo enviamos
    		
            Transport t = session.getTransport("smtp");
    		t.connect(cuenta, clave);
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            System.out.println("correo enviado con exito ");

        }
        catch (Exception e)
        {
        	System.out.println("paso esto-->"+e.toString());
        	System.out.println("verifique si tiene conexion a internet");
        	 //Verifique su conexion a internet y vuelva a Intentarlo.. No se envio el correo
        }		  

	}

}
