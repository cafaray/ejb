package com.dgti.pixup.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.dgti.pixup.exception.PixupDAOException;

public interface GenericDAO<T, Id extends Serializable> {

    T save(T objeto) throws PixupDAOException;

    T update(T objeto) throws PixupDAOException;

    void delete(T objeto) throws PixupDAOException;

    boolean contains(T objeto) throws PixupDAOException;

    List<T> findAll() throws PixupDAOException;

    T findById(String id) throws PixupDAOException;
    
    List<T> findByFields(Map<Field, Object> criterios) throws NoSuchFieldException, SecurityException, PixupDAOException;    

}
