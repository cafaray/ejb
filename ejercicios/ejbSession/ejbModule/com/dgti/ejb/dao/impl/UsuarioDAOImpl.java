package com.dgti.ejb.dao.impl;

import java.util.ArrayList;
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

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for(String idCuenta:usuarios.keySet()){
			if(idCuenta.contains(cuenta)){
				listaUsuarios.add(usuarios.get(idCuenta));
			}
		}
		
		return listaUsuarios;
	}

	@Override
	public List<Usuario> findAll(String nombre, String apellidos) {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for(Usuario usuario:usuarios.values()){
			if(usuario.getNombre().contains(nombre) 
				&& usuario.getApellidos().contains(apellidos)){
				listaUsuarios.add(usuario);
			}
		}
		
		return listaUsuarios;
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		usuarios.put(usuario.getCuenta(), usuario);
		return usuario;
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		return insertar(usuario);
	}

	@Override
	public void eliminar(Usuario usuario) {
		usuarios.remove(usuario.getCuenta());
		
	}

	@Override
	public void desactivar(Usuario usuario) {
		usuario.setEstatus("I");
		actualizar(usuario);
	}

}
