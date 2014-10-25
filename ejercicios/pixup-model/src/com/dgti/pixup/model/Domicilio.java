package com.dgti.pixup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the domicilio database table.
 * 
 */
@Entity
@Table(name="domicilio")
@NamedQuery(name="Domicilio.findAll", query="SELECT d FROM Domicilio d")
public class Domicilio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_domicilio")
	private int idDomicilio;

	private String calle;

	@Column(name="num_ext")
	private String numExt;

	@Column(name="num_int")
	private String numInt;

	//uni-directional many-to-one association to Colonia
	@ManyToOne
	@JoinColumn(name="id_colonia")
	private Colonia colonia;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario1;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario2;

	public Domicilio() {
	}

	public int getIdDomicilio() {
		return this.idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumExt() {
		return this.numExt;
	}

	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}

	public String getNumInt() {
		return this.numInt;
	}

	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}

	public Colonia getColonia() {
		return this.colonia;
	}

	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}