package com.dgti.ejb.session.interfaces;

import javax.ejb.Remote;

@Remote
public interface Ejercicio1Remote {
	String sayMyName(String name);
}
