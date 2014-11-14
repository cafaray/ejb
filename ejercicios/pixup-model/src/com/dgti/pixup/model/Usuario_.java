package com.dgti.pixup.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-13T22:04:36.400-0600")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> apMaterno;
	public static volatile SingularAttribute<Usuario, String> apPaterno;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> ext;
	public static volatile SingularAttribute<Usuario, Date> fechaNac;
	public static volatile SingularAttribute<Usuario, String> genero;
	public static volatile SingularAttribute<Usuario, String> nick;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, String> telefono;
}
