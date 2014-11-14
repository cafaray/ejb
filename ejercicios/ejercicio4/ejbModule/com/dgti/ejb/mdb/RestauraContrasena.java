package com.dgti.ejb.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dgti.pixup.dao.UsuarioDAO;
import com.dgti.pixup.dao.impl.UsuarioDAOImpl;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;

@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
						propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
				@ActivationConfigProperty(
						propertyName = "destination", propertyValue = "pixupRestauraPassword")
		}, 
		mappedName = "pixupRestauraPassword")
public class RestauraContrasena implements MessageListener {

	@Resource(mappedName = "java:Mail")
	Session mailSession;
	
    public RestauraContrasena() {}
	
    public void onMessage(Message message) {
    	try{
        
        if (message!=null){
			System.out.println("Tipo de mensaje recibido: "
					+ message.getClass().getSimpleName());			
			if (message instanceof TextMessage || message instanceof ObjectMessage) {				
				//String mensaje = ((TextMessage) message).getText();
				ObjectMessage msg = (ObjectMessage)message;
				Object ref = msg.getObject();
				Usuario usuario = (Usuario)ref;
				System.out.println("USUARIO =====> " + usuario.toString());
				String contrasena = message.getStringProperty("contrasena");
				UsuarioDAO dao = new UsuarioDAOImpl(Usuario.class);
				dao.actualizaContrasena(usuario, contrasena);
				if(!usuario.getEmail().isEmpty()){
					try {
						//se envia un correo electrónico:
						MimeMessage mailMessage = new MimeMessage(mailSession);
						mailMessage.setSubject("Notificación de Pixup");
						String user = mailSession.getProperty("mail.user");
						String textoMensaje = "Se ha reataurado la contrase&ntilde;a con &eacute;xito.";
						mailMessage.setRecipients(javax.mail.Message.RecipientType.TO,
								javax.mail.internet.InternetAddress.parse(usuario.getEmail(),
										false));
						mailMessage.setFrom(new InternetAddress(user));
						mailMessage.setContent(textoMensaje, "text/html; charset=utf-8");
						mailMessage.saveChanges();
						Transport transport = mailSession.getTransport("smtp");
						try {
							transport.connect();
							transport.sendMessage(mailMessage,
									mailMessage.getAllRecipients());
						} finally {
							transport.close();
						}
					} catch (MessagingException e) {						
						e.printStackTrace();
					}		
				}
			}
        }
    	}catch(PixupDAOException e){
    		e.printStackTrace(System.out);
    	}catch(JMSException e){
    		e.printStackTrace(System.out);
    	}
    }

}
