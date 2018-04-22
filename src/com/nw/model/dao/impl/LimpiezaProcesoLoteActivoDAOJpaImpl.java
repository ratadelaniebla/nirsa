package com.nw.model.dao.impl;

 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.Cajon;
//import com.nw.model.CamaraCajon;
import com.nw.model.LimpiezaProcesoLoteActivo;
//import com.nw.model.dao.CajonDAO;
import com.nw.model.dao.LimpiezaProcesoLoteActivoDAO;



@SuppressWarnings("unchecked")
public class LimpiezaProcesoLoteActivoDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaProcesoLoteActivoDAO 
{

	@SuppressWarnings("unused")
	private static Log logger = LogFactory.getLog(LimpiezaProcesoLoteActivoDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public LimpiezaProcesoLoteActivoDAOJpaImpl() 
    {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
    
  
	@SuppressWarnings("rawtypes")
	public LimpiezaProcesoLoteActivo getUltimoLoteActivoPorProcesoLinea(String idp, String idl) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaProcesoLoteActivo o "); 
		sb.append("Where o.limpiezaProceso.idlimpiezaproceso = '" + idp.trim() + "' ");
		sb.append("and o.limpiezaLinea.idlimpiezalinea = '" + idl.trim() + "' ");
		sb.append("order by o.idlimpiezaprocesoloteactivo desc ");
		
		List items;
		
		try {
			items =  em.createQuery(sb.toString()).getResultList().subList(0,1);
		} catch (Exception e) 
		{
			//e.printStackTrace();
			// TODO Auto-generated catch block
			return null;
		}

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaProcesoLoteActivo) items.get(0);
        }		
	}   

	
	
	
	
	@SuppressWarnings("rawtypes")
	public LimpiezaProcesoLoteActivo getVeliridarLoteActivoPorProcesoLineaLote(String idp, String idl, String idlo) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaProcesoLoteActivo o "); 
		sb.append("Where o.limpiezaProceso.idlimpiezaproceso = '" + idp.trim() + "' ");
		sb.append("and o.limpiezaLinea.idlimpiezalinea = '" + idl.trim() + "' ");
		sb.append("and o produccionDetalleLote.idproducciondetallelote = '" + idlo.trim() + "' ");
		
		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaProcesoLoteActivo) items.get(0);
        }		
	}   
	

	
	@SuppressWarnings("rawtypes")
	public LimpiezaProcesoLoteActivo getVeliridarLoteActivoIngresadoaLinea(String idp, String idl, String idlo) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaProcesoLoteActivo o "); 
		sb.append("Where o.limpiezaProceso.idlimpiezaproceso = '" + idp.trim() + "' ");
		sb.append("and o.limpiezaLinea.idlimpiezalinea = '" + idl.trim() + "' ");
		sb.append("and o.limpiezaDetalleProcesoLote.produccionDetalleLote.idlote = '" + idlo.trim() + "' ");
		
		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaProcesoLoteActivo) items.get(0);
        }		
	}	
	
	
	
	/* 26-09-2017  Obtiene el lote por defecto */
	public LimpiezaProcesoLoteActivo getLotePorDefectoActivo(long idlimpiezaproceso, long idlimpiezalinea) 
	{ 
		StringBuffer sb = new StringBuffer();
		List<LimpiezaProcesoLoteActivo> items = new ArrayList<>();
		LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo = new LimpiezaProcesoLoteActivo();
		
		try { 
			sb.append("Select o "); 
			sb.append("From LimpiezaProcesoLoteActivo o , LimpiezaDetalleProcesoLote ldpl   "); 
			sb.append(" Where ldpl.idlimpiezadetalleprocesolote = o.limpiezaDetalleProcesoLote.idlimpiezadetalleprocesolote " +
					  "   and o.limpiezaProceso.idlimpiezaproceso =:idlimpiezaproceso  ");
			sb.append("and o.limpiezaLinea.idlimpiezalinea =:idlimpiezalinea   ");
			sb.append("order by o.idlimpiezaprocesoloteactivo desc  ");// LIMIT 1
			 
			items = em.createQuery(sb.toString())
					.setParameter("idlimpiezaproceso", idlimpiezaproceso)
					.setParameter("idlimpiezalinea", idlimpiezalinea)
					.getResultList();
			
	        if (items == null || items.isEmpty()) {
	        	limpiezaProcesoLoteActivo = null;
	        } else {
	        	limpiezaProcesoLoteActivo =  items.get(0);
	        }	
	        
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return null;
		}
		return limpiezaProcesoLoteActivo;   
	}   
	
	public List< LimpiezaProcesoLoteActivo> getListaLotesActivosByLinea(long idlimpiezaproceso, long idlimpiezalinea) 
	{ 
		StringBuffer sb = new StringBuffer();
		List<LimpiezaProcesoLoteActivo> items = new ArrayList<>();
		try { 
			sb.append("Select o "); 
			sb.append("From LimpiezaProcesoLoteActivo o , LimpiezaDetalleProcesoLote ldpl   "); 
			sb.append(" Where ldpl.idlimpiezadetalleprocesolote = o.limpiezaDetalleProcesoLote.idlimpiezadetalleprocesolote " +
					  "   and o.limpiezaProceso.idlimpiezaproceso =:idlimpiezaproceso  ");
			sb.append("and o.limpiezaLinea.idlimpiezalinea =:idlimpiezalinea   ");
			sb.append("order by o.idlimpiezaprocesoloteactivo desc  ");// LIMIT 1
			 
			items = em.createQuery(sb.toString())
					.setParameter("idlimpiezaproceso", idlimpiezaproceso)
					.setParameter("idlimpiezalinea", idlimpiezalinea)
					.getResultList();
	        
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return items;
		}
		return items;   
	} 
	
	
	public List<LimpiezaProcesoLoteActivo> getLotesByProducccionAndTurno(long idproduccion, int idturno) 
	{ 
		StringBuffer sb = new StringBuffer();
		List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos = new ArrayList<>();
		
		try { 
			sb.append("Select lpla "); 
			sb.append("From LimpiezaProcesoLoteActivo lpla , LimpiezaDetalleProcesoLote ldpl , ProduccionDetalleLote pdl  "); 
			sb.append(" Where ldpl.idlimpiezadetalleprocesolote = lpla.limpiezaDetalleProcesoLote.idlimpiezadetalleprocesolote " +
					  "   and ldpl.produccionDetalleLote.idproducciondetallelote = pdl.idproducciondetallelote " +
					  "   and pdl.produccion.idproduccion =:idpro  ");
			sb.append("   and pdl.turno.idturno           =:idlimpiezalinea   ");
			sb.append(" order by lpla.idlimpiezaprocesoloteactivo desc  "); 
			 
			limpiezaProcesoLoteActivos = em.createQuery(sb.toString())
					.setParameter("idpro", idproduccion)
					.setParameter("idlimpiezalinea", idturno)
					.getResultList();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	   
	  return limpiezaProcesoLoteActivos;   
	}   
	
	
	public List<LimpiezaProcesoLoteActivo> getLotesByProducccionAndTurnoAndLinea(long idproduccion, int idturno , int idlinea) 
	{ 
		StringBuffer sb = new StringBuffer();
		List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos = new ArrayList<>();
		
		try { 
			sb.append("Select lpla "); 
			sb.append("From LimpiezaProcesoLoteActivo lpla , LimpiezaDetalleProcesoLote ldpl , ProduccionDetalleLote pdl  "); 
			sb.append(" Where ldpl.idlimpiezadetalleprocesolote = lpla.limpiezaDetalleProcesoLote.idlimpiezadetalleprocesolote " +
					  "   and ldpl.produccionDetalleLote.idproducciondetallelote = pdl.idproducciondetallelote " +
					  "   and pdl.produccion.idproduccion            =:idpro  ");
			sb.append("   and pdl.turno.idturno                      =:idturno   ");
			sb.append("   and lpla.limpiezaLinea.idlimpiezalinea     =:idlinea  ");
			sb.append(" order by lpla.idlimpiezaprocesoloteactivo desc  "); 
			 
			limpiezaProcesoLoteActivos = em.createQuery(sb.toString())
					.setParameter("idpro", idproduccion)
					.setParameter("idturno", idturno)
					.setParameter("idlinea", idlinea)
					.getResultList();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	   
	  return limpiezaProcesoLoteActivos;   
	}  
	
	
	
	public LimpiezaProcesoLoteActivo getVeliridarLoteActivoPorProcesoLineaLotesssss(String idp, String idl, String idlo) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		List<LimpiezaProcesoLoteActivo> items = new ArrayList<>();
		LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo = new LimpiezaProcesoLoteActivo();
		try { 
			sb.append("Select o "); 
			sb.append("From LimpiezaProcesoLoteActivo o "); 
			sb.append("Where o.limpiezaProceso.idlimpiezaproceso = '" + idp.trim() + "' ");
			sb.append("and o.limpiezaLinea.idlimpiezalinea = '" + idl.trim() + "' ");
			sb.append("and o produccionDetalleLote.idproducciondetallelote = '" + idlo.trim() + "' ");
			
			 items =  em.createQuery(sb.toString()).getResultList();
	
	        if (items == null || items.isEmpty()) {
	        	limpiezaProcesoLoteActivo = null;
	        } else {
	        	limpiezaProcesoLoteActivo =  items.get(0);
	        }	
	        
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return null;
		}
		return limpiezaProcesoLoteActivo;   
	}   
	
	
	
	
	@Override
	public void saveOrUpdate(LimpiezaProcesoLoteActivo limpiezaprocesoloteactivo) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(limpiezaprocesoloteactivo);
	 			        t.commit();
   		  } finally {
   		    if (t.isActive()) t.rollback();
   		  }
			}finally{
				em.close();
				//emf.close();
			}
		
	}	
	

	
}