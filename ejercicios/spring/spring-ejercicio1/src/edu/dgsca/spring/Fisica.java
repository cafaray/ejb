package edu.dgsca.spring;

public class Fisica implements IPersona {

	private String nombre;
	private String apellidos;
	private String rfc;
	
	public Fisica() {}

	public Fisica(String nombre, String apellidos, String rfc){
		this.setNombre(nombre);
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
		return this.rfc;
	}
	
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}		
	
	@Override
	public String getNombreCompleto() {
		return this.getNombre()+" "+this.apellidos;
	}

	@Override
	public String getRFC() {
		return "RFC: " +this.rfc;
	}	
}
