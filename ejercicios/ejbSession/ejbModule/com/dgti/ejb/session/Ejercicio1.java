package com.dgti.ejb.session;

import com.dgti.ejb.session.interfaces.Ejercicio1Remote;

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
    
    

}
