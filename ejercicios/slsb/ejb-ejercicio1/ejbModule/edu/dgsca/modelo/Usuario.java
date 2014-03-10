package edu.dgsca.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{


	private static final long serialVersionUID = 6931453995729691684L;
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasenia;
	
	
	public Usuario() {}

	public Usuario(String nombre, String apellidos, String correo, String contrasenia){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	public Usuario(String nombre, String apellidos, String correo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasenia = "x-Set"+correo; //es recomendable implementar una función de asignacion de pwd aleatorio.
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


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	@Override
	public String toString(){
		return nombre+" "+apellidos;
	}

}
