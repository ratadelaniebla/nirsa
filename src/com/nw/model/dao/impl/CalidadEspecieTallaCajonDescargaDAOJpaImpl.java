package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoDescarga;
import com.nw.model.CalidadDetalleEspecietallaCajonBanda;
import com.nw.model.CalidadEspecietallaCajonBanda;
import com.nw.model.EspecieTalla;
import com.nw.model.dao.CalidadEspecieTallaCajonDescargaDAO;



@SuppressWarnings("unchecked")
public class CalidadEspecieTallaCajonDescargaDAOJpaImpl extends BaseDaoJpaImpl implements CalidadEspecieTallaCajonDescargaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadEspecieTallaCajonDescargaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public CalidadEspecietallaCajonBanda getFindBarcobyId(Integer vid) {
		return em.find(CalidadEspecietallaCajonBanda.class, vid);	
	}	    

    
    public List<CalidadEspecietallaCajonBanda> getBarcos() {
		return em.createQuery("select b from CalidadEspecietallaCajonBanda b ").getResultList();
	}
    
    
    
    public void saveOrUpdateDetalle(CalidadDetalleEspecietallaCajonBanda cdtcb) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cdtcb);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
    
	public CalidadEspecietallaCajonBanda saveOrUpdate(CalidadEspecietallaCajonBanda ctcb) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
	    CalidadEspecietallaCajonBanda ctc = new CalidadEspecietallaCajonBanda();
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					ctc=em.merge(ctcb);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
		return ctc;
	}
	
	public CalidadEspecietallaCajonBanda obtenerCalidadEcb(EspecieTalla especieTalla, BarcoDescarga barcoDescarga) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
	    CalidadEspecietallaCajonBanda ctc = new CalidadEspecietallaCajonBanda();
	   
	    try {
	    	Query query =  em.createQuery(" select cc from CalidadEspecietallaCajonBanda cc" +
					" where cc.barcoDescarga = :barcod and cc.especieTalla = :especiet ");
		    query.setParameter("especiet", especieTalla);
		    query.setParameter("barcod", barcoDescarga);
		    ctc = (CalidadEspecietallaCajonBanda) query.getSingleResult();
		    
			return ctc;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	    
	}
	
	public List<CalidadDetalleEspecietallaCajonBanda> obtenerNumeroMuestra(EspecieTalla especieTalla, BarcoDescarga barcoDescarga) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
	    List<CalidadDetalleEspecietallaCajonBanda> cdtcb = new ArrayList<CalidadDetalleEspecietallaCajonBanda>();
	   
	    try {
	    	Query query =  em.createQuery(" select cc from CalidadDetalleEspecietallaCajonBanda cc" +
					" where cc.calidadEspecietallaCajonBanda.barcoDescarga = :barcod and cc.calidadEspecietallaCajonBanda.especieTalla = :especiet ");
		    query.setParameter("especiet", especieTalla);
		    query.setParameter("barcod", barcoDescarga);
		    cdtcb = query.getResultList();
		    
			return cdtcb;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	    
	}
	
	public List<CalidadDetalleEspecietallaCajonBanda> obtenerNumeroMuestraByBarcoAndCajon(BarcoDescarga barcoDescarga, String idcajon) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
	    List<CalidadDetalleEspecietallaCajonBanda> listaCdcb = new ArrayList<CalidadDetalleEspecietallaCajonBanda>();
	   
	    try {
	    	Query query =  em.createQuery(" select cc from CalidadDetalleEspecietallaCajonBanda cc" +
					" where cc.calidadEspecietallaCajonBanda.barcoDescarga = :barcod and cc.cajon.idcajon = :caj ");
		    query.setParameter("barcod", barcoDescarga);
		    query.setParameter("caj", idcajon);
		    listaCdcb = query.getResultList();
		    
			return listaCdcb;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	    
	}
	
	public List<CalidadDetalleEspecietallaCajonBanda> obtenerNumeroMuestraByBarcoAndCajonExterno(BarcoDescarga barcoDescarga, String idcajon) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
	    List<CalidadDetalleEspecietallaCajonBanda> listaCdcb = new ArrayList<CalidadDetalleEspecietallaCajonBanda>();
	   
	    try {
	    	Query query =  em.createQuery(" select cc from CalidadDetalleEspecietallaCajonBanda cc" +
					" where cc.calidadEspecietallaCajonBanda.barcoDescarga = :barcod and cc.idcajonexterno = :caj ");
		    query.setParameter("barcod", barcoDescarga);
		    query.setParameter("caj", idcajon);
		    listaCdcb = query.getResultList();
		    
			return listaCdcb;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	    
	}
	
	public List<CalidadDetalleEspecietallaCajonBanda> obtenerNumeroMuestraByBarcoAndCajonAndEspecie(BarcoDescarga barcoDescarga, String idcajon,int idespecietalla) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
	    List<CalidadDetalleEspecietallaCajonBanda> listaCdcb = new ArrayList<CalidadDetalleEspecietallaCajonBanda>();
	   
	    try {
	    	Query query =  em.createQuery(" select cc from CalidadDetalleEspecietallaCajonBanda cc" +
					" where cc.calidadEspecietallaCajonBanda.barcoDescarga = :barcod and cc.cajon.idcajon = :caj "+
	    			" and cc.calidadEspecietallaCajonBanda.especieTalla.idespecietalla = :idespecietalla");
		    query.setParameter("barcod", barcoDescarga);
		    query.setParameter("caj", idcajon);
		    query.setParameter("idespecietalla", idespecietalla);
		    listaCdcb = query.getResultList();
		    
			return listaCdcb;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	    
	}

	public List<CalidadDetalleEspecietallaCajonBanda> obtenerNumeroCajonByBarco(BarcoDescarga barcoDescarga) {
		   List<CalidadDetalleEspecietallaCajonBanda> listaCdcb = new ArrayList<CalidadDetalleEspecietallaCajonBanda>();
		   
		    try {
		    	Query query =  em.createQuery(" select cc from CalidadDetalleEspecietallaCajonBanda cc" +
						" where cc.calidadEspecietallaCajonBanda.barcoDescarga = :barcod ");
		    						query.setParameter("barcod", barcoDescarga);
			    listaCdcb = query.getResultList();
			    
				return listaCdcb;
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		    
		}	
	
	
}
