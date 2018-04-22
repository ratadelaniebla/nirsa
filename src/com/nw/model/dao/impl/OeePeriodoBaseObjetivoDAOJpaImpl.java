package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.OeePeriodoBaseObjetivo;
import com.nw.model.dao.OeePeriodoBaseObjetivoDAO;

/**
 * Clase para manejar los procesos
 * 
 * @author Manexware S.A.
 * 
 */
public class OeePeriodoBaseObjetivoDAOJpaImpl extends BaseDaoJpaImpl implements
		OeePeriodoBaseObjetivoDAO {

	public OeePeriodoBaseObjetivoDAOJpaImpl() {
	}

	@Override
	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivoById(Integer id) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager(); 
	    OeePeriodoBaseObjetivo oee = new OeePeriodoBaseObjetivo();
	    try {
	    	 oee = em.find(OeePeriodoBaseObjetivo.class, id);
	    }
	    catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			em.close();
		}
		return oee;
	}

	public void saveOrUpdate(OeePeriodoBaseObjetivo pbo) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager(); 
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(pbo);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivoByIdProceso(
			Integer idproceso) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager(); 
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT opbo ");
			sbuilder.append("FROM OeePeriodoBaseObjetivo opbo ");
			sbuilder.append("WHERE opbo.proceso.idproceso = :idproceso");
			OeePeriodoBaseObjetivo result = (OeePeriodoBaseObjetivo) em
					.createQuery(sbuilder.toString()).//
					setParameter("idproceso", idproceso).getSingleResult();
			return result;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivoByIdProcesoAndEstado(
			int idproceso, boolean estado) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager(); 
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT opbo ");
			sbuilder.append("FROM OeePeriodoBaseObjetivo opbo ");
			sbuilder.append("WHERE opbo.proceso.idproceso = :idproceso ");
			sbuilder.append("AND opbo.estado = :estado");
			OeePeriodoBaseObjetivo result = (OeePeriodoBaseObjetivo) em
					.createQuery(sbuilder.toString())//
					.setParameter("idproceso", idproceso)//
					.setParameter("estado", estado)//
					.getSingleResult();
			return result;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
}
