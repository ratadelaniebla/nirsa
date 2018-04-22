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
import com.wm.model.OrdenFabricacionL;
import com.wm.model.OrdenFabricacionUp;
import com.wm.model.OrdenFabricacionUpl;
import com.wm.model.OrdenFabricacionUplPK;
import com.wm.model.dao.OrdenFabricacionUplDAO;
import com.wm.webui.produccion.DescongeladoWindow;

public class OrdenFabricacionUplJpaImpl extends BaseDaoJpaImpl implements OrdenFabricacionUplDAO {

	private static Log logger = LogFactory.getLog(DescongeladoWindow.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public OrdenFabricacionUplJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	@Override
	public OrdenFabricacionUpl getNewOrdenFabricacionUpl() {
		return new OrdenFabricacionUpl();
	}
 
	@Override
	public void createNewOrdenFabricacionUpl(long iordenfabricacion ,String vmedio, BigDecimal mpesoiniciop1/*,BigDecimal mpesofinalp1*/) {
 
	    try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					
					OrdenFabricacionUplPK opk = new OrdenFabricacionUplPK();
			    	opk.setIordenfabricacion(iordenfabricacion);
			    	opk.setVmedio(vmedio);
			    	
					OrdenFabricacionUpl o = new OrdenFabricacionUpl();
					o.setId(opk);
					o.setMpesoiniciop1(mpesoiniciop1);
			       // o.setMpesofinalp1(mpesofinalp1);
			       // o.setMpesoiniciop1(mpesoiniciop1);
			        
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
	public void saveOrupdateOrdenFabricacionUpl(long iordenfabricacion ,String vmedio, BigDecimal mpesoiniciop1/*,BigDecimal mpesofinalp1*/) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					
					OrdenFabricacionUplPK opk = new OrdenFabricacionUplPK();
			    	opk.setIordenfabricacion(iordenfabricacion);
			    	opk.setVmedio(vmedio);

			    	OrdenFabricacionUpl o = em.find(OrdenFabricacionUpl.class, opk);
					
//			        o.setMpesofinalp1(mpesofinalp1);
			        o.setMpesoiniciop1(mpesoiniciop1);

 			        t.commit();
	    		  } finally {
	    		    if (t.isActive()) t.rollback();
	    		  }
	    }finally{
	    	em.close();
	    }
		
	}

	@Override
	public void saveOrUpdate(OrdenFabricacionUpl ordenfabricacionupl) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(ordenfabricacionupl);
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
	public OrdenFabricacionUpl getMedioByIdAndOP(long iOrdenFabricacion,String vMedio) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionUpl o "); 
		sb.append("Where o.id.iordenfabricacion =" + iOrdenFabricacion + " "); 
		sb.append("And o.id.vmedio = '" + vMedio + "' "); 

		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionUpl) items.get(0);
        }		
	}

	@Override
	public OrdenFabricacionUpl getMedioByIdAndFOP(String vIdMedio, String dFProduccion) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From OrdenFabricacionUpl o, OrdenFabricacionUp u "); 
		sb.append("Where o.id.iordenfabricacion = u.iordenfabricacion "); 
		sb.append("And o.id.vmedio = '" + vIdMedio + "' "); 
		sb.append("And u.dfproduccion = '" + dFProduccion + "' "); 

		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionUpl) items.get(0);
        }		
	}

	
	
	@Override
	public Number getCountTinasOPWithOutWeigth(long iOrdenFabricacion) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select COUNT(o "); 
		sb.append("From OrdenFabricacionUpl o "); 
		sb.append("Where o.id.iordenfabricacion =" + iOrdenFabricacion + " "); 
		//sb.append("And o.id.vmedio = '" + vMedio + "' "); 

		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		Number countResult=(Number) em.createQuery(sb.toString()).getSingleResult();

            return  countResult;

	}

}
