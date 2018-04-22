package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.BarcoEstibaCubaDetalleMezcla;
import com.nw.model.dao.BarcoEstibaCubaDAO;

@SuppressWarnings("unchecked")
public class BarcoEstibaCubaDAOJpaImpl extends BaseDaoJpaImpl implements BarcoEstibaCubaDAO {

	private static Log logger = LogFactory.getLog(BarcoEstibaCubaDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public BarcoEstibaCubaDAOJpaImpl() {

   //    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	@Override
	public BarcoEstibaCuba BarcoEstibaCubaJpaImpl() {
		return new BarcoEstibaCuba();
	} 
	
	public BarcoEstibaCuba getFindBarcoEstibaCubabyId(Integer vid) {
		return em.find(BarcoEstibaCuba.class, vid);	
	}	

	@Override
	public BarcoEstibaCuba getBarcoEstibaCubaByIdBarcoDescarga(String idBarcoDescarga) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From BarcoEstibaCuba o "); 
		sb.append("Where o.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 

		logger.info(BarcoEstibaCuba.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (BarcoEstibaCuba) items.get(0);
        }	
	}


	@Override
	public BarcoEstibaCuba getBarcoEstibaCubaByIdBarcoDescargaIdBarcoCuba(String idBarcoDescarga, String idBarcoCuba) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From BarcoEstibaCuba o "); 
		sb.append("Where o.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' and o.idbarcocuba = '" + idBarcoCuba + "' and o.estadodescargacuba = 1 "); 

		logger.info(BarcoEstibaCuba.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (BarcoEstibaCuba) items.get(0);
        }	
	}


	//Cubas aprobadas(1) o en proceso de descarga(2)
	@Override
	public BarcoEstibaCuba getBarcoEstibaCubaByIdBarcoDescargaIdBarcoCubaEstado(String idBarcoDescarga, String idBarcoCuba) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From BarcoEstibaCuba o "); 
		sb.append("Where o.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' and o.idbarcocuba = '" + idBarcoCuba + "' and o.estadodescargacuba in (1,2) "); 

		logger.info(BarcoEstibaCuba.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (BarcoEstibaCuba) items.get(0);
        }	
	}	

	@Override
	public BarcoEstibaCuba BuscarEstibaCubaByIdBarcoEstibaCuba(String IdBarcoEstibaCuba) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From BarcoEstibaCuba o "); 
		sb.append("Where o.idbarcoestibacuba = '" + IdBarcoEstibaCuba + "' "); 

		logger.info(BarcoEstibaCuba.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (BarcoEstibaCuba) items.get(0);
        }	
	}	
	
	
	@Override
	public void saveOrUpdate(BarcoEstibaCuba barcoestibacuba) 
	{
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(barcoestibacuba);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	

	
		
	@Override
	public BarcoEstibaCuba getBarcoEstibaCubaById(Long idbarcoestibacuba) {
		return em.find(BarcoEstibaCuba.class, idbarcoestibacuba); 
    	
    }
    
	public List<BarcoEstibaCuba> getListBarcoEstibaCubaByIdBarcoDescarga(String idBarcoDescarga) {
		return em.createQuery("select bec From BarcoEstibaCuba bec where bec.barcoDescarga.idbarcodescarga = :idBarcoDes and bec.estadodescargacuba = 0 order by bec.idbarcoestibacuba")
				.setParameter("idBarcoDes", Integer.valueOf(idBarcoDescarga))
				.getResultList();
	}

	
	public List<BarcoEstibaCuba> getListBarcoEstibaCubaTodas(String idBarcoDescarga) {
		return em.createQuery("select bec From BarcoEstibaCuba bec where bec.barcoDescarga.idbarcodescarga = :idBarcoDes and bec.estadodescargacuba in (0,1) order by bec.idbarcoestibacuba")
				.setParameter("idBarcoDes", Integer.valueOf(idBarcoDescarga))
				.getResultList();
	}	

	//Lista solo de cubas Aprobadas
	public List<BarcoEstibaCuba> getListBarcoEstibaCubasAprobadasByIdBarcoDescarga(String idBarcoDescarga) {
		return em.createQuery("select bec From BarcoEstibaCuba bec where bec.barcoDescarga.idbarcodescarga = :idBarcoDes and bec.estadodescargacuba = 1 order by bec.idbarcoestibacuba")
				.setParameter("idBarcoDes", Integer.valueOf(idBarcoDescarga))
				.getResultList();
	}	

	
	public List<BarcoEstibaCuba> getListBarcoEstibaCubaByIdBarcoDescargaEstado(String idBarcoDescarga) {
		return em.createQuery("select bec From BarcoEstibaCuba bec where bec.barcoDescarga.idbarcodescarga = :idBarcoDes and bec.estadodescargacuba = 0  order by bec.idbarcoestibacuba")
				.setParameter("idBarcoDes", Integer.valueOf(idBarcoDescarga))
				.getResultList();
	}	


	public List<BarcoEstibaCuba> getTotalVolquetadasBarco(String idBarcoDescarga) {
		return em.createQuery("select bec From BarcoEstibaCuba bec where bec.barcoDescarga.idbarcodescarga = :idBarcoDes and bec.volqueta.idvolqueta > 0")
				.setParameter("idBarcoDes", Integer.valueOf(idBarcoDescarga))
				.getResultList();
	}	

	public List<BarcoEstibaCuba> getBarcoEstivaporBD(Long idBarcoDescarga){
		List<BarcoEstibaCuba> cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoEstibaCuba b where b.barcoDescarga.idbarcodescarga = :idBarcoDes order by b.idbarcoestibacuba");
    		qry.setParameter("idBarcoDes", idBarcoDescarga);
    		
    		cuba = qry.getResultList(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }	

/* Requerimiento Mezcla Cubas*/
	@SuppressWarnings("unchecked")
	public List<BarcoEstibaCubaDetalleMezcla> getListBarcoEstibaCubasDetalleMezcaxIdCamaraCajon(Long idCamaraCajon) {
		List<BarcoEstibaCubaDetalleMezcla> cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoEstibaCubaDetalleMezcla b where " +
    				"b.camaraCajon.idcamaracajon = :idCamaraCaj " +
    				"order by b.idbarcoestibacubadetallemezcla");
    		qry.setParameter("idCamaraCaj", idCamaraCajon);
    		cuba = qry.getResultList(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

    }	
	

/* Mezcla Cubas*/
	@SuppressWarnings("unchecked")
	public List<BarcoEstibaCubaDetalleMezcla> getListMezclaCubasCajonesxLote(Long idProduccionDetalleLote) {
		List<BarcoEstibaCubaDetalleMezcla> cuba;
    	try {
    		Query qry = em.createQuery(" select distinct (bec) from BarcoEstibaCubaDetalleMezcla b, BarcoEstibaCuba bec " +
    				"where b.barcoEstibaCuba.idbarcoestibacuba = bec.idbarcoestibacuba" +
    				"b.camaraCajon in " +
    				"(select cc from ProduccionDetalleLoteCajon pdlc, ProduccionDetalleLote pdl, CamaraCajon cc " +
    				"where pdlc.produccionDetalleLote.idproducciondetallelote = pdl.idproducciondetallelote " +
    				"and pdlc.camaraCajon.idcamaracajon = cc.idcamaracajon " +
    				"and pdl.idproducciondetallelote = :idProdDetLote) ");
    		qry.setParameter("idProdDetLote", idProduccionDetalleLote);
    		cuba = qry.getResultList(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

    }	

	
	
	public void saveOrUpdateBarcoEstivaCuba(List<BarcoEstibaCuba> barcoEstibaCuba) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 
			 
			for (BarcoEstibaCuba bec : barcoEstibaCuba) {
				t.begin();
					em.merge(bec);
				t.commit();
			}
			

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	public int delete(BarcoEstibaCuba  barcoEstibaCuba) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 int r= 0;
		Long id = barcoEstibaCuba.getIdbarcoestibacuba();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from BarcoEstibaCuba where idbarcoestibacuba = :idbc");
			 query.setParameter("idbc", id);
			 query.executeUpdate();
		 	 t.commit();
		 	 r = 0;
			 
		} catch (RuntimeException e) {   
			if (t.isActive()) {
				t.rollback();
			}
		    
			r = 1;
		} finally {
			em.close();
		}
		return r;
 
}  	
	
}

