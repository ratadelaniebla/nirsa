package com.nw.model.dao.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoCuba;
//import com.nw.model.BarcoEstibaCuba;
//import com.nw.model.Cajon;
import com.nw.model.CamaraDetalleBanda;
import com.nw.model.Volqueta;
import com.nw.model.dao.VolquetaDAO;

@SuppressWarnings("unchecked")
public class VolquetaDAOJpaImpl extends BaseDaoJpaImpl implements VolquetaDAO {

	private static Log logger = LogFactory.getLog(VolquetaDAOJpaImpl.class);
	
	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public VolquetaDAOJpaImpl() {

   //    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     

	@Override
	public void saveOrUpdate(Volqueta volqueta) 
	{
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(volqueta);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}    
    
	public List<Volqueta> getListVolquetas() {
		return em.createQuery("select vol From Volqueta vol where vol.estadovolqueta = 1 order by vol.descripcionvolqueta")
				.getResultList();
	}
	
	public List<Volqueta> getListVolquetasParaRecepcioDeDescarga(String id) {							 
		return em.createQuery("select distinct(vol) From Volqueta vol, CamaraDetalleBanda cam where cam.barcoDescarga.idbarcodescarga = '"  + id + "' and cam.volqueta.idvolqueta = vol.idvolqueta and vol.estadovolqueta = 2 order by vol.descripcionvolqueta")
				.getResultList();
	}

	public List<Volqueta> getListVolquetasParaRecepcioDeDescargaSinBanda(String id) {							 
		return em.createQuery("select distinct(vol) From Volqueta vol, CamaraDetalleBanda cam where cam.barcoDescarga.idbarcodescarga = '"  + id + "' and cam.volqueta.idvolqueta = vol.idvolqueta and vol.estadovolqueta = 2 and cam.banda.idbanda is null order by vol.descripcionvolqueta")
				.getResultList();
	}
	
    public List<BarcoCuba> getBarcosCubasAprobadasParaDescarga(Integer id) {
		return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and  bec.estadodescargacuba = 1").getResultList();
	}
	

	public List<CamaraDetalleBanda> getTotalVolquetedasPorBarcoDescarga(String id, String idvolqueta) {							 
		return em.createQuery("select cam From CamaraDetalleBanda cam where cam.barcoDescarga.idbarcodescarga = '"  + id + "' and cam.volqueta.idvolqueta = '"  + idvolqueta + "' and cam.banda.idbanda is not null order by cam.viaje")
				.getResultList();
	}    
    
	public List<CamaraDetalleBanda> getTotalVolquetedasPorBarcoDescargaPorllagar(String id, String idvolqueta) {							 
		return em.createQuery("select cam From CamaraDetalleBanda cam where cam.barcoDescarga.idbarcodescarga = '"  + id + "' and cam.volqueta.idvolqueta = '"  + idvolqueta + "' order by cam.viaje")
				.getResultList();
	}    
    	
   
}

