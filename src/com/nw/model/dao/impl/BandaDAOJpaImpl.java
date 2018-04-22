package com.nw.model.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Banda;

import com.nw.model.dao.BandaDAO;

@SuppressWarnings("unchecked")
public class BandaDAOJpaImpl extends BaseDaoJpaImpl implements BandaDAO {

	private static Log logger = LogFactory.getLog(BandaDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public BandaDAOJpaImpl() {

   //   emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }


		
	//@Override
	public List<Banda> getListBandasOrigen(String idBarcoDescarga) {
		Query query = em.createQuery("Select distinct(b) From Banda b, CajonDetalleBarcoDescarga cdbd " +
				"where b.idbanda = cdbd.banda.idbanda and " +
				"cdbd.barcoDescarga.idbarcodescarga = :idBarcoDescarga and cdbd.estadorevolteo = 1 order by b.descripcionbanda");
		query.setParameter("idBarcoDescarga", Integer.valueOf(idBarcoDescarga));
	
		return query.getResultList();
	} 		
		

	
		
	public List<Banda> getListBandas() {					  	                    
		return em.createQuery("select b From Banda b order by b.descripcionbanda")
				.getResultList();
	}
	
}