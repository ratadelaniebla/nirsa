package com.wm.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.OrdenFabricacionC;
import com.wm.model.OrdenFabricacionP;
import com.wm.model.dao.OrdenFabricacionPDAO;

public class OrdenFabricacionPJpaImpl extends BaseDaoJpaImpl implements OrdenFabricacionPDAO {

	private static Log logger = LogFactory.getLog(OrdenFabricacionPJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public OrdenFabricacionPJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public OrdenFabricacionP OrdenFabricacionPJpaImpl() {
		return new OrdenFabricacionP();
	} 
 
	@Override
	public List<OrdenFabricacionP> getScrapOrdenProceso(long iOrdenFabricacion,int iidproceso) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionP o "); 
		sb.append("Where o.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("And o.iidproceso = " + iidproceso + " "); 

		logger.info(OrdenFabricacionPJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (List<OrdenFabricacionP>) items;
        }		
	}

	@Override
	public void saveOrUpdate(OrdenFabricacionP ordenfabricacionp) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(ordenfabricacionp);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

	@Override
	 public Number getInfoMaxScrapId() { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select max(o.iidregistrop) "); 
		sb.append("from OrdenFabricacionP o "); 


		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();

           return  countResult;
		
	}

}
