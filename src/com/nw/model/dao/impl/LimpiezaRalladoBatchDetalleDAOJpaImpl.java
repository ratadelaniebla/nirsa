package com.nw.model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaRalladoBatchDetalle;
import com.nw.model.dao.LimpiezaRalladoBatchDetalleDAO;


public class LimpiezaRalladoBatchDetalleDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaRalladoBatchDetalleDAO 
{

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaRalladoBatchDetalleDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

	
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoBatchDetalle> PesosLimpiezaRalladoBatchDetallePorCabecera(Long idlrc)
	{	
		try {
			Query query = em.createQuery("select lp from LimpiezaRalladoBatchDetalle lp " +
					"where lp.limpiezaRalladoBatchCabecera.idlimpiezaralladobatchcabecera=:idlrc ");
			 query.setParameter("idlrc", idlrc);			
			return query.getResultList();
		} catch (Exception e) {		
			return null;
		}		
	}	

	

	public LimpiezaRalladoBatchDetalle getLimpiezaRalladoBatchDetalle(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaRalladoBatchDetalle o "); 
		sb.append("Where o.idlimpiezaralladobatchdetalle = '" + id.trim() + "'");
		
		@SuppressWarnings("rawtypes")
		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaRalladoBatchDetalle) items.get(0);
        }		
	} 	

	
	@Override
	public void saveOrUpdate(LimpiezaRalladoBatchDetalle limpiezaRalladoBatchDetalle) 
	{
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(limpiezaRalladoBatchDetalle);
	 			        t.commit();
   		  } finally {
   		    if (t.isActive()) t.rollback();
   		  }
			}finally{
				em.close();
				//emf.close();
			}		
	}	
	
	
	
}
