package edu.dgsca.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;


//import javax.jms.ObjectMessage;
import edu.dgsca.ejb.modelo.Destinatario;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/dgscaPixupNotificacion") }, mappedName = "dgscaPixupNotificacion")
public class EnviaNotificacion implements MessageListener {

	public EnviaNotificacion() {
	}

	public void onMessage(Message message) {
		try {
			if (message!=null){
			System.out.println("Tipo de mensaje recibido: "
					+ message.getClass().getSimpleName());
			
			if (message instanceof TextMessage || message instanceof ObjectMessage) {				
				//String mensaje = ((TextMessage) message).getText();
				ObjectMessage msg = (ObjectMessage)message;
				Object ref = msg.getObject();
				String cc = message.getStringProperty("cc");
				Destinatario destinatario = (Destinatario)ref;
				//System.out.printf("El mensaje recibido es: %s%n",mensaje);
				System.out.printf("Datos del destinatario: Nombre=%s, Correo=%s, IdCliente=%s",
						destinatario.getNombre(), destinatario.getCorreo(), destinatario.getIdCliente());
				System.out.printf("Propiedad cc=%s%n",cc);				
				
				//aquí podemos realizar un envio por SMS o Correo electrónico o PUSH.
			}
			}else{
				System.out.println("No se recibió ningún mensaje.");
			}
		} catch (ClassCastException e) {
			// Maneja la excpción generada. No se puede retornar debido a que no hay comunicación con el cliente
			// y es una ejecución asíncrona del método
			System.out.println("ejb-ejercicio3 catched "+e.getClass().getSimpleName());
			e.printStackTrace(System.out);
		}catch (JMSException e){
			System.out.println("ejb-ejercicio3 catched "+e.getClass().getSimpleName());
			e.printStackTrace(System.out);			
		}
	}

}
