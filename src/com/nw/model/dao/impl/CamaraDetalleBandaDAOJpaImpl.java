package com.nw.model.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.CamaraDetalleBanda;
import com.nw.model.dao.CamaraDetalleBandaDAO;
/*import com.wm.model.MedioPeriodo;
import com.wm.model.MedioPeriodoPK;
import com.wm.model.dao.MedioPeriodoDAO;*/

@SuppressWarnings("unchecked")
public class CamaraDetalleBandaDAOJpaImpl extends BaseDaoJpaImpl implements CamaraDetalleBandaDAO {

	private static Log logger = LogFactory.getLog(CamaraDetalleBandaDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public CamaraDetalleBandaDAOJpaImpl() {

   //    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	public List<CamaraDetalleBanda> getTotalVolquetadasBarco(String idbarcoestibacuba) {
		return em.createQuery("select cdb From CamaraDetalleBanda cdb where cdb.barcoEstibaCuba.idbarcoestibacuba = :idbarcoestibacuba ")
				.setParameter("idBarcoDes", Integer.valueOf(idbarcoestibacuba))
				.getResultList();
	}

  
	
//	public List<CamaraDetalleBanda> CamaraDetalleBanda1(String idb) {
//		return em.createQuery("select cdb From CamaraDetalleBanda cdb where cdb.barcoEstibaCuba.idbarcoestibacuba = :idbarcoestibacuba ")
//				.setParameter("idBarcoDes", Integer.valueOf(idbarcoestibacuba))
//				.getResultList();
//	}	
	
	@Override
	public CamaraDetalleBanda CamaraDetalleBandaByID(String id) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CamaraDetalleBanda o "); 
		sb.append("Where o.idcamaradetallebanda = '" + id + "' "); 

		logger.info(BarcoEstibaCuba.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CamaraDetalleBanda) items.get(0);
        }	
	}	
	
	
	
    public List<CamaraDetalleBanda> getBarcosCubasTraladadasParaDescargaPorVolqueta(String id, String idvolqueta) {		
      //System.out.println("Ide barco :"+id);
    	System.out.println("Id :"+id.toString());
    	System.out.println("idvolqueta :"+idvolqueta.toString());

	  //return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.barco.idbarco = '"  + id + "' and b.idbarcocuba = cam.barcoEstibaCuba.idbarcocuba and cam.volqueta.idvolqueta = '"  + idvolqueta + "' and cam.banda.idbanda is null").getResultList();
    	//                       select cam from CamaraDetalleBanda cam WHERE cam.idbarcodescarga = 1 and cam.idvolqueta = 1 and cam.idbanda is null
    	return em.createQuery("select cam from CamaraDetalleBanda cam WHERE cam.barcoDescarga.idbarcodescarga = '"+id+"' and cam.volqueta.idvolqueta = '"+idvolqueta+"' and cam.banda is null").getResultList(); 
	}
    
	@Override
	public void saveOrUpdate(CamaraDetalleBanda camaradetallebanda) 
	{
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(camaradetallebanda);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	
}

