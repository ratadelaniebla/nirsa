package com.wm.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.OrdenFabricacionP;
import com.wm.model.OrdenFabricacionR;
import com.wm.model.dao.OrdenFabricacionRDAO;

public class OrdenFabricacionRJpaImpl extends BaseDaoJpaImpl implements OrdenFabricacionRDAO {

	private static Log logger = LogFactory.getLog(OrdenFabricacionRJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public OrdenFabricacionRJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public OrdenFabricacionR OrdenFabricacionRJpaImpl() {
		return new OrdenFabricacionR();
	} 

	@Override
	public List<OrdenFabricacionR> getRecursosOrdenProceso(long iOrdenFabricacion,int iidproceso) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionR o "); 
		sb.append("Where o.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("And o.iidproceso = " + iidproceso + " "); 

		logger.info(OrdenFabricacionRJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (List<OrdenFabricacionR>) items;
        }		
	}

	@Override
	public void saveOrUpdate(OrdenFabricacionR ordenfabricacionr) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(ordenfabricacionr);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

}
