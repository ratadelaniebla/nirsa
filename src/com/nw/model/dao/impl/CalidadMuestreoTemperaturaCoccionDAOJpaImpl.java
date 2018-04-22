package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadDetalleMuestreoTempCoccion;
import com.nw.model.CalidadMuestreoTempCoccion;


public class CalidadMuestreoTemperaturaCoccionDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public CalidadMuestreoTemperaturaCoccionDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	public CalidadMuestreoTempCoccion getCalidadTempMuestreoCoccion(Long idevisceradoproceso ){
		
		CalidadMuestreoTempCoccion cdmc = new CalidadMuestreoTempCoccion();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from CalidadMuestreoTempCoccion cdmc " +
				"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
		
		query.setParameter("parametro", idevisceradoproceso);
		cdmc = (CalidadMuestreoTempCoccion) query.getSingleResult();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
	
	
	public void guardarCalidadDetalleTemperaturaCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(calidadDetalleMuestreoTempCoccion);
				
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

	
	public CalidadMuestreoTempCoccion guardarCalidadTemperaturaCoccion(CalidadMuestreoTempCoccion calidadMuestreoTempCoccion){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		CalidadMuestreoTempCoccion calidadCabeceraMuestreoDevuelto = new CalidadMuestreoTempCoccion();
		
		try {
				t.begin();
				
				calidadCabeceraMuestreoDevuelto = em.merge(calidadMuestreoTempCoccion);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		 
		return calidadCabeceraMuestreoDevuelto;
}
	
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempCoccion> getcalidadDetalleMustraCocina(Long idcalidadmuestreotempcoccion) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCoccion> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoTempCoccion>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoTempCoccion cdm" +
	 				" where cdm.calidadMuestreoTempCoccion.idcalidadmuestreotempcoccion = :id");	
	 		query.setParameter("id", idcalidadmuestreotempcoccion);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;
	    }

		public int getNumMuestraxCocina(Long idDesDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(cdm.idcalidaddetallemuestreotempcoccion) from CalidadDetalleMuestreoTempCoccion cdm " +
					"where cdm.calidadMuestreoTempCoccion." +
					"idcalidadmuestreotempcoccion = :idProceso ");
			query.setParameter("idProceso", idDesDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}
	 
	 
	
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempCoccion> getcalidadDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCoccion> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempCoccion>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempCoccion cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempCoccion> getcalidadDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCoccion> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempCoccion>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempCoccion cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	
	 
		public int getNumMuestraxLote(Long idDesDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(cmc.idcalidaddetallemuestreotempcoccion) from CalidadDetalleMuestreoTempCoccion cmc " +
/*					"inner join edmtc.evisceradoDetalleProcesoCoche edpc " +*/
					"where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
					"idevisceradodetalleproceso = :idProceso ");
			query.setParameter("idProceso", idDesDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}

		
	 public CalidadMuestreoTempCoccion getCalidadMuestreoCocionaByidevisceradoproceso(Long idevisceradoproceso)
		{
			System.out.println("idevisceradoproceso es :"+idevisceradoproceso.toString());
			System.out.println("Paranetro :"+idevisceradoproceso.toString());
			
			StringBuffer sb = new StringBuffer();
			
			sb.append("select cdmc "); 
			sb.append("from CalidadMuestreoTempCoccion cdmc "); 
			sb.append("Where cdmc.evisceradoProceso.idevisceradoproceso = '" + idevisceradoproceso.toString().trim() + "'"); 

			
		/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
			List items =  em.createQuery(sb.toString()).getResultList();
			
			
		    if (items == null || items.isEmpty()) {
		        return null;
		    } else {
		        return  (CalidadMuestreoTempCoccion) items.get(0);
		    }	
						
		}	 

	 public CalidadMuestreoTempCoccion getCalidadMuestreoCocionaByID(Long idevisceradoproceso)
		{

			System.out.println("Paranetro :"+idevisceradoproceso.toString());

//			Query query = em.createQuery("select cdmc from CalidadMuestreoCocina cdmc " +
//					"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
			
			
			StringBuffer sb = new StringBuffer();
			sb.append("select cdmc "); 
			sb.append("from CalidadMuestreoTempCoccion cdmc "); 
			sb.append("Where cdmc.evisceradoProceso.idevisceradoproceso = '" + idevisceradoproceso.toString().trim() + "'  "); 

			
		/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
			List items =  em.createQuery(sb.toString()).getResultList();
			
			
		    if (items == null || items.isEmpty()) {
		        return null;
		    } else {
		        return  (CalidadMuestreoTempCoccion) items.get(0);
		    }	
						
		}	 

	 public List<CalidadDetalleMuestreoTempCoccion> getcalidadDetalleMustraByProcesoyLote(Long idevisceradoproceso, int lote) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCoccion> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoTempCoccion>();  
	 		//Muestra la lista de todos los idcoches 
	 	   
	 	   
/*	 	   
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
	 				" where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id");	
	 		query.setParameter("id", idcalidadmuestreococina);
	 		listacalidaddetalle = query.getResultList();
*/
	 		 Query query =  em.createQuery(" select cdmc from CalidadDetalleMuestreoTempCoccion cdmc" +
		 				" where cdmc.calidadMuestreoTempCoccion.evisceradoProceso.idevisceradoproceso = :id "+
	 				 " and cdmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.idlote=:idlote order by cdmc.nummuestralote asc");	
		 		query.setParameter("id", idevisceradoproceso);
		 		query.setParameter("idlote", lote);
		 		
		 		listacalidaddetalle = query.getResultList();
	 	   
	 		
	 		return listacalidaddetalle;
	    }	 
	 
	 public List<CalidadDetalleMuestreoTempCoccion> getcalidadDetalleMuestraCocinaCochesLote(Long getIdcalidadmuestreococina) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCoccion> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoTempCoccion>();  
	 		//Muestra la lista de todos los idcoches
	 	   
	 	   	//GUIA//
	 		// Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoTempCoccion cdm" +
		 	//			" where cdm.calidadMuestreoTempCoccion.idcalidadmuestreotempcoccion = :id");	

	 	   	//ORIGINA//
	 		Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoTempCoccion cdm" +
	 				" where cdm.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :id");
	 		 
	 	   
	 	   /*
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
		 				" where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id");
		 				
		 			*/	

	 		 
	 		query.setParameter("id", getIdcalidadmuestreococina);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;
	    }

	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempCoccion> getcalidadDetalleMustraByIDCocina(Long idevisceradoproceso) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCoccion> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoTempCoccion>();  
	 		//Muestra la lista de todos los idcoches 
	 	   
	 	   
/*	 	   
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
	 				" where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id");	
	 		query.setParameter("id", idcalidadmuestreococina);
	 		listacalidaddetalle = query.getResultList();
*/
	 		 Query query =  em.createQuery(" select cdmc from CalidadDetalleMuestreoTempCoccion cdmc" +
		 				" where cdmc.calidadMuestreoTempCoccion.evisceradoProceso.idevisceradoproceso = :id");	
		 		query.setParameter("id", idevisceradoproceso);
		 		listacalidaddetalle = query.getResultList();
	 	   
	 		
	 		return listacalidaddetalle;
	    }
	 
}
