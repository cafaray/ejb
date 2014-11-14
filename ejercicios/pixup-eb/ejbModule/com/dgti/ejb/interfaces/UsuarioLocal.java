package com.dgti.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;

@Local
public interface UsuarioLocal {

	Usuario registra(Usuario usuario)throws PixupDAOException;
	List<Usuario> listar() throws PixupDAOException;
	Usuario encontrar(String id) throws PixupDAOException;
	
}
