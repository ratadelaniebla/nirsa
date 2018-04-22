package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.CalidadRespuestaPreguntaBpmdesembarco;
import com.nw.model.ContraloriaCoccionDetalleMuestreoTempCoche;
import com.nw.model.CoccionMuestreoTempCoche;


public class ContraloriaCoccionMuestreoTempCocheDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public ContraloriaCoccionMuestreoTempCocheDAOJpaImpl() {
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
@SuppressWarnings("unchecked")
public List <ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleTempMuestreoCoche(Long idevisceradodetalleprocesocoche ){
		
	List <ContraloriaCoccionDetalleMuestreoTempCoche> cdmc =new ArrayList <ContraloriaCoccionDetalleMuestreoTempCoche>();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from ContraloriaCoccionDetalleMuestreoTempCoche cdmc " +
				"where cdmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :parametro  and cdmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle is not null "+
				" and cdmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.fechafincocinada is not null  ");
		
		query.setParameter("parametro", idevisceradodetalleprocesocoche);
		cdmc = (List<ContraloriaCoccionDetalleMuestreoTempCoche>) query.getResultList();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}

@SuppressWarnings("unchecked")
public List <ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleTempMuestreoCocheandNivel(Long idevisceradodetalleprocesocoche, Integer nivel){
		
	List <ContraloriaCoccionDetalleMuestreoTempCoche> cdmc =new ArrayList <ContraloriaCoccionDetalleMuestreoTempCoche>();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from ContraloriaCoccionDetalleMuestreoTempCoche cdmc " +
				"where cdmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :parametro  and cdmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle is not null "+
				" and cdmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.fechafincocinada is not null   and cdmc.nivel=:parametro2");
		
		query.setParameter("parametro", idevisceradodetalleprocesocoche);
		query.setParameter("parametro2", nivel);
		cdmc = (List<ContraloriaCoccionDetalleMuestreoTempCoche>) query.getResultList();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
//Eliminamos el Objeto
public int remove(ContraloriaCoccionDetalleMuestreoTempCoche RC) {
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
     int r= 0;
     Long id = RC.getIdcontraloriacocciondetallemuestreotempcoche();
	EntityTransaction t = em.getTransaction();
	try {
		t.begin();
		 Query query = em.createQuery("Delete from ContraloriaCoccionDetalleMuestreoTempCoche where idcontraloriacocciondetallemuestreotempcoche = :idbc");
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
	public void guardarContraloriaCoccionDetalleTempCoche(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoche){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(contraloriaCoccionDetalleMuestreoTempCoche);
				
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
	 public List<ContraloriaCoccionDetalleMuestreoTempCoche> getcoccionDetalleMustraCoche(Long idcoccionmuestreotempcoche) {
	 	 
	 	   List<ContraloriaCoccionDetalleMuestreoTempCoche> listacocciondetalle = new ArrayList<ContraloriaCoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from ContraloriaCoccionDetalleMuestreoTempCoche cdm" +
	 				" where cdm.coccionMuestreoTempCoche.idcoccionmuestreotempcoche = :id");	
	 		query.setParameter("id", idcoccionmuestreotempcoche);
	 		listacocciondetalle = query.getResultList();
	 		
	 		return listacocciondetalle;
	    }

	
	 @SuppressWarnings("unchecked")
	 public List<ContraloriaCoccionDetalleMuestreoTempCoche> getcoccionDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<ContraloriaCoccionDetalleMuestreoTempCoche> listacoccionMuestreoCoche = new ArrayList<ContraloriaCoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from ContraloriaCoccionDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<ContraloriaCoccionDetalleMuestreoTempCoche> getcoccionDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<ContraloriaCoccionDetalleMuestreoTempCoche> listacoccionMuestreoCoche = new ArrayList<ContraloriaCoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from ContraloriaCoccionDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<ContraloriaCoccionDetalleMuestreoTempCoche> getcoccionDetalleMuestreoCocinada(Long idcoc) {
	 	 
	 	   List<ContraloriaCoccionDetalleMuestreoTempCoche> listacoccionMuestreoCoche = new ArrayList<ContraloriaCoccionDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from ContraloriaCoccionDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :idevis");
	 		query.setParameter("idevis", idcoc);
	 		listacoccionMuestreoCoche = query.getResultList();
	 		
	 		return listacoccionMuestreoCoche;
	    }	 
}
