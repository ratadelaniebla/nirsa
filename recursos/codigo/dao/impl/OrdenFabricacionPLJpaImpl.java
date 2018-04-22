package com.wm.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.OrdenFabricacionPL;
import com.wm.model.OrdenFabricacionPLPK;
import com.wm.model.OrdenFabricacionUp;
import com.wm.model.dao.OrdenFabricacionPLDAO;

public class OrdenFabricacionPLJpaImpl extends BaseDaoJpaImpl implements OrdenFabricacionPLDAO {

	private static Log logger = LogFactory.getLog(OrdenFabricacionPLJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public OrdenFabricacionPLJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public OrdenFabricacionPL OrdenFabricacionCocinaJpaImpl() {
		return new OrdenFabricacionPL();
	} 

	@Override
	public void saveOrUpdate(OrdenFabricacionPL ordenfabricacioncocina) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(ordenfabricacioncocina);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

	@Override
	public void grabarOactualizar(OrdenFabricacionPL ordenfabricacioncocina) {
			try{
		    	 EntityTransaction t = em.getTransaction();
		    	  try {
						t.begin();  

						OrdenFabricacionPLPK pk = new OrdenFabricacionPLPK();
						pk.setDfechaproceso(ordenfabricacioncocina.getId().getDfechaproceso());
						pk.setIidcocina(ordenfabricacioncocina.getId().getIidcocina());
						pk.setIidproceso(ordenfabricacioncocina.getId().getIidproceso());
						pk.setiidregistropl(ordenfabricacioncocina.getId().getiidregistropl());
						pk.setInrococinada(ordenfabricacioncocina.getId().getInrococinada());
						pk.setIordenfabricacion(ordenfabricacioncocina.getId().getIordenfabricacion());
						
						OrdenFabricacionPL o = em.find(OrdenFabricacionPL.class, pk);
						if (o == null){
							em.merge(ordenfabricacioncocina);
						}
						else{
							o.setId(ordenfabricacioncocina.getId());
							o.setDhorafin(ordenfabricacioncocina.getDhorafin());
							o.setDhorafinprecoc(ordenfabricacioncocina.getDhorafinprecoc());
							o.setDhorainicio(ordenfabricacioncocina.getDhorainicio());
							o.setDhorainicioprecoc(ordenfabricacioncocina.getDhorainicioprecoc());
							o.setHoraIngreso_AU(ordenfabricacioncocina.getHoraIngreso_AU());
							o.setHoraModificacion_AU(ordenfabricacioncocina.getHoraModificacion_AU());
							o.setId(ordenfabricacioncocina.getId());
							o.setMpresionvapor(ordenfabricacioncocina.getMpresionvapor());
							o.setMtempinterna(ordenfabricacioncocina.getMtempinterna());
							o.setUsuarioIngreso_AU(ordenfabricacioncocina.getUsuarioIngreso_AU());
							o.setUsuarioModificacion_AU(ordenfabricacioncocina.getUsuarioModificacion_AU());
							em.merge(o);
						}	
				        t.commit();
		    		  } finally {
		    		    if (t.isActive()) t.rollback();
		    		  }
		    }finally{
		    	em.close();
		    }
	}
	
	
	
	@Override
	 public OrdenFabricacionPL getInfoCocinasById(
			long iOrdenFabricacion,
			int iIdProceso,
			int iIdCocina,
			int iNroCocinada,
			String dFechaproceso) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionPL o "); 
		sb.append("Where o.id.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("And o.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And o.id.iidcocina = '" + iIdCocina + "' "); 
		sb.append("And o.id.inrococinada = '" + iNroCocinada + "' "); 
		sb.append("And o.id.dfechaproceso between '" + dFechaproceso + " 00:00:00' "); 
		sb.append("And '" + dFechaproceso + " 23:59:59' "); 

		
		logger.info(OrdenFabricacionPLJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionPL) items.get(0);
        }		
	}
	 

	@Override
	 public List<OrdenFabricacionPL> getInfoCocinasByOrdenF(
			long iOrdenFabricacion,
			int iIdProceso,
			String dFechaproceso) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionPL o "); 
		sb.append("Where o.id.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("And o.id.iidproceso = " + iIdProceso + " "); 
		sb.append("And o.id.dfechaproceso between '" + dFechaproceso + " 00:00:00' "); 
		sb.append("And '" + dFechaproceso + " 23:59:59' "); 
		
		logger.info(OrdenFabricacionPLJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

       if (items == null || items.isEmpty()) {
           return null;
       } else {
           return  (List<OrdenFabricacionPL>) items;
       }		
	}
	
	public OrdenFabricacionPL getOrdenFabricacionCocinaByID(long iidregistropl) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionPL o "); 
		sb.append("Where o.id.iidregistropl =" + iidregistropl + " "); 

		logger.info(OrdenFabricacionPLJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionPL) items.get(0);
        }		

	}


	@Override
	 public Number getInfoTotalCocinadasByFId(int iNroCocina,
			int iNroCocinada,
			String dFechaproceso) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select count(o.id.inrococinada) "); 
		sb.append("From OrdenFabricacionPL o "); 
		sb.append("Where o.id.inrococinada = '" + iNroCocinada + "' "); 
		sb.append("And o.id.iidcocina <> '" + iNroCocina + "' "); 
		sb.append("And o.id.dfechaproceso between '" + dFechaproceso + " 00:00:00' "); 
		sb.append("And '" + dFechaproceso + " 23:59:59' "); 


		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();

            return  countResult;
		
	}
	
}
