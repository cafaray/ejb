package com.dgti.modelo;

public class Usuario {

	private String cuenta;
	private String correo;
	private String nombre;
	private String apellidos;
	private String contrasenia;
	private String estatus;
	
	public Usuario() {}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEstatus(){
		return this.estatus;
	}
	
	public void setEstatus(String estatus){
		this.estatus = estatus;
	}
	
}
