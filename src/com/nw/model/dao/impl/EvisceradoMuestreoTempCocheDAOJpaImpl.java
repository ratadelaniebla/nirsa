package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoDetalleMuestreoTempCoche;
/*import com.nw.model.CalidadDetalleMuestreoTempCochesEviscerado;
import com.nw.model.CalidadMuestreoTempCochesEviscerado;*/
import com.nw.model.EvisceradoMuestreoTempCoche;


public class EvisceradoMuestreoTempCocheDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public EvisceradoMuestreoTempCocheDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	public EvisceradoMuestreoTempCoche getEvisceradoTempMuestreoCoche(Long idevisceradoproceso ){
		
		EvisceradoMuestreoTempCoche cdmc = new EvisceradoMuestreoTempCoche();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from EvisceradoMuestreoTempCoche cdmc " +
				"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
		
		query.setParameter("parametro", idevisceradoproceso);
		cdmc = (EvisceradoMuestreoTempCoche) query.getSingleResult();
		
		return cdmc;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
	
	
	public void guardarEvisceradoDetalleTempCoche(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoche){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(evisceradoDetalleMuestreoTempCoche);
				
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

	
	public EvisceradoMuestreoTempCoche guardarEvisceradoTempCoche(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoches){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		EvisceradoMuestreoTempCoche evisceradoCabeceraMuestreoDevuelto = new EvisceradoMuestreoTempCoche();
		
		try {
				t.begin();
				
				evisceradoCabeceraMuestreoDevuelto = em.merge(evisceradoMuestreoTempCoches);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		 
		return evisceradoCabeceraMuestreoDevuelto;
}
	
	 @SuppressWarnings("unchecked")
	 public List<EvisceradoDetalleMuestreoTempCoche> getevisceradoDetalleMustraCoche(Long idevisceradomuestreotempcoche) {
	 	 
	 	   List<EvisceradoDetalleMuestreoTempCoche> listaevisceradodetalle = new ArrayList<EvisceradoDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from EvisceradoDetalleMuestreoTempCoche cdm" +
	 				" where cdm.evisceradoMuestreoTempCoche.idevisceradomuestreotempcoche = :id");	
	 		query.setParameter("id", idevisceradomuestreotempcoche);
	 		listaevisceradodetalle = query.getResultList();
	 		
	 		return listaevisceradodetalle;
	    }


		
		public int getNumMuestraxProduccion(Long idDesDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(edmtc.idevisceradodetallemuestreotempcoche) from EvisceradoDetalleMuestreoTempCoche edmtc " +
/*					"inner join edmtc.evisceradoDetalleProcesoCoche edpc " +*/
					"where edmtc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
					"produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idProduccion ");
			query.setParameter("idProduccion", idDesDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<EvisceradoDetalleMuestreoTempCoche> getevisceradoDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<EvisceradoDetalleMuestreoTempCoche> listaevisceradoMuestreoCoche = new ArrayList<EvisceradoDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from EvisceradoDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listaevisceradoMuestreoCoche = query.getResultList();
	 		
	 		return listaevisceradoMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<EvisceradoDetalleMuestreoTempCoche> getevisceradoDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<EvisceradoDetalleMuestreoTempCoche> listaevisceradoMuestreoCoche = new ArrayList<EvisceradoDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from EvisceradoDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listaevisceradoMuestreoCoche = query.getResultList();
	 		
	 		return listaevisceradoMuestreoCoche;
	    }
	 
		public int getNumMuestraxLote(Long idDesDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(edmtc.idevisceradodetallemuestreotempcoche) from EvisceradoDetalleMuestreoTempCoche edmtc " +
/*					"inner join edmtc.evisceradoDetalleProcesoCoche edpc " +*/
					"where edmtc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
					"idevisceradodetalleproceso = :idProceso ");
			query.setParameter("idProceso", idDesDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}

	 
}
