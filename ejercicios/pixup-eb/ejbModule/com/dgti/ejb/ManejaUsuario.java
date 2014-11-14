package com.dgti.ejb;

import java.util.List;

import com.dgti.ejb.interfaces.UsuarioLocal;
import com.dgti.pixup.dao.UsuarioDAO;
import com.dgti.pixup.dao.impl.UsuarioDAOImpl;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.LocalBinding;

@LocalBinding(jndiBinding="ManejaUsuarioLocal")
@Stateless
public class ManejaUsuario implements UsuarioLocal {

	UsuarioDAO dao;
	
    public ManejaUsuario() {}

	@Override
	public Usuario registra(Usuario usuario) throws PixupDAOException {
		dao = new UsuarioDAOImpl(Usuario.class);
		return dao.save(usuario);
	}

	@Override
	public List<Usuario> listar() throws PixupDAOException {
		dao = new UsuarioDAOImpl(Usuario.class);
		return dao.findAll();
	}

	@Override
	public Usuario encontrar(String id) throws PixupDAOException {
		dao = new UsuarioDAOImpl(Usuario.class);
		return dao.findById(id);
	}    

}
