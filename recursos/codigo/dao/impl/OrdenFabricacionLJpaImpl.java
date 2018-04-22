package com.wm.model.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.OrdenFabricacionC;
import com.wm.model.OrdenFabricacionL;
import com.wm.model.OrdenFabricacionUpl;
import com.wm.model.OrdenFabricacionUplPK;
import com.wm.model.dao.OrdenFabricacionLDAO;


public class OrdenFabricacionLJpaImpl extends BaseDaoJpaImpl implements OrdenFabricacionLDAO{

	private static Log logger = LogFactory.getLog(OrdenFabricacionCJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public OrdenFabricacionLJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     

	@Override
	public OrdenFabricacionL getNewOrdenFabricacionL() {
		return new OrdenFabricacionL();
	}
	

	@Override
	public void saveOrUpdate(OrdenFabricacionL ordenfabricacionl) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(ordenfabricacionl);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	/***************************************************
	 * 
	 * 
	 * 
	 **/
	@Override
	public OrdenFabricacionL getMedioByIdAndOP(long iOrdenFabricacion,int iIdProceso,String vIdMedio) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionL o "); 
		sb.append("Where o.id.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("And o.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And o.id.vidmedio = '" + vIdMedio + "' "); 

		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionL) items.get(0);
        }		
	}
	

	@Override
	public OrdenFabricacionL getMedioByIdAndFOP(int iIdProceso, String vIdMedio, String dFProduccion) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionL o, OrdenFabricacionUp u "); 
//		sb.append("Where o.id.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("Where o.id.iordenfabricacion = u.iordenfabricacion "); 
		sb.append("And o.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And o.id.vidmedio = '" + vIdMedio + "' "); 
		sb.append("And u.dfproduccion = '" + dFProduccion + "' "); 
		
		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionL) items.get(0);
        }		
	}


	@Override
	 public Number getTotalCarrosProcesadosEviscerado(int iIdProceso, String dFechaproceso) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select count(l.id.vidmedio) "); 
		sb.append("From OrdenFabricacionL l, OrdenFabricacionUp u "); 
		sb.append("Where l.id.iordenfabricacion = u.iordenfabricacion "); 
		sb.append("And l.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And u.dfproduccion between '" + dFechaproceso + " 00:00:00' "); 
		sb.append("And '" + dFechaproceso + " 23:59:59' "); 
		sb.append("And l.mpesop2 is not null "); 


		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();

          return  countResult;
		
	}
	

	
	@Override
	 public Number getTotalCarrosEvisceradoxLote(int iIdProceso, long iOrdenFabricacion) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select count(l.id.vidmedio) "); 
		sb.append("From OrdenFabricacionL l "); 
		sb.append("Where l.id.iordenfabricacion = " + iOrdenFabricacion + " "); 
		sb.append("And l.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And l.mpesop2 is not null "); 


		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();

           return  countResult;
		
	}
	
	
	@Override
	 public Number getTotalCarrosCoccionxLote(int iIdProceso, long iOrdenFabricacion) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select count(l.id.vidmedio) "); 
		sb.append("From OrdenFabricacionL l "); 
		sb.append("Where l.id.iordenfabricacion = " + iOrdenFabricacion + " "); 
		sb.append("And l.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And l.mpesop3 is not null "); 


		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();

           return  countResult;
		
	}

	
	@Override
	 public Number getTotalCarrosNebulizadoxLote(int iIdProceso, long iOrdenFabricacion) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select count(l.id.vidmedio) "); 
		sb.append("From OrdenFabricacionL l "); 
		sb.append("Where l.id.iordenfabricacion = " + iOrdenFabricacion + " "); 
		sb.append("And l.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And l.dhorainicio is not null "); 
		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());
		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();
          return  countResult;
	}

	
	@Override
	 public Number getTotalCarrosAsignacionxLote(int iIdProceso, long iOrdenFabricacion) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select count(l.id.vidmedio) "); 
		sb.append("From OrdenFabricacionL l "); 
		sb.append("Where l.id.iordenfabricacion = " + iOrdenFabricacion + " "); 
		sb.append("And l.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And l.dhorafin is not null "); 
		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());
		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();
         return  countResult;
	}
	
	
	
}
