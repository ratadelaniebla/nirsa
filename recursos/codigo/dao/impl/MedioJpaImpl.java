package com.wm.model.dao.impl;

import java.math.BigDecimal;
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
import com.wm.model.Medio;
import com.wm.model.MedioPK;
import com.wm.model.OrdenFabricacionC;
import com.wm.model.OrdenFabricacionCPK;
import com.wm.model.OrdenFabricacionUp;
import com.wm.model.OrdenFabricacionUpl;
import com.wm.model.OrdenFabricacionUplPK;
import com.wm.model.dao.MedioDAO;
import com.wm.model.dao.OrdenFabricacionCDAO;
import com.wm.webui.produccion.DescongeladoWindow;

public class MedioJpaImpl extends BaseDaoJpaImpl implements MedioDAO {

	private static Log logger = LogFactory.getLog(MedioJpaImpl.class);

	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public MedioJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public Medio MedioJpaImpl() {
		return new Medio();
	} 

	@Override
	public void createNewMedio(String vidmedio, String vtipo,
			BigDecimal mtara, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU) {

	    try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					MedioPK opk = new MedioPK();
					opk.setIvidmedio(vidmedio);
					opk.setIvtipo(vtipo);
					
					Medio o = new Medio();
			        o.setId(opk);
			        o.setImtara(mtara);
/*			        o.dfechahorainiciouso(dhorafin);*/
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
	public void saveOrupdateMedio(String vidmedio, String vtipo,
			BigDecimal mtara, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  

					MedioPK opk = new MedioPK();
					opk.setIvidmedio(vidmedio);
					opk.setIvtipo(vtipo);

			    	Medio o = em.find(Medio.class, opk);
					
/*			        o.setDhorainicio(dhorainicio);
			        o.setDhorafin(dhorafin);*/
			    	o.setImtara(mtara);
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
	public Medio getMedioByIdAndOP(String vMedio, String vTipo) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From Medio o "); 
		sb.append("Where o.id.vidmedio = '" + vMedio + "' "); 
		sb.append("And o.id.vtipo = '" + vTipo + "' "); 

		logger.info(Medio.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (Medio) items.get(0);
        }		
	}
	
	
	@Override
	public void saveOrUpdate(Medio medio) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(medio);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

}
