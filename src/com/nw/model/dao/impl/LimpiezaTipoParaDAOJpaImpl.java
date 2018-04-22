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
//import com.nw.model.CalidadDetallePcc;
//import com.nw.model.CamaraCajon;
//import com.nw.model.CamaraCajonUbicacion;
//import com.nw.model.LimpiezaDetalleTipoCorte;
import com.nw.model.LimpiezaDetalleTipoPara;
import com.nw.model.LimpiezaTipoPara;
//import com.nw.model.dao.CamaraCajonDAO;
//import com.nw.model.dao.LimpiezaDetalleTipoCorteDAO;
import com.nw.model.dao.LimpiezaDetalleTipoParaDAO;


public class LimpiezaTipoParaDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaDetalleTipoParaDAO {
	

	@PersistenceContext
	private EntityManagerFactory emf  ;
	private EntityManager em  ;

	 
	 
	
	public LimpiezaTipoParaDAOJpaImpl() {
		// emf = Persistence.createEntityManagerFactory("NW");
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}


	
	//Eliminamos el Objeto
	public void remove(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					LimpiezaDetalleTipoPara o = (LimpiezaDetalleTipoPara) em.find(LimpiezaDetalleTipoPara.class, limpiezaDetalleTipoPara.getIdlimpiezadetalletipopara());
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
	
	
	
	  @SuppressWarnings("unchecked")
			public List<LimpiezaDetalleTipoPara> getListaLimpiezaDetalleTipoPara(Long plimpiezaProceso, int pidlimpiezalinea) 
			{//esta funcion se le agrego algo del estado
				  	 
			  	  List<LimpiezaDetalleTipoPara> listaLimpiezaDetalleTipoPara = new ArrayList<LimpiezaDetalleTipoPara>();  
			  	  	  	  
			  		try {
			  			
						Query query =  em.createQuery(" select ldtc from LimpiezaDetalleTipoPara ldtc " +
						" where ldtc.limpiezaProceso.idlimpiezaproceso = :plimpiezaProceso " +
						" and ldtc.limpiezaLinea.idlimpiezalinea = :pidlimpiezalinea " +
						"order by ldtc.horainicio, ldtc.horafin ");
						
						query.setParameter("plimpiezaProceso", plimpiezaProceso);
						query.setParameter("pidlimpiezalinea", pidlimpiezalinea);
			  			
						listaLimpiezaDetalleTipoPara = query.getResultList();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  		
			  		return listaLimpiezaDetalleTipoPara;
			}	
	
	  
	  
		public List<LimpiezaTipoPara> getListaLimpiezaTipoParas() 
		{//esta funcion se le agrego algo del estado
			  	 
		  	  List<LimpiezaTipoPara> listaLimpiezaTipoPara = new ArrayList<LimpiezaTipoPara>();  
		  	  	  	  
		  		try {
		  			
					Query query =  em.createQuery(" select ldtc from LimpiezaTipoPara ldtc order by ldtc.descripcion ");
					
					listaLimpiezaTipoPara = query.getResultList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  		
		  		return listaLimpiezaTipoPara;
		}	  
	  
	
		public LimpiezaDetalleTipoPara getLimpiezaDetalleTipoPara(Long plimpiezaProceso, int pidlimpiezalinea, int pidlimpiezatipopara) 
		{ 
			
			StringBuffer sb = new StringBuffer();
			sb.append(" select ldtc from LimpiezaDetalleTipoPara ldtc " );
			sb.append(" where ldtc.limpiezaProceso.idlimpiezaproceso = '" + String.valueOf(plimpiezaProceso) +"' ");
			sb.append(" and ldtc.limpiezaLinea.idlimpiezalinea = '" + String.valueOf(pidlimpiezalinea)+"' ");
			sb.append(" and ldtc.limpiezaTipoPara.idlimpiezatipopara = '" + String.valueOf(pidlimpiezatipopara)+"' ");
			
			//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

			List items =  em.createQuery(sb.toString()).getResultList();

	        if (items == null || items.isEmpty()) 
	        {
	           return null;
	        } 
	        else 
	        {
	           return  (LimpiezaDetalleTipoPara) items.get(0);
	        }
	        
		}	  
	

		
		
		public LimpiezaDetalleTipoPara getLimpiezaDetalleTipoParaByID(Long pidlimpiezadetalletipopara) 
		{ 
			
			StringBuffer sb = new StringBuffer();
			sb.append(" select ldtc from LimpiezaDetalleTipoPara ldtc " );
			sb.append(" where ldtc.idlimpiezadetalletipopara = '" + String.valueOf(pidlimpiezadetalletipopara) +"' ");
			
			//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

			List items =  em.createQuery(sb.toString()).getResultList();

	        if (items == null || items.isEmpty()) 
	        {
	           return null;
	        } 
	        else 
	        {
	           return  (LimpiezaDetalleTipoPara) items.get(0);
	        }
	        
		}	  
		
		
		
		
		
		public int delete(Long plimpiezaProceso, int pidlimpiezalinea) {
			EntityManagerFactory emf = JPAPersistenceManager.getInstance()
					.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			 int r= 0;
			//Long id = barcoEstibaCuba.getIdbarcoestibacuba();
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				 Query query = em.createQuery("Delete from LimpiezaDetalleTipoPara ldtc " +
				 		"where ldtc.limpiezaProceso.idlimpiezaproceso = :plimpiezaProceso " +
				 		" and ldtc.limpiezaLinea.idlimpiezalinea = :pidlimpiezalinea");
				 
				 query.setParameter("plimpiezaProceso", plimpiezaProceso);
				 query.setParameter("pidlimpiezalinea", pidlimpiezalinea);
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
	public void saveOrUpdate(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(limpiezaDetalleTipoPara);
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
