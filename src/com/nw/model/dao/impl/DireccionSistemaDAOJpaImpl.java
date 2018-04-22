package com.nw.model.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DireccionSistema;


public class DireccionSistemaDAOJpaImpl extends BaseDaoJpaImpl {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public DireccionSistemaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public DireccionSistema getFindDireccionSistemabyId(Integer vid) {
		return em.find(DireccionSistema.class, vid);	
	}	    

public DireccionSistema getDireccionEvolutionActiva()
{
	
	DireccionSistema balanza;
try {
	Query query = em.createQuery("select cdp From DireccionSistema cdp " +
			"where cdp.estado =1");
	
	balanza = (DireccionSistema) query.getSingleResult(); 
	return balanza;
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	return null;
	
}



}
	
   
	public void saveOrUpdate(DireccionSistema balanza) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(balanza);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

	


	
}
