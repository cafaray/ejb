package com.dgti.ejb.interfaces;

import java.util.List;

import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Artista;
import com.dgti.pixup.model.Usuario;

public interface IFacade {
	
	Usuario registraUsuario(Usuario usuario)throws PixupDAOException;
	Usuario obtenerUsuario(String id)throws PixupDAOException;
	List<Usuario> listarUsuarios() throws PixupDAOException;
	List<Artista> verArtistas() throws PixupDAOException;
	List<Artista> buscarArtista(String nombre) throws PixupDAOException;
	
}
