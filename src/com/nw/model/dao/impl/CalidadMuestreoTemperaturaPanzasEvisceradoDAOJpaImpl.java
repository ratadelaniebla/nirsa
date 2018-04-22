package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;

import com.nw.model.CalidadDetalleMuestreoTempPanzaEviscerado;
import com.nw.model.CalidadMuestreoTempPanzasEviscerado;
import com.nw.model.EvisceradoDetalleProceso;
import com.nw.util.Sistema;


public class CalidadMuestreoTemperaturaPanzasEvisceradoDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public CalidadMuestreoTemperaturaPanzasEvisceradoDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	public CalidadMuestreoTempPanzasEviscerado getCalidadTempMuestreoCoccion(Long idevisceradoproceso ){
		
		CalidadMuestreoTempPanzasEviscerado cdmc = new CalidadMuestreoTempPanzasEviscerado();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from CalidadMuestreoTempPanzasEviscerado cdmc " +
				"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
		
		query.setParameter("parametro", idevisceradoproceso);
		cdmc = (CalidadMuestreoTempPanzasEviscerado) query.getSingleResult();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
	
	
	public void guardarCalidadDetalleTemperaturaCoccion(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempCoccion){
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
	public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesosByEvisceradoProceso(Long idevisceradoproceso) {		

		
		//Sistema.mensaje("Enrtro al metodo");
			List<EvisceradoDetalleProceso> edp = new ArrayList<EvisceradoDetalleProceso>();

	    	//List evisceradosDetallesProcesos;
			try {
			Query q1 = em.createQuery("Select edp from EvisceradoDetalleProceso edp " +
						"where edp.evisceradoProceso.idevisceradoproceso =:proceso" +
						" order by edp.produccionDetalleLoteCajon.produccionDetalleLote.idlote asc "); 
						q1.setParameter("proceso", idevisceradoproceso);
			
						 edp  = q1.getResultList();
			
		  
		    
		    	} catch (Exception e) {
					Sistema.mensaje("Error en el proceso --> " + e.getMessage());
					return null;		
				}
	    	return  edp ; 
	    	
	    	
	   }
	
	public CalidadMuestreoTempPanzasEviscerado guardarCalidadTemperaturaCoccion(CalidadMuestreoTempPanzasEviscerado CalidadMuestreoTempPanzasEviscerado){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		CalidadMuestreoTempPanzasEviscerado calidadCabeceraMuestreoDevuelto = new CalidadMuestreoTempPanzasEviscerado();
		
		try {
				t.begin();
				
				calidadCabeceraMuestreoDevuelto = em.merge(CalidadMuestreoTempPanzasEviscerado);
				
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
	 public List<CalidadDetalleMuestreoTempPanzaEviscerado> getcalidadDetalleMustraCocina(Long idcalidadmuestreotempcoccion) {
	 	 
	 	   List<CalidadDetalleMuestreoTempPanzaEviscerado> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoTempPanzaEviscerado>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoTempPanzaEviscerado cdm" +
	 				" where cdm.calidadMuestreoTempPanzasEviscerado.idcalidadmuestreotemppanzaseviscerado = :id");	
	 		query.setParameter("id", idcalidadmuestreotempcoccion);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;
	    }

	
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempPanzaEviscerado> getcalidadDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<CalidadDetalleMuestreoTempPanzaEviscerado> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempPanzaEviscerado>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempPanzaEviscerado cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempPanzaEviscerado> getcalidadDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<CalidadDetalleMuestreoTempPanzaEviscerado> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempPanzaEviscerado>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempPanzaEviscerado cmc" +	 				
	 				" where cmc.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	
	 
	 
}
