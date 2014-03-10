package edu.dgsca.modelo;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 9075837990579303536L;
	private String nombre;
	private String apellidos;
	private String rfc;
	
	public Persona() {}
	public Persona(String nombre, String apellidos, String rfc) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	@Override
	public String toString(){
		return nombre+" "+apellidos+". RFC: "+rfc;
	}

	
}
