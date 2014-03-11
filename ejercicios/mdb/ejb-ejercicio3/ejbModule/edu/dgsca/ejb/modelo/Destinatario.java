package edu.dgsca.ejb.modelo;

import java.io.Serializable;

public class Destinatario implements Serializable {

	private static final long serialVersionUID = -6212728525615784001L;
	private String nombre;
	private String correo;
	private String idCliente;
	
	public Destinatario() {}

	public Destinatario(String nombre, String correo, String idCliente){
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setIdCliente(idCliente);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
}
