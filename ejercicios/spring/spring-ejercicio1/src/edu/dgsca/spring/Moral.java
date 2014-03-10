package edu.dgsca.spring;

public class Moral implements IPersona {

	private String nombre;
	private String rfc;
	
	public Moral() {}
	public Moral(String nombre, String rfc) {
		this.nombre = nombre;
		this.rfc = rfc;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getRfc(){
		return this.rfc;
	}
	
	public void setRfc(String rfc){
		this.rfc = rfc;
	}
	
	@Override
	public String getNombreCompleto() {
		return this.nombre;
	}
	
	@Override
	public String getRFC() {
		return this.rfc;
	}	
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}
	
}
