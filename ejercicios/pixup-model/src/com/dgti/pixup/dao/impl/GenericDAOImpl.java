package com.dgti.pixup.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dgti.pixup.dao.GenericDAO;
import com.dgti.pixup.exception.PixupDAOException;

public class GenericDAOImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

    private Class<T> klass;
    protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

    public GenericDAOImpl(Class<T> clase) {
        this.klass = clase;
    }

    @Override
    public T save(T objeto) throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(objeto);
            em.getTransaction().commit();
            em.refresh(objeto);
            return objeto;
        } catch (PersistenceException e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error al guardar, causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

    @Override
    public T update(T objeto) throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try {
            T resultado = null;
            resultado = em.merge(objeto);
            em.getTransaction().commit();
            return resultado;
        } catch (PersistenceException e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error al actualizar, causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(T objeto) throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try {
            if (em.find(objeto.getClass(), objeto) != null) {
                System.out.println("=====> Object found, it exists in the unit persistence as " + objeto.toString());
                em.remove(objeto);
            } else {
                System.out.println("=====> The object does not exists in the unit persistence " + objeto.toString());
            }
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error al eliminar, causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

    @Override
    public boolean contains(T objeto) throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        try {
            return em.contains(objeto);
        } catch (PersistenceException e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error al ejecutar contains(), causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findAll() throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT obj FROM ").append(klass.getSimpleName()).append(" obj");
            TypedQuery<T> query = em.createQuery(sql.toString(), klass);
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error en findAll(), causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

    @Override
    public T findById(String id) throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(klass, id);
        } catch (PersistenceException e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error en findById(), causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findByFields(Map<Field, Object> criterios) throws NoSuchFieldException, SecurityException, PixupDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected List<T> executeQuery(String jpql, Object... values) throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, klass);
            int iParametro = 1;
            for (Object object : values) {
                query.setParameter(iParametro++, object);
            }
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error en executeQuery(), causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

    protected int executeNativeQuery(String sql) throws PixupDAOException {
        EntityManager em = factory.createEntityManager();
        try {
            Query query = em.createNativeQuery(sql);
            return query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new PixupDAOException("Ocurrió un error en executeNativeQuery(), causado por: " + e.getCause());
        } finally {
            em.close();
        }
    }

}