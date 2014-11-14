package com.dgti.pixup.test;

import java.util.List;

import com.dgti.pixup.dao.UsuarioDAO;
import com.dgti.pixup.dao.impl.UsuarioDAOImpl;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;

public class Lanzador {

	public static void main(String[] args) throws PixupDAOException {
		
		UsuarioDAO dao = new UsuarioDAOImpl(Usuario.class);
		List<Usuario> usuarios = dao.findAll();
		for(Usuario usuario:usuarios){
			System.out.println(usuario.toString());
		}
	}

}
