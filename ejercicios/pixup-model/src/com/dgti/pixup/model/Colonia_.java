package com.dgti.pixup.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-13T22:04:36.394-0600")
@StaticMetamodel(Colonia.class)
public class Colonia_ {
	public static volatile SingularAttribute<Colonia, Integer> idColonia;
	public static volatile SingularAttribute<Colonia, String> cp;
	public static volatile SingularAttribute<Colonia, String> nombre;
	public static volatile SingularAttribute<Colonia, Municipio> municipio;
}
