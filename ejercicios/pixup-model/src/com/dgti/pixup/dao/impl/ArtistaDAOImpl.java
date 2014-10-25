package com.dgti.pixup.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dgti.pixup.dao.ArtistaDAO;
import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Artista;

public class ArtistaDAOImpl extends GenericDAOImpl<Artista, String> implements ArtistaDAO{
    
    EntityManager em;
    
    public ArtistaDAOImpl(Class<Artista> clase) {
        super(clase);
    }

    @Override
    public Artista findById(String id) throws PixupDAOException {
        try{
            em = factory.createEntityManager();
            TypedQuery<Artista> query = em.createNamedQuery("Artista.findById", Artista.class);
            query.setParameter("id", id);
            List<Artista> artistas = query.getResultList();
            if(artistas.size()>0){
                return artistas.get(0);
            } else {
                throw new PixupDAOException("No se encontraron resultados coicidentes con "+id);
            }
        }catch(PersistenceException e){
            throw new PixupDAOException(e);
        } finally {
            if (em.isOpen()){
                em.close();
            }
        }
    }
    
    @Override
    public Artista buscarPorNombre(String nombre) throws PixupDAOException {
        try{
            em = factory.createEntityManager();
            TypedQuery<Artista> query = em.createNamedQuery("Artista.findByNombre", Artista.class);
            query.setParameter("nombre", nombre);
            List<Artista> artistas = query.getResultList();
            if(artistas.size()>0){
                return artistas.get(0);
            } else {
                throw new PixupDAOException("No se encontraron resultados coicidentes con "+nombre);
            }
        }catch(PersistenceException e){
            throw new PixupDAOException(e);
        } finally {
            if (em.isOpen()){
                em.close();
            }
        }
    }

}
