package com.nw.model.dao.impl;

//import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.BarcoEstibaCuba;
import com.nw.model.CalidadBpmClasificacion;
//import com.nw.model.CalidadIncidencia;
import com.nw.model.CalidadMuestraAreaCabecera;
import com.nw.model.CalidadMuestraGrupoCaracteristica;
import com.nw.model.CalidadMuestraGrupoSubcaracteristica;
import com.nw.model.dao.CalidadBpmclasificacionDAO;


public class CalidadMuestraGrupoCaracteristicasDAOJpaImpl extends BaseDaoJpaImpl implements CalidadBpmclasificacionDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadMuestraGrupoCaracteristicasDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    public CalidadMuestraGrupoSubcaracteristica getFindCalidadMuestraGrupoSubcaracteristicabyId(Long vid) {
		return em.find(CalidadMuestraGrupoSubcaracteristica.class, vid);	
	}	

	@SuppressWarnings("unchecked")
	public List<CalidadMuestraGrupoCaracteristica> getCalidadCaracteristicas() {

		Query query = em.createQuery("select cdp From CalidadMuestraGrupoCaracteristica cdp where cdp.estado=1 order by cdp.idcalidadmuestragrupocaracteristicas");
		
		return query.getResultList();
	}    
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraGrupoSubcaracteristica> getCalidadSubcaracteristicas(Long idcalidadmuestragrupocaracteristicas) {

		Query query = em.createQuery("select cdp From CalidadMuestraGrupoSubcaracteristica cdp where cdp.estado=1 and cdp.calidadMuestraGrupoCaracteristica.idcalidadmuestragrupocaracteristicas=:id  ");
		query.setParameter("id", idcalidadmuestragrupocaracteristicas);
		return query.getResultList();
	} 
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraGrupoSubcaracteristica> getCalidadSubcaracteristicasColores(Long idcalidadmuestragrupocaracteristicas) {

		Query query = em.createQuery("select cdp From CalidadMuestraGrupoSubcaracteristica cdp where cdp.estado=1 and cdp.calidadMuestraGrupoCaracteristica.calidadMuestraGrupoCaracteristicasTipo.idcalidadmuestragrupocaracteristicastipo=2 and cdp.calidadMuestraGrupoCaracteristica.idcalidadmuestragrupocaracteristicas=:id  ");
		query.setParameter("id", idcalidadmuestragrupocaracteristicas);
		return query.getResultList();
	} 
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraGrupoSubcaracteristica> getCalidadSubcaracteristicasSabores(Long idcalidadmuestragrupocaracteristicas) {

		Query query = em.createQuery("select cdp From CalidadMuestraGrupoSubcaracteristica cdp where cdp.estado=1 and cdp.calidadMuestraGrupoCaracteristica.calidadMuestraGrupoCaracteristicasTipo.idcalidadmuestragrupocaracteristicastipo=3 and cdp.calidadMuestraGrupoCaracteristica.idcalidadmuestragrupocaracteristicas=:id  ");
		query.setParameter("id", idcalidadmuestragrupocaracteristicas);
		return query.getResultList();
	} 
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraGrupoSubcaracteristica> getCalidadSubcaracteristicasProtocolo(Long idcalidadmuestragrupocaracteristicas) {

		Query query = em.createQuery("select cdp From CalidadMuestraGrupoSubcaracteristica cdp where cdp.calidadMuestraGrupoCaracteristica.idcalidadmuestragrupocaracteristicas=:id  ");
		query.setParameter("id", idcalidadmuestragrupocaracteristicas);
		return query.getResultList();
	} 
	//@Override
	public CalidadMuestraAreaCabecera getCalidadMuestraClasificacionCabecerabyId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaCabecera o "); 
		sb.append("Where o.idcalidadmuestraarea = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaCabecera) items.get(0);
        }		
	}	
	
	public CalidadMuestraAreaCabecera getCalidadMuestraClasificacionCabecerabyLoteHaccp(String loteHaccp) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaCabecera o "); 
		sb.append("Where o.lotehaccp = '" + loteHaccp + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaCabecera) items.get(0);
        }		
	}	
	

	public void saveOrUpdate(CalidadMuestraGrupoCaracteristica cmcc) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cmcc);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	public void saveOrUpdate(CalidadMuestraGrupoSubcaracteristica cmcc) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cmcc);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}



	@Override
	public List<CalidadBpmClasificacion> getCalidadBpmClasificacions() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public CalidadBpmClasificacion getCalidadBpmClasificacionById(
			Integer idbpmclasificacion) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void saveOrUpdate(CalidadBpmClasificacion calidadbpmclasificacion) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
