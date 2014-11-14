package com.dgti.pixup.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-14T00:43:23.602-0600")
@StaticMetamodel(Domicilio.class)
public class Domicilio_ {
	public static volatile SingularAttribute<Domicilio, Integer> idDomicilio;
	public static volatile SingularAttribute<Domicilio, String> calle;
	public static volatile SingularAttribute<Domicilio, String> numExt;
	public static volatile SingularAttribute<Domicilio, String> numInt;
	public static volatile SingularAttribute<Domicilio, Colonia> colonia;
	public static volatile SingularAttribute<Domicilio, Usuario> usuario;
}
