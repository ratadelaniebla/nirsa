package com.nw.model.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nw.model.Impresion;
import com.nw.model.ImpresionDetalle;
import com.nw.model.dao.ImpresionDAO;

@SuppressWarnings("unchecked")
public class ImpresionDAOJpaImpl extends BaseDaoJpaImpl implements ImpresionDAO {

	private static Log logger = LogFactory.getLog(ImpresionDAOJpaImpl.class);
	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public ImpresionDAOJpaImpl(){
      	emf = Persistence.createEntityManagerFactory("NW");
      	//    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    

	public List<Impresion> getLisImpresiones(String iddato) {
		return em.createQuery("select id From ImpresionDetalle id where id.iddato = :iddato")
				.setParameter("iddato", Integer.valueOf(iddato))
				.getResultList();
	}


	@Override
	public void saveOrUpdateDetalle(ImpresionDetalle impresiondetalle) 
	{
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(impresiondetalle);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	
	
	
//	public CalidadDetalleSensorialMp getDatosMuestraDatosByCabCubNivel1(String CalidadSensorialMp, String BarcoEstibaCuba, String CalidadNivelCuba, String nummuestra ){
//
//		
//		
//		System.out.println(CalidadSensorialMp);
//		System.out.println(BarcoEstibaCuba);
//		System.out.println(BarcoEstibaCuba);
//		System.out.println(nummuestra);
//
//		
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("select c "); 
//		sb.append("from CalidadDetalleSensorialMp c "); 
//		sb.append("Where c.id.idcalidadsensorialmp = '" + CalidadSensorialMp + "' AND "); 
//		sb.append("c.barcoEstibaCuba.idbarcoestibacuba = '" + BarcoEstibaCuba + "' AND ");
//		sb.append("c.calidadNivelCuba.idcalidadnivelcuba = '" + CalidadNivelCuba + "' AND ");
//		sb.append("c.numeromuestra = '" + nummuestra + "'");		
//
//		System.out.println(sb.toString());
//		
//		logger.info(CalidadSensorialMp.class +" -> "+sb.toString());
//		
//		List items =  em.createQuery(sb.toString()).getResultList();
//		
//        if (items == null || items.isEmpty()) {
//            return null;
//        } else {
//            return  (CalidadDetalleSensorialMp) items.get(0);
//        }		
//	}	
	
}
