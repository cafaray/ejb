package com.dgti.ejb.session;


import java.util.ArrayList;
import java.util.List;

import com.dgti.ejb.dao.UsuarioDAO;
import com.dgti.ejb.dao.impl.UsuarioDAOImpl;
import com.dgti.ejb.session.interfaces.ManejaUsuarioLocal;
import com.dgti.ejb.session.interfaces.ManejaUsuarioRemote;
import com.dgti.modelo.Usuario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ManejaUsuario implements ManejaUsuarioRemote, ManejaUsuarioLocal {
	
	private UsuarioDAO dao;
	
    public ManejaUsuario() {
    	dao = new UsuarioDAOImpl();
    }

	@Override
	public List<Usuario> listado() {
		return dao.findAll();
	}

	@Override
	public Usuario buscarPorCuenta(String cuenta) {
		if(cuenta!=null && !cuenta.isEmpty()){
			return dao.findById(cuenta);
		}else {
			return new Usuario();
		}
	}

	@Override
	public List<Usuario> listado(String nombre) {
		return dao.findAll(nombre, "");
	}

	@Override
	public List<Usuario> listado(String nombre, String apellidos) {
		if(nombre!=null && apellidos!=null){
			return dao.findAll(nombre, apellidos);
		}else{
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		return usuario!=null?dao.actualizar(usuario):new Usuario();
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		return dao.insertar(usuario);
	}

	@Override
	public void desactivar(Usuario usuario) {
		if(usuario!=null && usuario.getEstatus().equals("A")){
			dao.desactivar(usuario);
		} else {
			// NOTHING TO DOss
		}
	}
    
}
