package com.dgti.ejb.interfaces;

import javax.ejb.Remote;

import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;

@Remote
public interface FacadeRemote extends IFacade {
	
	Usuario actualizaContrasenia(Usuario usuario, String contrasenia) throws PixupDAOException;
	
	void restauraContrasenia(String correo) throws PixupDAOException;
	
}
