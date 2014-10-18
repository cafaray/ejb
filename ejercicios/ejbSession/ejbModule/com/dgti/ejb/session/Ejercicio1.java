package com.dgti.ejb.session;

import com.dgti.ejb.dao.UsuarioDAO;
import com.dgti.ejb.dao.impl.UsuarioDAOImpl;
import com.dgti.ejb.session.interfaces.Ejercicio1Remote;
import com.dgti.modelo.Usuario;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;

@RemoteBinding(jndiBinding="Ejercicio1")
@Stateless
public class Ejercicio1 implements Ejercicio1Remote {

    public Ejercicio1() {}

	@Override
	public String sayMyName(String name) {
		return "Hello World, your name is "+name;
	}
    
	@Override
	public Usuario registraUsuario(Usuario usuario){
		UsuarioDAO dao = new UsuarioDAOImpl();
		if(usuario!=null && usuario.getCuenta()!=null && !usuario.getCuenta().isEmpty()){
			return dao.insertar(usuario);
		}else {
			return new Usuario();
		}
		
	}

}
