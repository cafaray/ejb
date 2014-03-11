package edu.dgsca.app;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.dgsca.ejb.ssb.interfaces.RegistraUsuarioRemote;
import edu.dgsca.exceptions.UsuarioException;
import edu.dgsca.modelo.Usuario;

public class Principal {
	public static void main(String[] args) {
		try {
			Context ctx = getContext();						
			Object ref = ctx.lookup("RegistraUsuarioRemoto");
			RegistraUsuarioRemote registraUsuario = (RegistraUsuarioRemote) ref;
			Usuario usuario = registraUsuario.registraUsuario("Alberto",
					"Neri Arias", "aneri@gmail.com");
			System.out.println("El usuario se genero correctamente: "
					+ usuario.toString());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
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