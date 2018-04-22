package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadDetalleMuestreoTempLimpieza;
import com.nw.model.CalidadMuestreoTempLimpieza;


public class LimpiezaMuestreoTemperaturaLimpiezaDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public LimpiezaMuestreoTemperaturaLimpiezaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	
	
	public void guardarCalidadDetalleTemperaturaCoccion(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempCoccion){
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

	
	public CalidadMuestreoTempLimpieza guardarCalidadTemperaturaCoccion(CalidadMuestreoTempLimpieza LimpiezaMuestreoTempLimpieza){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		CalidadMuestreoTempLimpieza calidadCabeceraMuestreoDevuelto = new CalidadMuestreoTempLimpieza();
		
		try {
				t.begin();
				
				calidadCabeceraMuestreoDevuelto = em.merge(LimpiezaMuestreoTempLimpieza);
				
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
	 public List<CalidadDetalleMuestreoTempLimpieza> getcalidadDetalleMustraCocina(Long idcalidadmuestreotempcoccion) {
	 	 
	 	   List<CalidadDetalleMuestreoTempLimpieza> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoTempLimpieza>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoTempLimpieza cdm" +
	 				" where cdm.calidadMuestreoTempLimpieza.idcalidadmuestreotemplimpieza = :id");	
	 		query.setParameter("id", idcalidadmuestreotempcoccion);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;
	    }

	
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempLimpieza> getcalidadDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<CalidadDetalleMuestreoTempLimpieza> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempLimpieza>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempLimpieza cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempLimpieza> getcalidadDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<CalidadDetalleMuestreoTempLimpieza> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempLimpieza>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempLimpieza cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	
	 
		public CalidadMuestreoTempLimpieza getCalidadTempMuestreoCoccion(Long idevisceradoproceso ){
			
			//CalidadMuestreoTempLimpieza cdmc = new CalidadMuestreoTempLimpieza();
			 try {
				 
			 
			Query query = em.createQuery("select cdmc from CalidadMuestreoTempLimpieza cdmc " +
					"where cdmc.limpiezaProceso.idlimpiezaproceso = :parametro ");
			
			query.setParameter("parametro", idevisceradoproceso);
			Object obj = query.getSingleResult();
			em.refresh(obj);
			if (obj == null) {
				return null;
			}
			else {
				System.out.println("mando parrametrro");
				return (CalidadMuestreoTempLimpieza) query.getResultList().get(0);
			}
			//cdmc = (CalidadMuestreoTempLimpieza) query.getResultList().get(0);
			
			//return cdmc;
		} catch (Exception e) {
			System.out.println(e+"Es aqui");
			return null;
		}
		}
	 
}
