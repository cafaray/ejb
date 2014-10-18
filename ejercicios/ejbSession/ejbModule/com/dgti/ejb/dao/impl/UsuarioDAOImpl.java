package com.dgti.ejb.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.dgti.ejb.dao.UsuarioDAO;
import com.dgti.modelo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	
	private Map<String, Usuario> usuarios;
	
	public UsuarioDAOImpl() {
		usuarios = new TreeMap<String, Usuario>();
	}

	@Override
	public Usuario findById(String id) {
		return usuarios.get(id);
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> vuelta = (List<Usuario>) usuarios.values();
		return vuelta;
	}

	@Override
	public List<Usuario> findAll(String cuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desactivar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
