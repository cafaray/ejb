package edu.dgsca.modelo;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona implements Serializable {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identificador;
	private String nombre;
	private String apellidos;
	private String rfc;
	private static final long serialVersionUID = 1L;

	public Persona() {
		super();
	}   
	public int getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getApellidos() {
		return this.apellidos;
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
   
}
