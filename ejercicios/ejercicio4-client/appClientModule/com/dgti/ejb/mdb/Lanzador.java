package com.dgti.ejb.mdb;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dgti.pixup.model.Usuario;

public class Lanzador {

	public static void main(String[] args) {
		QueueConnection conexion = null;
		QueueSender sender;
		QueueSession session;
		try {
			Context ctx = getContext();
			Queue queue = (Queue)ctx.lookup("queue/pixupRestauraPassword");
			QueueConnectionFactory factory = (QueueConnectionFactory)ctx.lookup("ConnectionFactory");
			conexion = factory.createQueueConnection();
			session = conexion.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			Usuario usuario = new Usuario();
			usuario.setPassword("sinPassword");
			ObjectMessage message = session.createObjectMessage(usuario);
			message.setStringProperty("contrasena", "nuevoPassword");			
			
			sender = session.createSender(queue);
			sender.send(message);
			
		} catch (NamingException e) {
			e.printStackTrace(System.out);
		} catch (JMSException e) {
			e.printStackTrace(System.out);
		}finally{
			try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (JMSException e) {
            }			
		}

	}

	
	private static Context getContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		props.put(InitialContext.URL_PKG_PREFIXES,
				"org.jboss.naming:org.jnp.interfaces");
		Context ctx = new InitialContext(props);
		return ctx;
	}

}
