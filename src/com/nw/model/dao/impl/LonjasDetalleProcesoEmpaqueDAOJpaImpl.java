package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasDetalleProcesoEmpaque;

public class LonjasDetalleProcesoEmpaqueDAOJpaImpl {

	
	public LonjasDetalleProcesoEmpaqueDAOJpaImpl() {
		 
	}
	
	public LonjasDetalleProcesoEmpaque saveOrUpdate(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction    t    = em.getTransaction();
		LonjasDetalleProcesoEmpaque LonjasDetalleProcesoEmpaqueDevuelto = null;
		try {
			t.begin();
			LonjasDetalleProcesoEmpaqueDevuelto = em.merge(lonjasDetalleProcesoEmpaque);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return LonjasDetalleProcesoEmpaqueDevuelto;
	}
	
	
}
