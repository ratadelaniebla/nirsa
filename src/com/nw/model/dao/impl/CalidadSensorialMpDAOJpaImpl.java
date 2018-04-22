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
import com.nw.model.CalidadDetalleSensorialMp;
import com.nw.model.CalidadSensorialMp;
import com.nw.model.dao.CalidadSensorialMpDAO;


@SuppressWarnings("unchecked")
public class CalidadSensorialMpDAOJpaImpl extends BaseDaoJpaImpl implements CalidadSensorialMpDAO {

	private static Log logger = LogFactory.getLog(CalidadSensorialMpDAOJpaImpl.class);

	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
	
    public CalidadSensorialMpDAOJpaImpl() {
    	//    	emf = Persistence.createEntityManagerFactory("NW");
        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public CalidadSensorialMp CalidadSensorialMpJpaImpl() {
		return new CalidadSensorialMp();
	} 
/*
	@Override
	public void createNewMedioPeriodo(String vidmedio, String vtipo,
			BigDecimal mtara, Timestamp dfechahorainicio, Timestamp dfechahorafin, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU) {

	    try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					MedioPeriodoPK opk = new MedioPeriodoPK();
					opk.setIvidmedio(vidmedio);
					opk.setIvtipo(vtipo);
					opk.setDdfechahorainicio(dfechahorainicio);
					
					MedioPeriodo o = new MedioPeriodo();
			        o.setId(opk);
			        o.setImtara(mtara);
//			        o.dfechahorainiciouso(dhorafin);
			        o.setDdfechahorafin(dfechahorafin);
			        o.setVobservaciones(vobservaciones);
			        o.setHoraIngreso_AU(horaingreso_AU);
			        o.setUsuarioIngreso_AU(usuarioingreso_AU);
			        o.setHoraModificacion_AU(horamodificacion_AU);
			        o.setUsuarioModificacion_AU(usuariomodificacion_AU);
			        em.persist(o);
					t.commit();
    		  } finally {
	    		    if (t.isActive()) t.rollback();
    		  }
	    }finally{
	    	em.close();
	    }		
	} 
*/	
/*	@Override
	public void saveOrupdateMedioPeriodo(String vidmedio, String vtipo,
			BigDecimal mtara, Timestamp dfechahorainicio, Timestamp dfechahorafin, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  

					MedioPeriodoPK opk = new MedioPeriodoPK();
					opk.setIvidmedio(vidmedio);
					opk.setIvtipo(vtipo);
					opk.setDdfechahorainicio(dfechahorainicio);

			    	MedioPeriodo o = em.find(MedioPeriodo.class, opk);
					
//			        o.setDhorainicio(dhorainicio);
//			        o.setDhorafin(dhorafin);
			    	o.setImtara(mtara);
			        o.setDdfechahorafin(dfechahorafin);
			    	o.setVobservaciones(vobservaciones);
			        o.setHoraIngreso_AU(horaingreso_AU);
			        o.setUsuarioIngreso_AU(usuarioingreso_AU);
			        o.setHoraModificacion_AU(horamodificacion_AU);
			        o.setUsuarioModificacion_AU(usuariomodificacion_AU);
 			        t.commit();
	    		  } finally {
	    		    if (t.isActive()) t.rollback();
	    		  }
	    }finally{
	    	em.close();
	    }
		
	}
*/


	
	public CalidadDetalleSensorialMp getCalidadDetalleSensorialMpByIdcalidadsensorialmpIdcalidadnumeromuestrasensorialmp(String idcalidadsensorialmp, String idcalidadnumeromuestrasensorialmp) {

		Query query = em.createQuery("select cdp From CalidadDetalleSensorialMp cdp " +
				"where cdp.id.idcalidadsensorialmp = :idcalidadsensorialmp and cdp.id.idcalidadnumeromuestrasensorialmp = :idcalidadnumeromuestrasensorialmp ");
		query.setParameter("idcalidadsensorialmp", Integer.valueOf(idcalidadsensorialmp));
		query.setParameter("idcalidadnumeromuestrasensorialmp", Integer.valueOf(idcalidadnumeromuestrasensorialmp));	
		List items = query.getResultList();
		
        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadDetalleSensorialMp) items.get(0);
        }		
	}	
	public Integer getSecuenciaCalidadDetalleSensorial(String idcalidadsensorialmp) {

		Query query = em.createQuery("select cdp From CalidadDetalleSensorialMp cdp " +
				"where cdp.id.idcalidadsensorialmp = :idcalidadsensorialmp  ");
		query.setParameter("idcalidadsensorialmp", Integer.valueOf(idcalidadsensorialmp));
		//query.setParameter("idcalidadnumeromuestrasensorialmp", Integer.valueOf(idcalidadnumeromuestrasensorialmp));	
		List items = query.getResultList();
		
        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (Integer) items.size();
        }		
	}	
	
	
	@Override
	public CalidadSensorialMp getCalidadSensorialMpByIdBarcoDescarga(String idBarcoDescarga) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadSensorialMp o "); 
		sb.append("Where o.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 

		logger.info(CalidadSensorialMp.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadSensorialMp) items.get(0);
        }		
	}
	
	
/*
	@Override
	public OrdenFabricacionC getOrdenProceso(long iOrdenFabricacion,int iidproceso) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionC o "); 
		sb.append("Where o.id.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("And o.id.iidproceso = " + iidproceso + " "); 

		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionC) items.get(0);
        }		
	}
*/
	@Override
	public void saveOrUpdate(CalidadSensorialMp calidadsensorialmp) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(calidadsensorialmp);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

	public void saveNative(CalidadSensorialMp calidadsensorialmp) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
	    
	    String sql = " INSERT INTO calidad_sensorial_mp( idcalidadsensorialmp, idbarcodescarga, observaciones, estado) " +
	    		" VALUES (?, ?, ?, ?); ";
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					Query query = em.createNativeQuery(sql);
					    query.setParameter(1, calidadsensorialmp.getIdcalidadsensorialmp() );
				        query.setParameter(2, calidadsensorialmp.getBarcoDescarga().getIdbarcodescarga());
				        if (calidadsensorialmp.getObservaciones()!=null) {
				        	query.setParameter(3, calidadsensorialmp.getObservaciones().trim() );
						}else{
							query.setParameter(3, "" );
						}
				        //query.setParameter(3, calidadsensorialmp.getObservaciones());
				        query.setParameter(4, calidadsensorialmp.getEstado() );
				         
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

	
}
