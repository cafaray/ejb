package com.dgti.ejb.dao;

import java.util.List;

import com.dgti.modelo.Usuario;

public interface UsuarioDAO {	
	
	Usuario findById(String id);
	List<Usuario> findAll();
	List<Usuario> findAll(String cuenta);
	List<Usuario> findAll(String nombre, String apellidos);
	Usuario insertar(Usuario usuario);
	Usuario actualizar(Usuario usuario);
	void eliminar(Usuario usuario);
	void desactivar(Usuario usuario);
	
}
