package edu.dgsca.ejb.ssb.interfaces;

import javax.ejb.Local;

import edu.dgsca.exceptions.UsuarioException;
import edu.dgsca.modelo.Usuario;

@Local
public interface RegistraUsuarioLocal extends IUsuario {
	public Usuario registraUsuario(String nombre, String apellidos, String correo, String contrasenia)throws UsuarioException;
}
