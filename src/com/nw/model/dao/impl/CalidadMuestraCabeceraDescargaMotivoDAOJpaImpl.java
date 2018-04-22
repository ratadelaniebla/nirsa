package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadBpmClasificacion;
import com.nw.model.CalidadMuestraCabeceraDescargaMotivo;
import com.nw.model.dao.CalidadBpmclasificacionDAO;


public class CalidadMuestraCabeceraDescargaMotivoDAOJpaImpl extends BaseDaoJpaImpl implements CalidadBpmclasificacionDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadMuestraCabeceraDescargaMotivoDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

    public CalidadMuestraCabeceraDescargaMotivo getFindMotivoId(long vid) {
		return em.find(CalidadMuestraCabeceraDescargaMotivo.class, vid);	
	}	  
	
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraCabeceraDescargaMotivo> getCalidadMotivoRemuestreo(Long idcabecera) {

		Query query = em.createQuery("select cdp From CalidadMuestraCabeceraDescargaMotivo cdp where cdp.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera="+idcabecera+"   ");
		
		return query.getResultList();
	} 
	
	
	public CalidadMuestraCabeceraDescargaMotivo getCalidadMotivoRemuestreobyCabeceraandMotivo(Long idcabecera,int idmotivo) {

		Query query = em.createQuery("select cdp From CalidadMuestraCabeceraDescargaMotivo cdp where cdp.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera="+idcabecera+" and cdp.calidadMuestraAreaMotivo.idcalidadmuestraareamotivo="+idmotivo+"  ");
		
		return (CalidadMuestraCabeceraDescargaMotivo) query.getResultList().get(0);
	} 
	
	//@Override
	

	public void saveOrUpdate(CalidadMuestraCabeceraDescargaMotivo cmcc) {

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
