package com.nw.model.dao.impl;
 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
 
import com.nw.model.OeeDetalleMediosConDefectoLonja;
 
 

public class OeeDetalleMediosConDefectoLonjaDAOJpaImpl extends BaseDaoJpaImpl {

 
	public OeeDetalleMediosConDefectoLonjaDAOJpaImpl() {
	}

	
	 
	public OeeDetalleMediosConDefectoLonja saveOrUpdate(OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonja) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonjaDevuelto = null;
		try {
			t.begin();
			oeeDetalleMediosConDefectoLonjaDevuelto = em.merge(oeeDetalleMediosConDefectoLonja);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return oeeDetalleMediosConDefectoLonjaDevuelto;
	}
	
	 

}
