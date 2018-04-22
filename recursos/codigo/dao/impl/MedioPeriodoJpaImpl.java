package com.wm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.MedioPeriodo;
import com.wm.model.MedioPeriodoPK;
import com.wm.model.dao.MedioPeriodoDAO;

public class MedioPeriodoJpaImpl extends BaseDaoJpaImpl implements MedioPeriodoDAO {

	private static Log logger = LogFactory.getLog(MedioPeriodoJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public MedioPeriodoJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public MedioPeriodo MedioPeriodoJpaImpl() {
		return new MedioPeriodo();
	} 

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
/*			        o.dfechahorainiciouso(dhorafin);*/
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
	
	@Override
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
					
/*			        o.setDhorainicio(dhorainicio);
			        o.setDhorafin(dhorafin);*/
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


	@Override
	public MedioPeriodo getMedioPeriodoByIdAndOP(String vMedio, String vTipo, String dfechahorainicio) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From MedioPeriodo o "); 
		sb.append("Where o.id.vidmedio = '" + vMedio + "' "); 
		sb.append("And o.id.vtipo = '" + vTipo + "' "); 
		sb.append("And o.id.dfechahorainicio between '" + dfechahorainicio + " 00:00:00' "); 
		sb.append("And '" + dfechahorainicio + " 23:59:59' "); 

		
		logger.info(MedioPeriodo.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (MedioPeriodo) items.get(0);
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
	public void saveOrUpdate(MedioPeriodo medioperiodo) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(medioperiodo);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

}
