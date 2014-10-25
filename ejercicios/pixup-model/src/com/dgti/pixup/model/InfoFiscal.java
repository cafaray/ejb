package com.dgti.pixup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the info_fiscal database table.
 * 
 */
@Entity
@Table(name="info_fiscal")
@NamedQuery(name="InfoFiscal.findAll", query="SELECT i FROM InfoFiscal i")
public class InfoFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_info_fiscal")
	private int idInfoFiscal;

	@Column(name="razon_social")
	private String razonSocial;

	private String rfc;

	//uni-directional many-to-one association to Domicilio
	@ManyToOne
	@JoinColumn(name="id_domicilio")
	private Domicilio domicilio;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public InfoFiscal() {
	}

	public int getIdInfoFiscal() {
		return this.idInfoFiscal;
	}

	public void setIdInfoFiscal(int idInfoFiscal) {
		this.idInfoFiscal = idInfoFiscal;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Domicilio getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}