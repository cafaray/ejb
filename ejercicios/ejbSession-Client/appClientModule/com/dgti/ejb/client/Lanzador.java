package com.dgti.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dgti.ejb.session.interfaces.Ejercicio1Remote;
import com.dgti.modelo.Usuario;

public class Lanzador {

	public Lanzador() {}

	public static void main(String[] args){
		try {
			Context ctx = getContext();						
			Object ref = ctx.lookup("Ejercicio1");
			Ejercicio1Remote ejercicio1 = (Ejercicio1Remote) ref;			
			System.out.println("El llamado se genero correctamente: " 
			+ ejercicio1.sayMyName("Rubén"));			
		} catch (NamingException e) {
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


/*
 * Usuario usuario = new Usuario();
			usuario.setApellidos("Ramírez");
			usuario.setNombre("Joel");
			usuario.setContrasenia("password");
			usuario.setCorreo("mail@mail.com");
			usuario.setEstatus("A");
			usuario.setCuenta("jramirez");					
			usuario = ejercicio1.registraUsuario(usuario);
			System.out.println(usuario.getCuenta());
*/