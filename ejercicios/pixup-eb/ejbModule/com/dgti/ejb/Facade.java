package com.dgti.ejb;

import java.util.List;
import java.util.Properties;

import com.dgti.ejb.interfaces.FacadeLocal;
import com.dgti.ejb.interfaces.FacadeRemote;
import com.dgti.ejb.interfaces.UsuarioLocal;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Artista;
import com.dgti.pixup.model.Usuario;

import javax.ejb.Stateless;
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

import org.jboss.ejb3.annotation.LocalBinding;
import org.jboss.ejb3.annotation.RemoteBinding;

@RemoteBinding(jndiBinding="PixUpFacadeRemote")
@LocalBinding(jndiBinding="PixUpFacadeLocal")
@Stateless
public class Facade implements FacadeRemote, FacadeLocal {

    public Facade() {}

	@Override
	public Usuario registraUsuario(Usuario usuario) throws PixupDAOException {
		try{
			Context context = getContext();
			Object ref = context.lookup("LocalManejaUsuario");   
			UsuarioLocal ejb = (UsuarioLocal)ref;
			return ejb.registra(usuario);
		}catch(NamingException e){
			throw new PixupDAOException("No se logro registrar al usuario. NamingException. ", e);
		}
	}

	@Override
	public Usuario obtenerUsuario(String id) throws PixupDAOException {
		try{
			Context context = getContext();
			Object ref = context.lookup("LocalManejaUsuario");   
			UsuarioLocal ejb = (UsuarioLocal)ref;
			return ejb.encontrar(id);
		}catch(NamingException e){
			throw new PixupDAOException("No se logro encontrar al usuario. NamingException. ", e);
		}
	}

	@Override
	public List<Usuario> listarUsuarios() throws PixupDAOException {
		try{
			Context context = getContext();
			Object ref = context.lookup("LocalManejaUsuario");   
			UsuarioLocal ejb = (UsuarioLocal)ref;
			return ejb.listar();
		}catch(NamingException e){
			throw new PixupDAOException("No se logro listar los usuarios. NamingException. ", e);
		}

	}

	@Override
	public List<Artista> verArtistas() throws PixupDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artista> buscarArtista(String nombre) throws PixupDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario actualizaContrasenia(Usuario usuario, String contrasenia)
			throws PixupDAOException {
		QueueConnection conexion = null;
		QueueSender sender;
		QueueSession session;
		try {
			Context ctx = getContext();
			Queue queue = (Queue)ctx.lookup("queue/pixupRestauraPassword");
			QueueConnectionFactory factory = (QueueConnectionFactory)ctx.lookup("ConnectionFactory");
			conexion = factory.createQueueConnection();
			session = conexion.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);						
			usuario.setPassword(contrasenia);
			ObjectMessage message = session.createObjectMessage(usuario);
			message.setStringProperty("contrasena", contrasenia);						
			sender = session.createSender(queue);
			sender.send(message);			
			return usuario;
		} catch (NamingException e) {
			e.printStackTrace(System.out);
			throw new PixupDAOException(e);
		} catch (JMSException e) {
			e.printStackTrace(System.out);
			throw new PixupDAOException(e);
		}finally{
			try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (JMSException e) {
            }			
		}
	}

	@Override
	public void restauraContrasenia(String correo) throws PixupDAOException {
		// TODO Auto-generated method stub
		
	}

	private static Context getContext() throws NamingException{
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
