package com.dgti.pixup.dao;

import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Artista;

public interface ArtistaDAO extends GenericDAO<Artista, String> {
    Artista buscarPorNombre(String nombre)throws PixupDAOException;
}