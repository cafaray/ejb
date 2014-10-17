package com.dgti.ejb.session;


import java.util.List;

import com.dgti.ejb.session.interfaces.ManejaUsuarioLocal;
import com.dgti.ejb.session.interfaces.ManejaUsuarioRemote;
import com.dgti.modelo.Usuario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ManejaUsuario implements ManejaUsuarioRemote, ManejaUsuarioLocal {
	
    public ManejaUsuario() {}

	@Override
	public List<Usuario> listado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorCuenta(String cuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listado(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listado(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desactivar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

    
    
}
