package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CantidadLibra;
import com.nw.model.dao.CantidadLibraDAO;

/**
 * Clase para manejar los formatos
 * 
 * @author Manexware S.A.
 * 
 */
public class CantidadLibraDAOJpaImpl extends BaseDaoJpaImpl implements
		CantidadLibraDAO {

	public CantidadLibraDAOJpaImpl() {
	}

	@Override
	public CantidadLibra getCantidadLibraById(Integer id) {
		return em.find(CantidadLibra.class, id);
	}

	/* se modifico este metodo , en si los metodos q devuelven listado o no deben retornar una lista */
	@SuppressWarnings("unchecked")
	public List<CantidadLibra> getFormatos() {
		List<CantidadLibra> resultList = new ArrayList<>();
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT cl ");
		sbuilder.append("FROM CantidadLibra cl order by cl.idcantidadlibras asc");
		 resultList =  em .createQuery(sbuilder.toString()) .getResultList();
	    return resultList;
	}

	public boolean eliminar(CantidadLibra cantidadLibra) {
		EntityTransaction t = em.getTransaction();
		boolean result = true;
		try {
			t.begin();
			em.merge(cantidadLibra);
			em.remove(cantidadLibra);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			result = false;
		} finally {
			em.close();
		}
		return result;
	}

	@Override
	public void saveOrUpdate(CantidadLibra cantidadLibra) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(cantidadLibra);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	public void saveOrUpdateNativo(CantidadLibra cantidadLibra){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			Query query = em.createNativeQuery(" INSERT INTO  cantidad_libras( idcantidadlibras, " +
					" descripcion, peso_gramos)  VALUES (?, ?, ?);");
		        query.setParameter(1, cantidadLibra.getIdcantidadlibras());
		        query.setParameter(2, cantidadLibra.getDescripcion());
		        query.setParameter(3, cantidadLibra.getPesoGramos());
		        query.executeUpdate();
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
    }

	public boolean delete(CantidadLibra cantidadLibra) {
		EntityTransaction t = em.getTransaction();
		boolean result = true;
		try {
			t.begin();
			CantidadLibra cl = em.find(CantidadLibra.class,
					cantidadLibra.getIdcantidadlibras());
			em.remove(cl);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			result = false;
		} finally {
			em.close();
		}
		return result;
	}
}
