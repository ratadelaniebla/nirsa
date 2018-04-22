package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadPcc;
import com.nw.model.dao.CalidadPCCDAO;

public class CalidadPCCDAOJpaImpl extends BaseDaoJpaImpl implements CalidadPCCDAO{

	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadPCCDAOJpaImpl(){
    	//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public void grabar(CalidadPcc o) {
		// Agregar cascade=CascadeType.PERSIST en Calidad_PCC
		
//		em.persist(o);
//		em.merge(o);
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void saveOrUpdate(CalidadPcc calidadpcc) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(calidadpcc);
	 			        t.commit();
    		  } catch (RuntimeException e) {
  				e.printStackTrace();
  				if (t.isActive()){    
  					t.rollback();
  				}	 
  			  }
			}finally{
				em.close();
			}
	}
	
	
	public void saveNative(CalidadPcc calidadpcc) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
	    
	    String sql = " INSERT INTO calidad_pcc( " +
	    		" idcalidadpcc, idbarcodescarga, turno, desviacion, accion, estado)  VALUES (?, ?, ?, ?, ?, ?); ";
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					Query query = em.createNativeQuery(sql);
					    query.setParameter(1, calidadpcc.getIdcalidadpcc() );
				        query.setParameter(2, calidadpcc.getBarcoDescarga().getIdbarcodescarga());
				        query.setParameter(3, calidadpcc.getTurno());
				       // query.setParameter(4, calidadpcc.getDesviacion().trim() );
				       
				        if (calidadpcc.getDesviacion()!=null) {
				        	query.setParameter(4, calidadpcc.getDesviacion().trim() );
						}else{
							query.setParameter(4, "" );
						}
				        String accion = calidadpcc.getAccion();
				        if (accion!=null) {
				        	query.setParameter(5, calidadpcc.getAccion().trim() );
						}else{
							query.setParameter(5, "" );
						}
				        query.setParameter(6, calidadpcc.getEstado() );
				        query.executeUpdate();
	 			    t.commit();
    		  } catch (RuntimeException e) {
  				e.printStackTrace();
  				if (t.isActive()){    
  					t.rollback();
  				}	 
  			  }
		 }finally{
			em.close();
		 }
	}

	@Override
	public CalidadPcc CalidadPccById(String IDCalidadPcc) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadPcc o "); 
		sb.append("Where o.idcalidadpcc = '" + IDCalidadPcc + "' "); 

		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadPcc) items.get(0);
        }	
	}	
	
	
}
