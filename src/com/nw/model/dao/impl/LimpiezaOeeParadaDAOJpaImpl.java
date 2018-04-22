package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.OeeParada;
import com.nw.model.dao.OeeParadaDAO;


public class LimpiezaOeeParadaDAOJpaImpl extends BaseDaoJpaImpl implements OeeParadaDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public LimpiezaOeeParadaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	@Override
	public OeeParada getOeeParadaById(Integer id) {
		return em.find(OeeParada.class, id);
	}

	public void saveOrUpdate(OeeParada pbo) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(pbo);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<OeeParada> getOeeParadaByIdProceso(int idproceso) {
		try {
			return (List<OeeParada>) em
					.createQuery(
							"select c from OeeParada c where c.proceso.idproceso = :param order by c.tipoEquipoPersona, c.descripcionParada")
					.setParameter("param", idproceso).getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	
	
	@SuppressWarnings("unchecked")
	public List<OeeParada> getOeeParadaByIdProcesoTipo(int idproceso, boolean estado) {
		try {
			return (List<OeeParada>) em
					.createQuery(
							"select c from OeeParada c where c.proceso.idproceso = :param and c.tipoEquipoPersona = :estado  order by c.tipoEquipoPersona, c.descripcionParada")
					.setParameter("param", idproceso)
					.setParameter("estado", estado)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return null;
		}
	}	
	
	
	public void eliminar(OeeParada parada) {
		em.getTransaction().begin();
		em.remove(parada);
		em.getTransaction().commit();

	}

}
