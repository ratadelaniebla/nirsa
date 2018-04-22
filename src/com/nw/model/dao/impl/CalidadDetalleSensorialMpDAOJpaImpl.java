package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoCuba;
import com.nw.model.CalidadDetalleSensorialMp;
import com.nw.model.CalidadSensorialMp;
import com.nw.model.dao.CalidadDetalleSensorialMpDAO;


@SuppressWarnings("unchecked")
public class CalidadDetalleSensorialMpDAOJpaImpl extends BaseDaoJpaImpl implements CalidadDetalleSensorialMpDAO {

	private static Log logger = LogFactory.getLog(CalidadDetalleSensorialMpDAOJpaImpl.class);

	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
	
    public CalidadDetalleSensorialMpDAOJpaImpl() {

    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//    	emf = Persistence.createEntityManagerFactory("NW");
    	em = emf.createEntityManager();
    }
     
	@Override
	public CalidadDetalleSensorialMp CalidadDetalleSensorialMpJpaImpl() {
		return new CalidadDetalleSensorialMp();
	}
	
	
	
	 public Long getMaxSecuencial() 
	 { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select max(o.secuencialmuestra) "); 
		sb.append("from CalidadDetalleSensorialMp o "); 

		//logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		Long countResult=(Long) em.createQuery(sb.toString()).getSingleResult();

         return  countResult;
		
	}	
	
	
	@Override
	public void saveOrUpdate(CalidadDetalleSensorialMp calidaddetallesensorialmp) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(calidaddetallesensorialmp);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	
	
	
	//Eliminamos el Objeto
//	public void remove(CalidadDetalleSensorialMp calidaddetallesensorialmp) {
//		try{
//		   	 EntityTransaction t = em.getTransaction();
//		   	 try {
//					t.begin();
//					CalidadDetalleSensorialMp o = (CalidadDetalleSensorialMp) em.find(CalidadDetalleSensorialMp.class, calidaddetallesensorialmp.getId());
//					if (o != null){
//						em.remove(o);
//						t.commit();
//					}
//		   	 } finally {
//		   		 if (t.isActive()) t.rollback();
//		   	 }
//		}finally{
//			em.close();
//		}
//	}
	
	
	
	
	public void remove(CalidadDetalleSensorialMp calidaddetallesensorialmp) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
         int r= 0;
         Long id = calidaddetallesensorialmp.getSecuencialmuestra();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from CalidadDetalleSensorialMp where secuencialmuestra = :idbc");
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
		//return r;
		 
	}	
	
	
	
	
	
//	public void saveOrUpdate(CalidadDetalleSensorialMp calidaddetallesensorialmp) {
///*
//		try{
//	    	 EntityTransaction t = em.getTransaction();
//	    	  try {
//					t.begin();  
//						em.merge(calidaddetallesensorialmp);
//	 			        t.commit();
//    		  } finally {
//    		    if (t.isActive()) t.rollback();
//    		  }
//			}finally{
//				em.close();
//			}
//*/
//
//		try{
//	    	 EntityTransaction t = em.getTransaction();
//	    	  try {
//					t.begin();  
//						em.merge(calidaddetallesensorialmp);
//	 			        t.commit();
//   		  } finally {
//   		    if (t.isActive()) t.rollback();
//   		  }
//			}finally{
//				em.close();
//				//emf.close();
//			}		
//	}

	
//	try {
//		em.getTransaction().begin();
//		em.persist(o);
//		em.getTransaction().commit();
//	} finally {
//		em.close();
//	}

	
	//@Override
	public CalidadDetalleSensorialMp getCalidadDetallePccpbyId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadDetalleSensorialMp o "); 
		sb.append("Where o.secuencialmuestra = '" + id + "'"); 
		
		logger.info(CalidadDetalleSensorialMp.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadDetalleSensorialMp) items.get(0);
        }		
	}	
	
	
	public Long getMaxIdCalidadSensorialMp(CalidadSensorialMp o)
	{
		CalidadDetalleSensorialMp c = new CalidadDetalleSensorialMp();
		//c.getId().getIdcalidadnumeromuestrasensorialmp()
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Query qry  = em.createQuery("select max(cdsmp.id.idcalidadnumeromuestrasensorialmp) " +
				"from CalidadDetalleSensorialMp cdsmp where cdsmp.id.idcalidadsensorialmp = "+ o.getIdcalidadsensorialmp().toString());
		Object obj = qry.getSingleResult();
		if (obj == null) {
			return (long) 1;
		}
		else {
			return (Long) obj+1;
		}
			
	}	
	
	//@Override
	public CalidadDetalleSensorialMp getCalidadDetalleSensorialbyId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadDetalleSensorialMp o "); 
		sb.append("Where o.secuencialmuestra = '" + id + "'"); 
		
		logger.info(CalidadDetalleSensorialMp.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadDetalleSensorialMp) items.get(0);
        }		
	}

	
	
	@Override
	public int getCalidadDetalleSensorialMpByNumMuestraSensorialMp(
			String valorcalidadSensMp, String campoidcalsensmp) {
		// TODO Auto-generated method stub
		return 0;
	}	
	

	
//	public int getCalidadDetalleSensorialMpByNumMuestraSensorialMp(String valorcalidadSensMp, String campoidcalsensmp) {
///*		return em.createQuery("select cdsm From CalidadDetalleSensorialMp cdsm where cdsm.barcoDescarga.idbarcodescarga = :idBarcoDes order by bec.idbarcoestibacuba")
//				.setParameter("idBarcoDes", Sistema.parseInt(numMuestraSensMp))
//				.getResultList();*/
//
//		//StringBuilder sb = new StringBuilder();
//		
//		StringBuffer sb = new StringBuffer();
//		//sb.append("SELECT a.%s FROM ( "); 
//		//sb.append("  SELECT %s, ROW_NUMBER() OVER (order by %s desc) as row FROM CalidadDetalleSensorialMp b "); 
//		//sb.append("WHERE b.calidadSensorialMp = %s ) a WHERE a.row = 1 ");
//		
//		sb.append("SELECT MAX(C.id.idcalidadnumeromuestrasensorialmp) FROM CalidadDetalleSensorialMp C WHERE C.calidadSensorialMp=" + valorcalidadSensMp + " "); 
//		
//		//sb.append("SELECT C FROM CalidadDetalleSensorialMp C");
//		/*
//		Query query = em.createNativeQuery(String.format(sb.toString(), campoidcalsensmp, campoidcalsensmp, campoidcalsensmp, Sistema.parseInt(valorcalidadSensMp) ));
//		List result = (List)query.getResultList();
//		
//
//		int resultado = 0; 
//		resultado = result.size() > 0 ? ((Integer)result.get(0)).intValue() +1:  1;
//		*/
//
//		
//		return ((CalidadDetalleSensorialMp) em.createQuery(sb.toString()).getSingleResult()).getCalidadNumeroMuestraSensorialMp().getIdcalidadnumeromuestrasensorialmp();
//	}
	
}
