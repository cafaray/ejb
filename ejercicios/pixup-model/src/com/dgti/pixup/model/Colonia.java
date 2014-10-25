package com.dgti.pixup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the colonia database table.
 * 
 */
@Entity
@Table(name="colonia")
@NamedQuery(name="Colonia.findAll", query="SELECT c FROM Colonia c")
public class Colonia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colonia")
	private int idColonia;

	private String cp;

	private String nombre;

	//uni-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	public Colonia() {
	}

	public int getIdColonia() {
		return this.idColonia;
	}

	public void setIdColonia(int idColonia) {
		this.idColonia = idColonia;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}