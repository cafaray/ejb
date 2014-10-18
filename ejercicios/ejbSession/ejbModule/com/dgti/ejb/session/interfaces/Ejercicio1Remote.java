package com.dgti.ejb.session.interfaces;

import javax.ejb.Remote;

import com.dgti.modelo.Usuario;

@Remote
public interface Ejercicio1Remote {
	String sayMyName(String name);
	Usuario registraUsuario(Usuario usuario);
}
