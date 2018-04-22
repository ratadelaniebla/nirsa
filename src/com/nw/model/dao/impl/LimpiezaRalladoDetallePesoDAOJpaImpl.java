package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.ControlDetalleBatchRallado;
import com.nw.model.LimpiezaRalladoBatchCabecera;
import com.nw.model.LimpiezaRalladoBatchDetalle;
import com.nw.model.LimpiezaRalladoDetallePeso;
import com.nw.model.dao.LimpiezaRalladoDetallePesoDAO;

public class LimpiezaRalladoDetallePesoDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaRalladoDetallePesoDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaRalladoDetallePesoDAOJpaImpl()
    {
      	emf = Persistence.createEntityManagerFactory("NW");
        em = emf.createEntityManager();   
    }
    

//	@Override
//	public void saveOrUpdateDetalle11(saveOrUpdateDetalle limpiezaRalladoDetallePeso) 
//	{
//		try{
//	    	 EntityTransaction t = em.getTransaction();
//	    	  try {
//					t.begin();  
//						em.merge(limpiezaRalladoDetallePeso);
//	 			        t.commit();
//    		  } finally {
//    		    if (t.isActive()) t.rollback();
//    		  }
//			}finally{
//				em.close();
//			}
//	}	
	
    
//	public LimpiezaRalladoDetallePeso getLimpiezaRalladoDetallePesoByHoraMax(Timestamp f) 
//	{ 
//		
//		StringBuffer sb = new StringBuffer();
//		try {
//			sb.append("Select o "); 
//			sb.append("From LimpiezaRalladoDetallePeso o "); 
//			sb.append("Where o.fechareg  => '" + f + "' order by o.fechareg desc "); 
//
//			@SuppressWarnings("rawtypes")
//			List items =  em.createQuery(sb.toString()).getResultList().subList(0, 1);
//
//			if (items == null || items.isEmpty()) {
//			    return null;
//			} else {
//			    return  (LimpiezaRalladoDetallePeso) items.get(0);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		return null;
//	}	
    

//	public LimpiezaRalladoDetallePeso getLimpiezaRalladoDetallePesoByHoraMin(Timestamp f) 
//	{ 		
//		StringBuffer sb = new StringBuffer();
//		try {
//			sb.append("Select o "); 
//			sb.append("From LimpiezaRalladoDetallePeso o "); 
//			sb.append("Where o.fechareg  <= '" + f + "' and o.controlDetalleBatchRallados is null  ");
//			sb.append("order by o.fechareg asc "); 
//
//			@SuppressWarnings("rawtypes")
//			List items =  em.createQuery(sb.toString()).getResultList().subList(0, 1);
//
//			if (items == null || items.isEmpty()) {
//			    return null;
//			} else {
//			    return  (LimpiezaRalladoDetallePeso) items.get(0);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		return null;
//	}	
	

	public LimpiezaRalladoDetallePeso getLimpiezaRalladoDetallePesoByHoraMax(Timestamp f1, Timestamp f2) 
	{ 		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("Select o "); 
			sb.append("From LimpiezaRalladoDetallePeso o "); 
			sb.append("Where o.fechareg  >= '" + f1 + "' and o.controlDetalleBatchRallados is null  ");
			sb.append("order by o.fechareg "); 

			@SuppressWarnings("rawtypes")
			List items =  em.createQuery(sb.toString()).getResultList().subList(0, 1);

			if (items == null || items.isEmpty()) {
			    return null;
			} else {
			    return  (LimpiezaRalladoDetallePeso) items.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoDetallePeso> getBandejasEntreFechas(Timestamp f1, Timestamp f2)
	{
		System.out.println(" f1.toString() :"+f1.toString());
		System.out.println(" f2.toString() :"+f2.toString());
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<LimpiezaRalladoDetallePeso> pacs = new ArrayList<LimpiezaRalladoDetallePeso>();
		try {
			Query query = em
					.createQuery("Select o " +
			"From LimpiezaRalladoDetallePeso o " +
			"Where o.fechareg  >= :f1 and o.fechareg <= :f2 " +
			"order by o.fechareg "); 
			
			query.setParameter("f1", f1);
			query.setParameter("f2", f2);
			
			pacs = query.getResultList();
			return pacs;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;	
		}
		
	}	
	

	public LimpiezaRalladoDetallePeso getLimpiezaRalladoDetallePesoPorID(Long idl) 
	{ 
		
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("Select o "); 
			sb.append("From LimpiezaRalladoDetallePeso o "); 
			sb.append("Where o.idlimpiezaralladodetallepesos = "+idl);
			@SuppressWarnings("rawtypes")
			List items =  em.createQuery(sb.toString()).getResultList();

			if (items == null || items.isEmpty()) {
			    return null;
			} else {
			    return  (LimpiezaRalladoDetallePeso) items.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}		
	}	
	
	
	
	
	
    public LimpiezaRalladoDetallePeso saveOrUpdateDetalle (LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) 
    {
    	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    	EntityManager em = emf.createEntityManager();
    	LimpiezaRalladoDetallePeso limpiezaRalladoDetallePesoDevuelto = new LimpiezaRalladoDetallePeso();
     try {
            
            
            
            EntityTransaction t = em.getTransaction();
            try {
                   t.begin();
                   limpiezaRalladoDetallePesoDevuelto = em.merge(limpiezaRalladoDetallePeso);
                   t.commit();
            } finally {
                   if (t.isActive())
                          t.rollback();
            }
     } finally {
            em.close();
     }
     return limpiezaRalladoDetallePesoDevuelto;
}	

    
    
    
    
    
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoBatchDetalle> getBandejasPorBath(Long pidlimpiezaralladobatchcabecera)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<LimpiezaRalladoBatchDetalle> pacs = new ArrayList<LimpiezaRalladoBatchDetalle>();
		try {
			Query query = em
					.createQuery("Select o " +
			"From LimpiezaRalladoBatchDetalle o " +
			"Where o.limpiezaRalladoBatchCabecera.idlimpiezaralladobatchcabecera = :pidlimpiezaralladobatchcabecera  " +
			"order by o.limpiezaRalladoBatchCabecera.batch "); 
			
			query.setParameter("pidlimpiezaralladobatchcabecera", pidlimpiezaralladobatchcabecera);

			
			pacs = query.getResultList();
			return pacs;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;	
		}
		
	}    
    
    
    
    
	
}
