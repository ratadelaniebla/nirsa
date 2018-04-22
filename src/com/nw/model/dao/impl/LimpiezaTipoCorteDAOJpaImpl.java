package com.nw.model.dao.impl;

 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.BarcoEstibaCuba;
//import com.nw.model.CamaraCajon;
//import com.nw.model.CamaraCajonUbicacion;
import com.nw.model.LimpiezaDetalleTipoCorte;
//import com.nw.model.dao.CamaraCajonDAO;
import com.nw.model.dao.LimpiezaDetalleTipoCorteDAO;


public class LimpiezaTipoCorteDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaDetalleTipoCorteDAO {
	

	@PersistenceContext
	private EntityManagerFactory emf  ;
	private EntityManager em  ;

	 
	 
	
	public LimpiezaTipoCorteDAOJpaImpl() {
		// emf = Persistence.createEntityManagerFactory("NW");
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}


	
	  @SuppressWarnings("unchecked")
			public List<LimpiezaDetalleTipoCorte> getListaLimpiezaDetalleTipoCorte(Long plimpiezaProceso, int pidlimpiezalinea) 
			{//esta funcion se le agrego algo del estado
				  	 
			  	  List<LimpiezaDetalleTipoCorte> listaLimpiezaDetalleTipoCorte = new ArrayList<LimpiezaDetalleTipoCorte>();  
			  	  	  	  
			  		try {
			  			
						Query query =  em.createQuery(" select ldtc from LimpiezaDetalleTipoCorte ldtc " +
						" where ldtc.limpiezaProceso.idlimpiezaproceso = :plimpiezaProceso " +
						" and ldtc.limpiezaLinea.idlimpiezalinea = :pidlimpiezalinea");
						
						query.setParameter("plimpiezaProceso", plimpiezaProceso);
						query.setParameter("pidlimpiezalinea", pidlimpiezalinea);
			  			
						listaLimpiezaDetalleTipoCorte = query.getResultList();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  		
			  		return listaLimpiezaDetalleTipoCorte;
			}	
	
	
		public LimpiezaDetalleTipoCorte getLimpiezaDetalleTipoCorte(Long plimpiezaProceso, int pidlimpiezalinea, int pidlimpiezatipocorte) 
		{ 
			
			StringBuffer sb = new StringBuffer();
			sb.append(" select ldtc from LimpiezaDetalleTipoCorte ldtc " );
			sb.append(" where ldtc.limpiezaProceso.idlimpiezaproceso = '" + String.valueOf(plimpiezaProceso) +"' ");
			sb.append(" and ldtc.limpiezaLinea.idlimpiezalinea = '" + String.valueOf(pidlimpiezalinea)+"' ");
			sb.append(" and ldtc.limpiezaTipoCorte.idlimpiezatipocorte = '" + String.valueOf(pidlimpiezatipocorte)+"' ");
			
			//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

			List items =  em.createQuery(sb.toString()).getResultList();

	        if (items == null || items.isEmpty()) 
	        {
	           return null;
	        } 
	        else 
	        {
	           return  (LimpiezaDetalleTipoCorte) items.get(0);
	        }
	        
		}	  
	
		
		
		public int delete(Long plimpiezaProceso, int pidlimpiezalinea, int pidlimpiezatipocorte) {
			EntityManagerFactory emf = JPAPersistenceManager.getInstance()
					.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			 int r= 0;
			//Long id = barcoEstibaCuba.getIdbarcoestibacuba();
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				 Query query = em.createQuery("Delete from LimpiezaDetalleTipoCorte ldtc " +
				 		"where ldtc.limpiezaProceso.idlimpiezaproceso = :plimpiezaProceso " +
				 		" and ldtc.limpiezaLinea.idlimpiezalinea = :pidlimpiezalinea " +
				 		" and ldtc.limpiezaTipoCorte.idlimpiezatipocorte = :pidlimpiezatipocorte");
				 
				 query.setParameter("plimpiezaProceso", plimpiezaProceso);
				 query.setParameter("pidlimpiezalinea", pidlimpiezalinea);
				 query.setParameter("pidlimpiezatipocorte", pidlimpiezatipocorte);
				 
				 
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

	
	
	@Override
	public void saveOrUpdate(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(limpiezaDetalleTipoCorte);
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
