package edu.dgsca.ejb.ssb.interfaces;

import edu.dgsca.exceptions.UsuarioException;
import edu.dgsca.modelo.Usuario;

public interface IUsuario {
	public Usuario registraUsuario(String nombre, String apellidos, String correo)throws UsuarioException;
}
