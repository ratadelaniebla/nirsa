package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CoccionDetalleMuestreoTempCocheIngreso;
import com.nw.model.CoccionMuestreoTempCocheIngreso;


public class CoccionMuestreoTempCocheIngresoDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public CoccionMuestreoTempCocheIngresoDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	public CoccionMuestreoTempCocheIngreso getCoccionTempMuestreoCocheIngreso(Long idevisceradoproceso ){
		
		CoccionMuestreoTempCocheIngreso cdmc = new CoccionMuestreoTempCocheIngreso();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from CoccionMuestreoTempCocheIngreso cdmc " +
				"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
		
		query.setParameter("parametro", idevisceradoproceso);
		cdmc = (CoccionMuestreoTempCocheIngreso) query.getSingleResult();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
	
	
	public void guardarCoccionDetalleTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(coccionDetalleMuestreoTempCocheIngreso);
				
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

	
	public CoccionMuestreoTempCocheIngreso guardarEvisceradoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCochesIngreso){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		CoccionMuestreoTempCocheIngreso coccionCabeceraMuestreoDevuelto = new CoccionMuestreoTempCocheIngreso();
		
		try {
				t.begin();
				
				coccionCabeceraMuestreoDevuelto = em.merge(coccionMuestreoTempCochesIngreso);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		 
		return coccionCabeceraMuestreoDevuelto;
}
	
	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCocheIngreso> getcoccionDetalleMustraCocheIngreso(Long idcoccionmuestreotempcocheingreso) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCocheIngreso> listacocciondetalle = new ArrayList<CoccionDetalleMuestreoTempCocheIngreso>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CoccionDetalleMuestreoTempCocheIngreso cdm" +
	 				" where cdm.coccionMuestreoTempCocheIngreso.idcoccionmuestreotempcocheingreso = :id");	
	 		query.setParameter("id", idcoccionmuestreotempcocheingreso);
	 		listacocciondetalle = query.getResultList();
	 		
	 		return listacocciondetalle;
	    }

	
	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCocheIngreso> getcoccionDetalleMuestreoCocheIngreso(Long idevisceradodetalleprocesococheingreso) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCocheIngreso> listacoccionMuestreoCoche = new ArrayList<CoccionDetalleMuestreoTempCocheIngreso>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CoccionDetalleMuestreoTempCocheIngreso cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesococheingreso);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCocheIngreso> getcoccionDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCocheIngreso> listacoccionMuestreoCoche = new ArrayList<CoccionDetalleMuestreoTempCocheIngreso>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CoccionDetalleMuestreoTempCocheIngreso cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCocheIngreso> getcoccionDetalleMuestreoCocinada(Long idcoc) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCocheIngreso> listacoccionMuestreoCoche = new ArrayList<CoccionDetalleMuestreoTempCocheIngreso>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CoccionDetalleMuestreoTempCocheIngreso cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :idevis");
	 		query.setParameter("idevis", idcoc);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }	 
}
