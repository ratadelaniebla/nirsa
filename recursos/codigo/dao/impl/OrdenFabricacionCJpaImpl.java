package com.wm.model.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.OrdenFabricacionC;
import com.wm.model.OrdenFabricacionCPK;
import com.wm.model.OrdenFabricacionUp;
import com.wm.model.OrdenFabricacionUpl;
import com.wm.model.OrdenFabricacionUplPK;
import com.wm.model.dao.OrdenFabricacionCDAO;
import com.wm.webui.produccion.DescongeladoWindow;

public class OrdenFabricacionCJpaImpl extends BaseDaoJpaImpl implements OrdenFabricacionCDAO {

	private static Log logger = LogFactory.getLog(OrdenFabricacionCJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public OrdenFabricacionCJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public OrdenFabricacionC OrdenFabricacionCJpaImpl() {
		return new OrdenFabricacionC();
	} 

	@Override
	public void createNewOrdenFabricacionC(long iordenfabricacion, int iidproceso,
			Timestamp dhorainicio,Timestamp dhorafin,String vestado,String vobservaciones) {

	    try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					OrdenFabricacionCPK opk = new OrdenFabricacionCPK();
					opk.setIordenfabricacion(iordenfabricacion);
					opk.setIidproceso(iidproceso);
					
					OrdenFabricacionC o = new OrdenFabricacionC();
			        o.setId(opk);
			        o.setDhorainicio(dhorainicio);
			        o.setDhorafin(dhorafin);
			        o.setVobservaciones(vobservaciones);
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
	public void saveOrupdateOrdenFabricacionC(long iordenfabricacion, int iidproceso,
			Timestamp dhorainicio,Timestamp dhorafin,String vestado,String vobservaciones) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  

					OrdenFabricacionCPK opk = new OrdenFabricacionCPK();
					opk.setIordenfabricacion(iordenfabricacion);
					opk.setIidproceso(iidproceso);

			    	OrdenFabricacionC o = em.find(OrdenFabricacionC.class, opk);
					
			        o.setDhorainicio(dhorainicio);
			        o.setDhorafin(dhorafin);
			        o.setVobservaciones(vobservaciones);

 			        t.commit();
	    		  } finally {
	    		    if (t.isActive()) t.rollback();
	    		  }
	    }finally{
	    	em.close();
	    }
		
	}

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

	@Override
	public void saveOrUpdate(OrdenFabricacionC ordenfabricacionc) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(ordenfabricacionc);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

}
