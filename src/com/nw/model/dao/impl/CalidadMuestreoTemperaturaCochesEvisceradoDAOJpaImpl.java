package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadDetalleMuestreoTempCochesEviscerado;
import com.nw.model.CalidadMuestreoTempCochesEviscerado;


public class CalidadMuestreoTemperaturaCochesEvisceradoDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public CalidadMuestreoTemperaturaCochesEvisceradoDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	public CalidadMuestreoTempCochesEviscerado getCalidadTempMuestreoCoccion(Long idevisceradoproceso ){
		
		CalidadMuestreoTempCochesEviscerado cdmc = new CalidadMuestreoTempCochesEviscerado();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from CalidadMuestreoTempCochesEviscerado cdmc " +
				"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
		
		query.setParameter("parametro", idevisceradoproceso);
		cdmc = (CalidadMuestreoTempCochesEviscerado) query.getSingleResult();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
	
	
	public void guardarCalidadDetalleTemperaturaCoccion(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCoccion){
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

	
	public CalidadMuestreoTempCochesEviscerado guardarCalidadTemperaturaCoccion(CalidadMuestreoTempCochesEviscerado CalidadMuestreoTempCochesEviscerado){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		CalidadMuestreoTempCochesEviscerado calidadCabeceraMuestreoDevuelto = new CalidadMuestreoTempCochesEviscerado();
		
		try {
				t.begin();
				
				calidadCabeceraMuestreoDevuelto = em.merge(CalidadMuestreoTempCochesEviscerado);
				
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
	 public List<CalidadDetalleMuestreoTempCochesEviscerado> getcalidadDetalleMustraCocina(Long idcalidadmuestreotempcoccion) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCochesEviscerado> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoTempCochesEviscerado>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoTempCochesEviscerado cdm" +
	 				" where cdm.calidadMuestreoTempCochesEviscerado.idcalidadmuestreotempcocheseviscerado = :id");	
	 		query.setParameter("id", idcalidadmuestreotempcoccion);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;
	    }

		public int getNumMuestraxCocina(Long idcalidadmuestreotempcoccion)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(cdm.idcalidaddetallemuestreotempcocheseviscerado) from CalidadDetalleMuestreoTempCochesEviscerado cdm " +
					"where cdm.calidadMuestreoTempCochesEviscerado." +
					"idcalidadmuestreotempcocheseviscerado = :idProceso ");
			query.setParameter("idProceso", idcalidadmuestreotempcoccion);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}

	 
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempCochesEviscerado> getcalidadDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCochesEviscerado> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempCochesEviscerado>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempCochesEviscerado cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoTempCochesEviscerado> getcalidadDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<CalidadDetalleMuestreoTempCochesEviscerado> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoTempCochesEviscerado>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoTempCochesEviscerado cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }	

		public int getNumMuestraxLote(Long idEvisDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(cdmtc.idcalidaddetallemuestreotempcocheseviscerado) from CalidadDetalleMuestreoTempCochesEviscerado cdmtc " +
					"where cdmtc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
					"idevisceradodetalleproceso = :idProceso ");
			query.setParameter("idProceso", idEvisDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}
	 
	 
	 
}
