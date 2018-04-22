package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.DescongeladoProceso;
import com.nw.model.dao.DescongeladoProcesoDAO;

public class DescongeladoProcesoDAOJpaImpl extends BaseDaoJpaImpl implements DescongeladoProcesoDAO {

	

	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public DescongeladoProcesoDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	
	public DescongeladoProceso guardarDescongeladoProceso(DescongeladoProceso descongeladoProceso)
	{
		DescongeladoProceso dp = new DescongeladoProceso();
		Long i;
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
		
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(descongeladoProceso);//merge
				 //obtengo y asigno el ultimo id ingresado en la tabla camara_cajon 
				//y lo devuelvo asignado en un objeto del tipo CamaraCajon para q se pueda utilizar 
				// en el otro metodo  "guardarCamaraCajonUbicacion" de la clase CamaraCajonUbicacionDAOJpaImpl
				Query qry = em.createQuery("SELECT MAX(dp.iddescongeladoproceso) FROM DescongeladoProceso dp");
			    Object valorMaximoObjeto = qry.getSingleResult();
				i = (Long.valueOf((Long) valorMaximoObjeto));
				dp.setIddescongeladoproceso(i);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		return dp;
		
		
//		
//		Query query = em.createQuery("select dp.iddescongeladoproceso from DescongeladoProceso dp " +
//				"where dp.idproduccion = :idpro");
//		//query.setParameter("idpro", idproduccion);
//		
//		Object obj = query.getSingleResult();
//		
//		System.out.println("El valor de idproduccion: " + obj);
//		
//		return 0;
	}
	

	
	public DescongeladoProceso DescongeladoProcesoIdProduccion(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From DescongeladoProceso o "); 
		sb.append("Where o.produccion.idproduccion = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (DescongeladoProceso) items.get(0);
	    }		
	}
	

	@Override
	public void saveOrUpdate(DescongeladoProceso descongeladoProceso) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(descongeladoProceso);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	
	public void remove(Long vid) {
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					DescongeladoDetalleProceso o = (DescongeladoDetalleProceso) em.find(DescongeladoDetalleProceso.class, vid);
					if (o != null){
						em.remove(o);
						t.commit();
					}
		   	 } finally {
		   		 if (t.isActive()) t.rollback();
		   	 }
		}finally{
			em.close();
		}
	}	
	
	
	
}
