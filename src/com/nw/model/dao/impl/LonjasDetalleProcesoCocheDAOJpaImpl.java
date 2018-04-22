package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasDetalleProcesoCoche;

public class LonjasDetalleProcesoCocheDAOJpaImpl {

	public LonjasDetalleProcesoCocheDAOJpaImpl() {
	}
	
	public LonjasDetalleProcesoCoche saveOrUpdate(LonjasDetalleProcesoCoche LonjasDetalleProcesoCoche) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction    t    = em.getTransaction();
		LonjasDetalleProcesoCoche LonjasDetalleProcesoCocheDevuelto = null;
		try {
			t.begin();
			LonjasDetalleProcesoCocheDevuelto = em.merge(LonjasDetalleProcesoCoche);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return LonjasDetalleProcesoCocheDevuelto;
	}
	
}
