package com.dgti.pixup.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="artista")
@NamedQueries({
	@NamedQuery(name="Artista.findAll", query="SELECT a FROM Artista a"),
	@NamedQuery(name="Artista.findById", query = "SELECT a FROM Artista a WHERE a.idArtista = :id"),
	@NamedQuery(name="Artista.findByNombre", query = "SELECT a FROM Artista a WHERE a.nombre = :nombre"),
})
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_artista")
	private int idArtista;

	private String nombre;

	public Artista() {
	}

	public int getIdArtista() {
		return this.idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}