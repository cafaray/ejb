package com.dgti.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.dgti.pixup.dao.UsuarioDAO;
import com.dgti.pixup.dao.impl.UsuarioDAOImpl;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;

/**
 * Message-Driven Bean implementation class for: RestauraContrasena
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
						propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
				@ActivationConfigProperty(
						propertyName = "destination", propertyValue = "pixupRestauraPassword")
		}, 
		mappedName = "pixupRestauraPassword")
public class RestauraContrasena implements MessageListener {

    /**
     * Default constructor. 
     */
    public RestauraContrasena() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	try{
        UsuarioDAO dao = new UsuarioDAOImpl(Usuario.class);
        if (message!=null){
			System.out.println("Tipo de mensaje recibido: "
					+ message.getClass().getSimpleName());			
			if (message instanceof TextMessage || message instanceof ObjectMessage) {				
				//String mensaje = ((TextMessage) message).getText();
				ObjectMessage msg = (ObjectMessage)message;
				Object ref = msg.getObject();
				Usuario usuario = (Usuario)ref;
				String contrasena = message.getStringProperty("contrasena");
				dao.actualizaContrasena(usuario, contrasena);
			}
        }
    	}catch(PixupDAOException e){
    		e.printStackTrace(System.out);
    	}catch(JMSException e){
    		e.printStackTrace(System.out);
    	}
    }

}
