package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasDetalleProcesoConteo;

public class LonjasDetalleProcesoConteoDAOJpaImpl extends BaseDaoJpaImpl {

	public LonjasDetalleProcesoConteoDAOJpaImpl() {
	}
	
	public LonjasDetalleProcesoConteo saveOrUpdate(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		LonjasDetalleProcesoConteo lonjasDetalleProcesoConteoDevuelto = null;
		try {
			t.begin();
			lonjasDetalleProcesoConteoDevuelto = em.merge(lonjasDetalleProcesoConteo);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return lonjasDetalleProcesoConteoDevuelto;
	}
	
	
}
