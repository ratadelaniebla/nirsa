package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.ContraloriaCoccionDetalleMuestreoTempCoche;
import com.nw.model.ContraloriaEvisceradoDetalleMuestreoTempCoche;
//import com.nw.model.EvisceradoDetalleMuestreoTempCoche;
/*import com.nw.model.CalidadDetalleMuestreoTempCochesEviscerado;
import com.nw.model.CalidadMuestreoTempCochesEviscerado;*/
import com.nw.model.EvisceradoMuestreoTempCoche;


public class ContraloriaEvisceradoMuestreoTempCocheDAOJpaImpl {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public ContraloriaEvisceradoMuestreoTempCocheDAOJpaImpl() {
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
	
	
	public void guardarContraloriaEvisceradoDetalleTempCoche(ContraloriaEvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoche){
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
	public int remove(ContraloriaEvisceradoDetalleMuestreoTempCoche RC) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
	     int r= 0;
	     Long id = RC.getIdcontraloriaevisceradodetallemuestreotempcoche();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from ContraloriaEvisceradoDetalleMuestreoTempCoche where idcontraloriaevisceradodetallemuestreotempcoche = :idbc");
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
	 @SuppressWarnings("unchecked")
	 public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getevisceradoDetalleMustraCoche(Long idevisceradomuestreotempcoche) {
	 	 
	 	   List<ContraloriaEvisceradoDetalleMuestreoTempCoche> listaevisceradodetalle = new ArrayList<ContraloriaEvisceradoDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from ContraloriaEvisceradoDetalleMuestreoTempCoche cdm" +
	 				" where cdm.evisceradoMuestreoTempCoche.idevisceradomuestreotempcoche = :id");	
	 		query.setParameter("id", idevisceradomuestreotempcoche);
	 		listaevisceradodetalle = query.getResultList();
	 		
	 		return listaevisceradodetalle;
	    }


		
		public int getNumMuestraxProduccion(Long idDesDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(edmtc.idcontraloriaevisceradodetallemuestreotempcoche) from ContraloriaEvisceradoDetalleMuestreoTempCoche edmtc " +
/*					"inner join edmtc.evisceradoDetalleProcesoCoche edpc " +*/
					"where edmtc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
					"produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idProduccion ");
			query.setParameter("idProduccion", idDesDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}
		public int getNumMuestraxEDPC(Long idedpc)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(edmtc.idcontraloriaevisceradodetallemuestreotempcoche) from ContraloriaEvisceradoDetalleMuestreoTempCoche edmtc " +
/*					"inner join edmtc.evisceradoDetalleProcesoCoche edpc " +*/
					"where edmtc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idEDPC ");
			query.setParameter("idEDPC", idedpc);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}
	 
	 @SuppressWarnings("unchecked")
	 public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getevisceradoDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<ContraloriaEvisceradoDetalleMuestreoTempCoche> listaevisceradoMuestreoCoche = new ArrayList<ContraloriaEvisceradoDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from ContraloriaEvisceradoDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listaevisceradoMuestreoCoche = query.getResultList();
	 		
	 		return listaevisceradoMuestreoCoche;
	    }	
	 @SuppressWarnings("unchecked")
	 public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getevisceradoDetalleMuestreoCocheandNivel(Long idevisceradodetalleprocesocoche, Integer nivel) {
	 	 
	 	   List<ContraloriaEvisceradoDetalleMuestreoTempCoche> listaevisceradoMuestreoCoche = new ArrayList<ContraloriaEvisceradoDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from ContraloriaEvisceradoDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis and cmc.nivel=:parametro2" );
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		query.setParameter("parametro2", nivel);
	 		listaevisceradoMuestreoCoche = query.getResultList();
	 		
	 		return listaevisceradoMuestreoCoche;
	    }	

	 @SuppressWarnings("unchecked")
	 public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getevisceradoDetalleMuestreoLote(Long idevisceradodetalleproceso) {
	 	 
	 	   List<ContraloriaEvisceradoDetalleMuestreoTempCoche> listaevisceradoMuestreoCoche = new ArrayList<ContraloriaEvisceradoDetalleMuestreoTempCoche>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from ContraloriaEvisceradoDetalleMuestreoTempCoche cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleproceso);
	 		listaevisceradoMuestreoCoche = query.getResultList();
	 		
	 		return listaevisceradoMuestreoCoche;
	    }
	 
		public int getNumMuestraxLote(Long idDesDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(edmtc.idcontraloriaevisceradodetallemuestreotempcoche) from ContraloriaEvisceradoDetalleMuestreoTempCoche edmtc " +
/*					"inner join edmtc.evisceradoDetalleProcesoCoche edpc " +*/
					"where edmtc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
					"idevisceradodetalleproceso = :idProceso ");
			query.setParameter("idProceso", idDesDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}

	 
}
