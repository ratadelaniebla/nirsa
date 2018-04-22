package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadDetalleMuestreoCocina;


import com.nw.model.CalidadMuestreoCocina;


public class CalidadMuestreoCocinaDAOJpaImpl {

	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public CalidadMuestreoCocinaDAOJpaImpl() {
		emf=null;
		em=null;
		
		
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
		
		
	}
	
	public CalidadMuestreoCocina getCalidadMuestreoCociona(Long idevisceradoproceso ){
		
		CalidadMuestreoCocina cdmc = new CalidadMuestreoCocina();
		 try {
			 
		 
		Query query = em.createQuery("select cdmc from CalidadMuestreoCocina cdmc " +
				"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
		
		query.setParameter("parametro", idevisceradoproceso);
		cdmc = (CalidadMuestreoCocina) query.getSingleResult();
		
		return cdmc;
	} catch (Exception e) {
	 
		return null;
	}
	}
	

	public void  guardarCalidadDetalleCocinas(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(calidadDetalleMuestreoCocina);
				
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

//	public CalidadDetalleMuestreoCocina guardarCalidadDetalleCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina){
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction t = em.getTransaction();
//		
//		CalidadDetalleMuestreoCocina calidadCabeceraMuestreoDevuelto = new CalidadDetalleMuestreoCocina();
//		
//		try {
//				t.begin();
//				
//				calidadCabeceraMuestreoDevuelto = em.merge(calidadDetalleMuestreoCocina);
//				
//				t.commit();
//		} catch (RuntimeException e) {
//			if (t.isActive()){   
//				t.rollback();
//			}	 
//		}
//		finally {
//			em.close();
//		}
//		 
//		return calidadCabeceraMuestreoDevuelto;
//}
//	
	
	
	public CalidadMuestreoCocina guardarCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		CalidadMuestreoCocina calidadCabeceraMuestreoDevuelto = new CalidadMuestreoCocina();
		
		try {
				t.begin();
				
				calidadCabeceraMuestreoDevuelto = em.merge(calidadMuestreoCocina);
				
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
	 public List<CalidadDetalleMuestreoCocina> getcalidadDetalleMuestraCocinaCochesLote(Long getIdcalidadmuestreococina) {
	 	 
	 	   List<CalidadDetalleMuestreoCocina> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoCocina>();  
	 		//Muestra la lista de todos los idcoches
	 	   
	 	   	//GUIA//
	 		// Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoTempCoccion cdm" +
		 	//			" where cdm.calidadMuestreoTempCoccion.idcalidadmuestreotempcoccion = :id");	

	 	   	//ORIGINA//
	 		Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
	 				" where cdm.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :id");
	 		 
	 	   
	 	   /*
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
		 				" where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id");
		 				
		 			*/	

	 		 
	 		query.setParameter("id", getIdcalidadmuestreococina);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;
	    }
	

		public int getNumMuestraxLote(Long idDesDetPro)
		{
			int rec = 0;
			
			Query query = em.createQuery("select count(cdm.idcalidaddetallemuestreococina) from CalidadDetalleMuestreoCocina cdm " +
/*					"inner join edmtc.evisceradoDetalleProcesoCoche edpc " +*/
					"where cdm.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
					"idevisceradodetalleproceso = :idProceso ");
			query.setParameter("idProceso", idDesDetPro);
			String c = query.getSingleResult().toString();
			rec = Integer.valueOf(c);

			return rec;
		}
	


	
	
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoCocina> getcalidadDetalleMuestraCocinaCochesLote2(Long idproducciondetallelote) {
	 	 
	 /*	   List<CalidadDetalleMuestreoCocina> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoCocina>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
	 				" where cdm.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = :id");	
	 		query.setParameter("id", idproducciondetallelote);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;*/
		 
			return em.createQuery("select cdm from CalidadDetalleMuestreoCocina cdm where cdm.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.idevisceradodetalleproceso = '" + idproducciondetallelote+ "'").getResultList();
		 
	    }

	
	
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoCocina> getcalidadDetalleMustraCocina(Long idcalidadmuestreococina) {
	 	 
	 	   List<CalidadDetalleMuestreoCocina> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoCocina>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
	 				" where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id");	
	 		query.setParameter("id", idcalidadmuestreococina);
	 		listacalidaddetalle = query.getResultList();
	 		
	 		return listacalidaddetalle;
	    }

	
	 @SuppressWarnings("unchecked")
	 public List<CalidadDetalleMuestreoCocina> getcalidadDetalleMuestreoCoche(Long idevisceradodetalleprocesocoche) {
	 	 
	 	   List<CalidadDetalleMuestreoCocina> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoCocina>();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoCocina cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		listacalidadMuestreoCoche = query.getResultList();
	 		
	 		return listacalidadMuestreoCoche;
	    }
	
	 public CalidadDetalleMuestreoCocina getcalidadDetalleMuestreoCocheL(Long idevisceradodetalleprocesocoche, int nummuestralote) {
	 	 
	 	/*   CalidadDetalleMuestreoCocina listacalidadMuestreoCoche = new CalidadDetalleMuestreoCocina();  
	 		//Muestra la lista de todos los idcoches 
	 		 Query query =  em.createQuery(" select cmc from CalidadDetalleMuestreoCocina cmc" +	 				
	 				" where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idevis and cmc.nummuestralote= :muestras");
	 		query.setParameter("idevis", idevisceradodetalleprocesocoche);
	 		query.setParameter("muestras", nummuestralote);
	 		listacalidadMuestreoCoche = (CalidadDetalleMuestreoCocina) query.getSingleResult();
	 		
	 		return listacalidadMuestreoCoche;*/
		 	//EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		//	EntityManager em = emf.createEntityManager();
		 //em=new 
	
		// EntityManagerFactory emf1 = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		//	EntityManager em1 = emf1.createEntityManager();
			Query qry  = em.createQuery("select cmc from CalidadDetalleMuestreoCocina cmc " +
					"where cmc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche ="+ idevisceradodetalleprocesocoche +" and cmc.nummuestralote="+nummuestralote);
			//em.refresh(qry);
			Object obj = qry.getSingleResult();
			em.refresh(obj);
			if (obj == null) {
				return null;
			}
			else {
				return (CalidadDetalleMuestreoCocina) obj;
			}
	 		
	 		
	    }
	
		public CalidadMuestreoCocina getCalidadMuestreoCocionaByID(Long idevisceradoproceso)
		{

			System.out.println("Paranetro :"+idevisceradoproceso.toString());

//			Query query = em.createQuery("select cdmc from CalidadMuestreoCocina cdmc " +
//					"where cdmc.evisceradoProceso.idevisceradoproceso = :parametro ");
			
			
			StringBuffer sb = new StringBuffer();
			sb.append("select cdmc "); 
			sb.append("from CalidadMuestreoCocina cdmc "); 
			sb.append("Where cdmc.evisceradoProceso.idevisceradoproceso = '" + idevisceradoproceso.toString().trim() + "'"); 

			
		/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
			List items =  em.createQuery(sb.toString()).getResultList();
			
			
		    if (items == null || items.isEmpty()) {
		        return null;
		    } else {
		        return  (CalidadMuestreoCocina) items.get(0);
		    }	
						
		}

		 @SuppressWarnings("unchecked")
		 public List<CalidadDetalleMuestreoCocina> getcalidadDetalleMustraByIDCocina(Long idevisceradoproceso) {
		 	 
		 	   List<CalidadDetalleMuestreoCocina> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoCocina>();  
		 		//Muestra la lista de todos los idcoches 
		 	   
		 	   
	/*	 	   
		 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
		 				" where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id");	
		 		query.setParameter("id", idcalidadmuestreococina);
		 		listacalidaddetalle = query.getResultList();
	*/
		 		 Query query =  em.createQuery(" select cdmc from CalidadDetalleMuestreoCocina cdmc" +
			 				" where cdmc.calidadMuestreoCocina.evisceradoProceso.idevisceradoproceso = :id");	
			 		query.setParameter("id", idevisceradoproceso);
			 		listacalidaddetalle = query.getResultList();
		 	   
		 		
		 		return listacalidaddetalle;
		    }	 


			public int getNumMuestraxCocina(Long idDesDetPro)
			{
				int rec = 0;
				
				Query query = em.createQuery("select count(cdmc.idcalidaddetallemuestreococina) from CalidadDetalleMuestreoCocina cdmc " +
						"where cdmc.calidadMuestreoCocina.evisceradoProceso." +
						"idevisceradoproceso = :idProceso ");
				query.setParameter("idProceso", idDesDetPro);
				String c = query.getSingleResult().toString();
				rec = Integer.valueOf(c);

				return rec;
			}
		 
		 
			public CalidadMuestreoCocina getCalidadMuestreoCocionaByidevisceradoproceso(Long idevisceradoproceso)
			{
				System.out.println("idevisceradoproceso es :"+idevisceradoproceso.toString());
				System.out.println("Paranetro :"+idevisceradoproceso.toString());
				
				StringBuffer sb = new StringBuffer();
				
				sb.append("select cdmc "); 
				sb.append("from CalidadMuestreoCocina cdmc "); 
				sb.append("Where cdmc.evisceradoProceso.idevisceradoproceso = '" + idevisceradoproceso.toString().trim() + "'"); 

				
			/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
				List items =  em.createQuery(sb.toString()).getResultList();
				
				
			    if (items == null || items.isEmpty()) {
			        return null;
			    } else {
			        return  (CalidadMuestreoCocina) items.get(0);
			    }	
							
			}
	
			 public List<CalidadDetalleMuestreoCocina> getcalidadDetalleMustraByProcesoyLote(Long idevisceradoproceso, int lote) {
			 	 
			 	   List<CalidadDetalleMuestreoCocina> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoCocina>();  
			 		//Muestra la lista de todos los idcoches 
			 	   
			 	   
		/*	 	   
			 		 Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
			 				" where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id");	
			 		query.setParameter("id", idcalidadmuestreococina);
			 		listacalidaddetalle = query.getResultList();
		*/
			 		 Query query =  em.createQuery(" select cdmc from CalidadDetalleMuestreoCocina cdmc" +
				 				" where cdmc.calidadMuestreoCocina.evisceradoProceso.idevisceradoproceso = :id "+
			 				 " and cdmc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.idlote=:idlote order by cdmc.nummuestralote asc");	
				 		query.setParameter("id", idevisceradoproceso);
				 		query.setParameter("idlote", lote);
				 		
				 		listacalidaddetalle = query.getResultList();
			 	   
			 		
			 		return listacalidaddetalle;
			    }	 		 

			 public List<CalidadDetalleMuestreoCocina> getcalidadDetalleMustraByCoche(Long idevisceradoproceso,Long coche) {
	              
                 List<CalidadDetalleMuestreoCocina> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoCocina>();  
                    //Muestra la lista de todos los idcoches 
                 
                 
/*              
                     Query query =  em.createQuery(" select cdm from CalidadDetalleMuestreoCocina cdm" +
                                 " where cdm.calidadMuestreoCocina.idcalidadmuestreococina = :id"); 
                   query.setParameter("id", idcalidadmuestreococina);
                   listacalidaddetalle = query.getResultList();
*/
                    Query query =  em.createQuery(" select cdmc from CalidadDetalleMuestreoCocina cdmc" +
                                       " where cdmc.calidadMuestreoCocina.evisceradoProceso.idevisceradoproceso = :id "+
                                  " and cdmc.evisceradoDetalleProcesoCoche.codbarra=:idcoche");     
                         query.setParameter("id", idevisceradoproceso);
                         query.setParameter("idcoche", coche);
                         listacalidaddetalle = query.getResultList();
                
                    
                    return listacalidaddetalle;
           }  

			 
			 
}
