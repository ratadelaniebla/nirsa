package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoEstibaCubaDetalleMezcla;
import com.nw.model.dao.BarcoEstibaCubaDetalleMezclaDAO;

@SuppressWarnings("unchecked")
public class BarcoEstibaCubaDetalleMezclaDAOJpaImpl extends BaseDaoJpaImpl implements BarcoEstibaCubaDetalleMezclaDAO {

	private static Log logger = LogFactory.getLog(BarcoEstibaCubaDetalleMezclaDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public BarcoEstibaCubaDetalleMezclaDAOJpaImpl() {

   //    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
//	@Override
//	public BarcoEstibaCubaDetalleMezcla BarcoEstibaCubaDetalleMezclaJpaImpl() {
//		return new BarcoEstibaCubaDetalleMezcla();
//	} 
	
	public BarcoEstibaCubaDetalleMezcla getFindBarcoEstibaCubaDetalleMezclabyId(Integer vid) {
		return em.find(BarcoEstibaCubaDetalleMezcla.class, vid);	
	}	

	
	@Override
	public void saveOrUpdate(BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla) 
	{
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(barcoEstibaCubaDetalleMezcla);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	

	

	
	

	public int delete(BarcoEstibaCubaDetalleMezcla  barcoEstibaCubaDetalleMezcla) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 int r= 0;
		Long id = barcoEstibaCubaDetalleMezcla.getIdbarcoestibacubadetallemezcla();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from BarcoEstibaCubaDetalleMezcla where idbarcoestibacubadetallemezcla = :idbc");
			 query.setParameter("idbc", id);
			 query.executeUpdate();
		 	 t.commit();
		 	 r = 0;
			 
		} catch (RuntimeException e) {   
			if (t.isActive()) {
				t.rollback();
			}
		    
			r = 1;
		} finally {
			em.close();
		}
		return r;
 
}  	
	
}

