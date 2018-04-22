package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.BarcoCuba;
//import com.nw.model.BarcoDescarga;
//import com.nw.model.CalidadBpmDesembarco;
import com.nw.model.DesperdicioCajonHarina;
//import com.nw.model.DesperdicioDetalle;
//import com.nw.model.Turno;
//import com.nw.model.dao.BarcoDescargaDAO;
import com.nw.model.dao.DesperdicioCajonHarinaDAO;
//import com.nw.model.dao.TurnoDAO;

@SuppressWarnings("unchecked")
public class DesperdicioCajonHarinaDAOJpaImpl extends BaseDaoJpaImpl implements DesperdicioCajonHarinaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public DesperdicioCajonHarinaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public DesperdicioCajonHarina getFindDesperdicioCajonHarinaId(Integer vid) {
		return em.find(DesperdicioCajonHarina.class, vid);	
	}	    
 

	public List<DesperdicioCajonHarina> getCajonesDesperdicioDetalleLimite(Integer diajuliano) {
		return em.createQuery("select dch from DesperdicioCajonHarina dch, Cajon c where dch.diajuliano = :vdiajuliano and dch.cajon.idcajon = c.idcajon and c.estadocajon = 2 and dch.fechaselladodesperdicio is null order by c.idcajon")
				.setParameter("vdiajuliano",diajuliano)
				.setMaxResults(24)
				.getResultList();
	}
	
	
	public List<DesperdicioCajonHarina> getCajonesDesperdicioDetalle(Integer diajuliano) {
		return em.createQuery("select dch from DesperdicioCajonHarina dch, Cajon c where dch.diajuliano = :vdiajuliano and dch.cajon.idcajon = c.idcajon and c.estadocajon = 2 and dch.fechaselladodesperdicio is null and dch.fechaselladoharina is null and (dch.pesoharina = 0 or dch.pesoharina is null) order by c.idcajon")
				.setParameter("vdiajuliano",diajuliano)
				.getResultList();
	}

	

	public List<DesperdicioCajonHarina> getCajonesRecepcionHarina(Integer diajuliano) {
		return em.createQuery("select dch from DesperdicioCajonHarina dch, Cajon c where dch.diajuliano = :vdiajuliano and dch.area is null  and dch.cajon.idcajon = c.idcajon and c.estadocajon = 3 and dch.fechaselladoharina is null order by c.idcajon")
				.setParameter("vdiajuliano",diajuliano)
				.getResultList();
	}

	
	public DesperdicioCajonHarina getFechadeProduccionActiva() 
	{ 		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From DesperdicioCajonHarina o "); 
		sb.append("Where o.area is null and o.sello1desperdicio is not null and o.sello1harina is null order by o.fechaproduccion");		
		
		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (DesperdicioCajonHarina) items.get(0);
        }		
	}

	
	public DesperdicioCajonHarina getFechadeProduccionActivaDesperdicio() 
	{ 		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From DesperdicioCajonHarina o "); 
		sb.append("Where o.area is null and o.sello1desperdicio is null and o.sello1harina is null order by o.fechaproduccion");

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (DesperdicioCajonHarina) items.get(0);
        }		
	}	
	

	public DesperdicioCajonHarina getDesperdicioCajonHarinaId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From DesperdicioCajonHarina o "); 
		sb.append("Where o.iddesperdiciocajonharina = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (DesperdicioCajonHarina) items.get(0);
        }		
	}	
	


	@Override
	public void saveOrUpdate(DesperdicioCajonHarina desperdicioch) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(desperdicioch);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	
}
