package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaRalladoMezclaBatchCabecera;
import com.nw.model.dao.LimpiezaRalladoMezclaBatchCabeceraDAO;


public class LimpiezaRalladoMezclaBatchCabeceraDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaRalladoMezclaBatchCabeceraDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public LimpiezaRalladoMezclaBatchCabeceraDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}


	@Override
	public LimpiezaRalladoMezclaBatchCabecera saveOrUpdate(
			LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		LimpiezaRalladoMezclaBatchCabecera edpc = new LimpiezaRalladoMezclaBatchCabecera();
		
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				 edpc = em.merge(limpiezaRalladoMezclaBatchCabecera);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		
		return edpc;
	}




}
