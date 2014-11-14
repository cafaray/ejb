package com.dgti.pixup.dao.impl;

import com.dgti.pixup.dao.UsuarioDAO;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;



public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, String> implements UsuarioDAO{

    public UsuarioDAOImpl(Class<Usuario> clase) {
        super(clase);
    }

    @Override
    public void recuperaContrasena(String correoElectronico) throws PixupDAOException {
        //TODO implementar el llamado al metodo enviaCorreo del MDB
    }
    
	@Override
	public Usuario actualizaContrasena(Usuario usuario, String contrasena) throws PixupDAOException {
		usuario.setPassword(contrasena);
    	super.update(usuario);
    	return usuario;
	}
}
