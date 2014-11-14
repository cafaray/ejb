package com.dgti.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.dgti.pixup.dao.ArtistaDAO;
import com.dgti.pixup.dao.impl.ArtistaDAOImpl;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Artista;

@WebService(serviceName="RegistraArtista")
@Stateless
public class RegsitraArtista {

    private ArtistaDAO dao;
    
	public RegsitraArtista() {}
    
	@WebMethod()
    public int registraArtista(String nombre){
		dao = new ArtistaDAOImpl(Artista.class);
    	try{    		
        	Artista artista = new Artista();
        	artista.setNombre(nombre);
    		artista = dao.save(artista);
    		return artista.getIdArtista();
    	}catch(PixupDAOException e){
    		return -1;
    	}
    }

}
