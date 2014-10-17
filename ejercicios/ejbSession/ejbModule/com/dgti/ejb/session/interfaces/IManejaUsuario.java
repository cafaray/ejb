package com.dgti.ejb.session.interfaces;

import java.util.List;

import com.dgti.modelo.Usuario;

public interface IManejaUsuario {

	List<Usuario> listado();
	Usuario buscarPorCuenta(String cuenta);
	List<Usuario> listado(String nombre);
	List<Usuario> listado(String nombre, String apellidos);
	
}
