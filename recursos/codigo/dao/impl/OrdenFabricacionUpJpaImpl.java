package com.wm.model.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.OrdenFabricacionL;
import com.wm.model.OrdenFabricacionUp;
import com.wm.model.dao.OrdenFabricacionUpDAO;
import com.wm.webui.produccion.DescongeladoWindow;

import java.util.List;

public class OrdenFabricacionUpJpaImpl extends BaseDaoJpaImpl implements OrdenFabricacionUpDAO {

	private static Log logger = LogFactory.getLog(OrdenFabricacionUpJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public OrdenFabricacionUpJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	@Override
	public OrdenFabricacionUp getNewOrdenFabricacionUp() {
		return new OrdenFabricacionUp();
	}
	
	@Override
	public void createNewOrdenFabricacionUp(String vidordenfabricacionsap, String idmaterial, String idlote,
			String idpackinlist, Timestamp ifechaproduccion, int idiajuliano, int igrupoprocesos, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU) {

	    try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					OrdenFabricacionUp o = new OrdenFabricacionUp();
			        o.setVordenfabricacionsap(vidordenfabricacionsap);
			        o.setIdmaterial(idmaterial);
			        o.setIdlote(idlote);
			        o.setIdpackinlist(idpackinlist);
			        o.setDfproduccion(ifechaproduccion);
			        o.setIdiajuliano(idiajuliano);
			        o.setIidgrupoprocesos(igrupoprocesos);
			        o.setVobservaciones(vobservaciones);
			        o.setHoraingreso_AU(horaingreso_AU);
			        o.setUsuarioingreso_AU(usuarioingreso_AU);
			        o.setHoramodificacion_AU(horamodificacion_AU);
			        o.setUsuariomodificacion_AU(usuariomodificacion_AU);
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
	public void saveOrupdateOrdenFabricacionUp(long iordenfabricacion, String idlote, String vidordenfabricacionsap, String idmaterial,
			String idpackinlist, Timestamp ifechaproduccion, int idiajuliano, int igrupoprocesos, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					OrdenFabricacionUp o = em.find(OrdenFabricacionUp.class, iordenfabricacion);
			        o.setVordenfabricacionsap(vidordenfabricacionsap);
			        o.setIdmaterial(idmaterial);
			        o.setIdlote(idlote);
			        o.setIdpackinlist(idpackinlist);
			        o.setDfproduccion(ifechaproduccion);
			        o.setIdiajuliano(idiajuliano);
			        o.setIidgrupoprocesos(igrupoprocesos);
			        o.setVobservaciones(vobservaciones);
			        o.setHoraingreso_AU(horaingreso_AU);
			       // o.setUsuarioingreso_AU(usuarioingreso_AU);
			        o.setHoramodificacion_AU(horamodificacion_AU);
			       // o.setUsuariomodificacion_AU(usuariomodificacion_AU);
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
	public List<OrdenFabricacionUp> getOrdenesByDate(String dFProduccion) { 
		
		StringBuffer sb = new StringBuffer();

		sb.append("Select o "); 
		sb.append("From OrdenFabricacionUp o "); 
		sb.append("Where o.dfproduccion between '" + dFProduccion + " 00:00:00' "); 
		sb.append("And '" + dFProduccion + " 23:59:59' "); 
		
		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();
		
        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return (List<OrdenFabricacionUp>) items;
        }		

	}

    @Override
	public List getOrdenArchivo(String ordenfabsap, String material, String lote){
    	//em = emf.createEntityManager();   
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT "); 
		sb.append("O.IORDENFABRICACION, O.VORDENFABRICACIONSAP, O.IDMATERIAL, O.IDLOTE "); 
		sb.append("FROM ORDEN_FABRICACION_UP O "); 
		sb.append("WHERE "); 
		sb.append("O.VORDENFABRICACIONSAP = '"+ordenfabsap+"' "); 
		sb.append("AND O.IDMATERIAL = '"+material+"' ");
		sb.append("AND O.IDLOTE = '"+lote+"' ");
		
		String sss= sb.toString();
		
		//em.createNativeQuery(sb.toString()).getResultList();
		List listOpciones =  em.createNativeQuery(sb.toString()).getResultList();
	    if (listOpciones == null || listOpciones.isEmpty()) {
	    	//logger.info(message, t) ("item: "+vIdDato+" not found");
	        return null;
	    } else {
	        return listOpciones;
	    }
	}

	public OrdenFabricacionUp getOrdenxOrdenFab(long ordenfab){
    	//em = emf.createEntityManager();   
		StringBuffer sb = new StringBuffer();
		sb.append("select o "); 
//		sb.append("O.IORDENFABRICACION, O.VORDENFABRICACIONSAP, O.IDMATERIAL, O.IDLOTE "); 
//		sb.append("FROM ORDEN_FABRICACION_UP O "); 
//		sb.append("WHERE "); 
//		sb.append("O.IORDENFABRICACION = '"+ordenfab+"' "); 
		sb.append("from OrdenFabricacionUp o "); 
		sb.append("where  "); 
		sb.append("o.iordenfabricacion = '"+ordenfab+"' "); 
		
		logger.info(OrdenFabricacionUpJpaImpl.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (OrdenFabricacionUp) items.get(0);
        }		
	}
    

}
