package com.dgti.ws.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.dgti.pixup.dao.ArtistaDAO;
import com.dgti.pixup.dao.impl.ArtistaDAOImpl;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Artista;


@Path(value="/artistas")
public class ListaArtistas {

	private ArtistaDAO dao;
	
	@Path(value="/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Artista> artistas(){
		dao = new ArtistaDAOImpl(Artista.class);
		try{
			return dao.findAll();
		}catch(PixupDAOException e){
			e.printStackTrace(System.out);
			return new ArrayList<Artista>();
		}
	}
	
}
