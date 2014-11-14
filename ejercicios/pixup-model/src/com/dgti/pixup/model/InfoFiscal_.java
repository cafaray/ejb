package com.dgti.pixup.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-13T22:04:36.398-0600")
@StaticMetamodel(InfoFiscal.class)
public class InfoFiscal_ {
	public static volatile SingularAttribute<InfoFiscal, Integer> idInfoFiscal;
	public static volatile SingularAttribute<InfoFiscal, String> razonSocial;
	public static volatile SingularAttribute<InfoFiscal, String> rfc;
	public static volatile SingularAttribute<InfoFiscal, Domicilio> domicilio;
	public static volatile SingularAttribute<InfoFiscal, Usuario> usuario;
}
