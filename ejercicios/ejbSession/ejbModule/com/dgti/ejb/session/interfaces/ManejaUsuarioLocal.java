package com.dgti.ejb.session.interfaces;

import javax.ejb.Local;

import com.dgti.modelo.Usuario;

@Local
public interface ManejaUsuarioLocal {

	Usuario actualizar(Usuario usuario);
	Usuario registrar(Usuario usuario);
	void desactivar(Usuario usuario);
	
}
