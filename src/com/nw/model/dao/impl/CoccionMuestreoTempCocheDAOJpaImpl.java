package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CoccionDetalleMuestreoTempCoche;
import com.nw.model.CoccionMuestreoTempCoche;


public class CoccionMuestreoTempCocheDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public CoccionMuestreoTempCocheDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	public CoccionMuestreoTempCoche getCoccionTempMuestreoCoche(Long idevisceradoproceso ){
		
		CoccionMuestreoTempCoche cdmc = new CoccionMuestreoTempCoche();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from CoccionMuestreoTempCoche cdmc " +
				"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
		
		query.setParameter("parametro", idevisceradoproceso);
		cdmc = (CoccionMuestreoTempCoche) query.getSingleResult();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
	
	
	public void guardarCoccionDetalleTempCoche(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoche){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(coccionDetalleMuestreoTempCoche);
				
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

	
	public CoccionMuestreoTempCoche guardarEvisceradoTempCoche(CoccionMuestreoTempCoche coccionMuestreoTempCoches){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		CoccionMuestreoTempCoche coccionCabeceraMuestreoDevuelto = new CoccionMuestreoTempCoche();
		
		try {
				t.begin();
				
				coccionCabeceraMuestreoDevuelto = em.merge(coccionMuestreoTempCoches);
				
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
	 public List<CoccionDetalleMuestreoTempCoche> getcoccionDetalleMustraCoche(Long idcoccionmuestreotempcoche) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCoche> listacocciondetalle = new ArrayList<CoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CoccionDetalleMuestreoTempCoche cdm" +
	 				" where cdm.coccionMuestreoTempCoche.idcoccionmuestreotempcoche = :id");	
	 		query.setParameter("id", idcoccionmuestreotempcoche);
	 		listacocciondetalle = query.getResultList();
	 		
	 		return listacocciondetalle;
	    }

	
	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCoche> getcoccionDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCoche> listacoccionMuestreoCoche = new ArrayList<CoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CoccionDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCoche> getcoccionDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCoche> listacoccionMuestreoCoche = new ArrayList<CoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CoccionDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCoche> getcoccionDetalleMuestreoCocinada(Long idcoc) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCoche> listacoccionMuestreoCoche = new ArrayList<CoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CoccionDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :idevis");
	 		query.setParameter("idevis", idcoc);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }	 
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<CoccionDetalleMuestreoTempCoche> getcoccionDetalleMuestreoCocinadaOrdenadaporLote(Long idcoc) {
	 	 
	 	   List<CoccionDetalleMuestreoTempCoche> listacoccionMuestreoCoche = new ArrayList<CoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CoccionDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :idevis order by cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.idlote asc ");
	 		query.setParameter("idevis", idcoc);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }


public int eliminarCoccionDetalleMuestreoTempCoche(CoccionDetalleMuestreoTempCoche RC) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
	     int r= 0;
	     Long id = RC.getIdcocciondetallemuestreotempcoche();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from CoccionDetalleMuestreoTempCoche where idcocciondetallemuestreotempcoche = :idbc");
			 query.setParameter("idbc", id);
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
	 
	 
	 
}
