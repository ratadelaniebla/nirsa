package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CajonDetalleBarcoDescarga;
import com.nw.model.dao.CamaraRegistroCajonBarcoDescargaDAO;
/*import com.wm.model.MedioPeriodo;
import com.wm.model.MedioPeriodoPK;
import com.wm.model.dao.MedioPeriodoDAO;*/


@SuppressWarnings("unchecked")
public class CamaraRegistroCajonBarcoDescargaDAOJpaImpl extends BaseDaoJpaImpl implements CamaraRegistroCajonBarcoDescargaDAO {

	private static Log logger = LogFactory.getLog(CamaraRegistroCajonBarcoDescargaDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public CamaraRegistroCajonBarcoDescargaDAOJpaImpl() {

   //    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
    public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargabyId(String id) {
		return em.createQuery("select c from CajonDetalleBarcoDescarga c WHERE c.idcajondetallebarcodescarga = '"  + id + "' ").getResultList();
	}	


    //Solo Cajones Normales (1= "Sin revolteo")
	@Override
	public List<CajonDetalleBarcoDescarga> getListCajonDetalleBarcoDescargaByIdBarcoDescarga(String idBarcoDescarga, String idBanda) {
		return em.createQuery("Select cdbd From Banda b, CajonDetalleBarcoDescarga cdbd where b.idbanda = cdbd.banda.idbanda and cdbd.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' and cdbd.banda.idbanda = '" + idBanda + "' and cdbd.estadorevolteo = 1").getResultList();
	}
    
    
    
	@Override
	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescargaByIdBarcoDescargaIdBanda(String idBarcoDescarga, String idBanda, String Idcajon) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select cdbd From Banda b, CajonDetalleBarcoDescarga cdbd "); 
		sb.append("where b.idbanda = cdbd.banda.idbanda and cdbd.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 
		sb.append("and cdbd.banda.idbanda = '" + idBanda + "' and cdbd.cajon.idcajon = '" + Idcajon + "' ");
		
		logger.info(CajonDetalleBarcoDescarga.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CajonDetalleBarcoDescarga) items.get(0);
        }	
	}

	
	
	//Cajon Para Listo para Revolteo
	@Override
	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescargaByIdBarcoDescargaIdCajon(String idBarcoDescarga, String Idcajon) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select cdbd From Banda b, CajonDetalleBarcoDescarga cdbd "); 
		sb.append("where b.idbanda = cdbd.banda.idbanda and cdbd.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 
		sb.append("and cdbd.cajon.idcajon = '" + Idcajon + "' and cdbd.estadorevolteo = 2");

		logger.info(CajonDetalleBarcoDescarga.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CajonDetalleBarcoDescarga) items.get(0);
        }	
	}	
	
	@Override
	public CajonDetalleBarcoDescarga getBuscarCajonAsignadoBandaByIdBarcoDescargaIdBandaIdCajon(String idBarcoDescarga, String idBanda, String idCajon) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select cdbd From Banda b, CajonDetalleBarcoDescarga cdbd "); 
		sb.append("where b.idbanda = cdbd.banda.idbanda and cdbd.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 
		sb.append("and cdbd.banda.idbanda = '" + idBanda + "' ");
		sb.append("and cdbd.cajon.idcajon = '" + idCajon + "' ");
		
		logger.info(CajonDetalleBarcoDescarga.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CajonDetalleBarcoDescarga) items.get(0);
        }	
	}	

	
	//Buscamos Cajon con esta de posibilidad de ser localizado (1="Cajon sin revolteo", 2="Cajon con revolteo")
	@Override
	public CajonDetalleBarcoDescarga getBuscarCajonAsignadoBandaByIdBarcoDescargaIdCajon(String idBarcoDescarga, String idCajon) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select cdbd From Banda b, CajonDetalleBarcoDescarga cdbd "); 
		sb.append("where b.idbanda = cdbd.banda.idbanda and cdbd.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 
		sb.append("and cdbd.cajon.idcajon = '" + idCajon + "' and cdbd.estadorevolteo in (1,2) ");
		
		logger.info(CajonDetalleBarcoDescarga.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CajonDetalleBarcoDescarga) items.get(0);
        }	
	}	

	
    //Solo Cajones Normales (1= "Sin revolteo")
//	@Override
//	public List<CajonDetalleBarcoDescarga> getListCajonDetalleBarcoDescargaByIdBarcoDescargaIdBandaIdCajon(String idBarcoDescarga, String idBanda, String idCajon) {
//		return em.createQuery("Select cdbd From Banda b, CajonDetalleBarcoDescarga cdbd where b.idbanda = cdbd.banda.idbanda and cdbd.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' and cdbd.banda.idbanda = '" + idBanda + "' and cdbd.cajon.idcajon = '" + idCajon + "' and cdbd.numeromuestreo > 0 and cdbd.estadorevolteo = 1").getResultList();
//	}
	
    //Solo Cajones Normales (1= "Sin revolteo")
	@Override
	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescargaDisponibleByIdBarcoDescargaIdCajon(String idBarcoDescarga, String idBanda, String idCajon) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select cdbd From Banda b, CajonDetalleBarcoDescarga cdbd "); 
		sb.append("where b.idbanda = cdbd.banda.idbanda and cdbd.barcoDescarga.idbarcodescarga = '" + idBarcoDescarga + "' "); 
		sb.append("and cdbd.banda.idbanda = '" + idBanda + "' ");
		sb.append("and cdbd.cajon.idcajon = '" + idCajon + "' ");
		
		logger.info(CajonDetalleBarcoDescarga.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CajonDetalleBarcoDescarga) items.get(0);
        }	
	}
	
	
	@Override
	public void saveOrUpdate(CajonDetalleBarcoDescarga cajondetallebarcodescarga) 
	{
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cajondetallebarcodescarga);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	
}

