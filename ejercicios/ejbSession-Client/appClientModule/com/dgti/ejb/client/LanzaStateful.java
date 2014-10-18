package com.dgti.ejb.client;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dgti.ejb.session.interfaces.ManejaUsuarioLocal;
import com.dgti.modelo.Usuario;

public class LanzaStateful {

	public LanzaStateful() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
		// Generar contexto con Jboss
		Context context = getContext();
		// Enlazar la interfaz ManejaUsuarioLocal
		ManejaUsuarioLocal manejaUsuario = (ManejaUsuarioLocal)context.lookup("ManejaUsuarioLocal");
		// Generar al menos tres usuarios y ejecutar los métodos de insertar
		Usuario usuario1 = new Usuario();
			// asignar sus atributos
			usuario1.setCuenta("32908716");
		Usuario usuario2 = new Usuario();
			// asignar sus atributos
			usuario2.setCuenta("eloiza23");
		Usuario usuario3 = new Usuario();
			// asignar sus atributos
			usuario3.setCuenta("cafaray@gmail.com");
		manejaUsuario.registrar(usuario1);
		manejaUsuario.registrar(usuario2);
		manejaUsuario.registrar(usuario3);		
		// Imprimir la lista de usuarios generada
		List<Usuario> usuarios = manejaUsuario.listado();
		int x = 0;
		for(Usuario usuario:usuarios){
			System.out.printf("Usuario %d: %s%n", ++x, usuario.getCuenta());
		}
		// ?? Eliminar el ejb de sesion con estado
		manejaUsuario.cierraSesion();   // ????????????????
		
		}catch(NamingException e){
			System.out.println(e);
			e.printStackTrace(System.out);
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
