package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CoccionProceso;
import com.nw.model.dao.CoccionProcesoDAO;

public class CoccionProcesoDAOJpaImpl extends BaseDaoJpaImpl implements CoccionProcesoDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CoccionProcesoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	@Override
	public void saveOrUpdate(CoccionProceso coccionProceso) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(coccionProceso);
				
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

	
	//
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
	
	
	
//	@Override
//	public BarcoEstibaCuba getCoccionProcesoByIdTurno(String id) { 
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("Select o "); 
//		sb.append("From BarcoEstibaCuba o "); 
//		sb.append("Where o.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 
//
//		//logger.info(BarcoEstibaCuba.class +" -> "+sb.toString());
//
//		List items =  em.createQuery(sb.toString()).getResultList();
//
//        if (items == null || items.isEmpty()) {
//            return null;
//        } else {
//            return  (BarcoEstibaCuba) items.get(0);
//        }	
		

}
