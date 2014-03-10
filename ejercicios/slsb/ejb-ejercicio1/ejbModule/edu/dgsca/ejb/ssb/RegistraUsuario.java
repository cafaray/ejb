package edu.dgsca.ejb.ssb;

import edu.dgsca.ejb.ssb.interfaces.RegistraUsuarioLocal;
import edu.dgsca.ejb.ssb.interfaces.RegistraUsuarioRemote;
import edu.dgsca.exceptions.UsuarioException;
import edu.dgsca.modelo.Usuario;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.LocalBinding;
import org.jboss.ejb3.annotation.RemoteBinding;

@Stateless(mappedName = "RegistraUsuario")
@LocalBinding(jndiBinding="RegistraUsuarioLocal")
@RemoteBinding(jndiBinding="RegistraUsuarioRemoto")
public class RegistraUsuario implements RegistraUsuarioRemote, RegistraUsuarioLocal {

    public RegistraUsuario() {
    	System.out.println("Se genero la instancia del EJB");
    }

	@Override
	public Usuario registraUsuario(String nombre, String apellidos,
			String correo) throws UsuarioException {
		// Aqui debemos ubicar el codigo de logica de negocio
		Usuario usuario = new Usuario(nombre, apellidos, correo);		
		return usuario;
	}

	@Override
	public Usuario registraUsuario(String nombre, String apellidos,
			String correo, String contrasenia) throws UsuarioException {
		// Aqui debemos ubicar el codigo de logica de negocio
		Usuario usuario = new Usuario(nombre, apellidos, correo,contrasenia);		
		return usuario;
	}
}