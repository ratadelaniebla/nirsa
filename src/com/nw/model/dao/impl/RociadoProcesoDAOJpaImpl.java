package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CoccionProceso;
import com.nw.model.RociadoProceso;
import com.nw.model.dao.RociadoProcesoDAO;

public class RociadoProcesoDAOJpaImpl extends BaseDaoJpaImpl implements RociadoProcesoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public RociadoProcesoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}	
	
	
	@Override
	public void saveOrUpdate(RociadoProceso rociadoProceso) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(rociadoProceso);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
	}

	
	
	public RociadoProceso getRociadoProcesoIdProduccion(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From RociadoProceso o "); 
		sb.append("Where o.produccion.idproduccion = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (RociadoProceso) items.get(0);
	    }		
	}	
	
	public CoccionProceso getCoccionProcesoIdProduccion(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CoccionProceso o "); 
		sb.append("Where o.produccion.idproduccion = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (CoccionProceso) items.get(0);
	    }		
	}	

}
