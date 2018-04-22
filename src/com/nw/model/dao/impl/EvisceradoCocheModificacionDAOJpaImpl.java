package com.nw.model.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoCocheModificacion;
import com.nw.model.dao.EvisceradoCocheModificacionDAO;

public class EvisceradoCocheModificacionDAOJpaImpl extends BaseDaoJpaImpl implements EvisceradoCocheModificacionDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EvisceradoCocheModificacionDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	
	@Override
	public void saveOrUpdate(
			EvisceradoCocheModificacion evisceradoCocheModif) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(evisceradoCocheModif);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		
	}


    
    
}
