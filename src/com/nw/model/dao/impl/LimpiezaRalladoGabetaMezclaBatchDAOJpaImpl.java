package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.ControlDetalleBatchRallado;
import com.nw.model.LimpiezaProcesoLoteActivo;
import com.nw.model.LimpiezaRalladoBatchCabecera;
import com.nw.model.LimpiezaRalladoBatchDetalle;
import com.nw.model.LimpiezaRalladoDetallePeso;
import com.nw.model.LimpiezaRalladoGabetaMezclaBatch;
import com.nw.model.LimpiezaRalladoMezclaBatchCabecera;
import com.nw.model.LimpiezaRalladoMezclaBatchDetalle;
import com.nw.model.dao.LimpiezaRalladoDetallePesoDAO;
import com.nw.model.dao.LimpiezaRalladoGabetaMezclaDAO;

public class LimpiezaRalladoGabetaMezclaBatchDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaRalladoGabetaMezclaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaRalladoGabetaMezclaBatchDAOJpaImpl()
    {
      	emf = Persistence.createEntityManagerFactory("NW");
        em = emf.createEntityManager();   
    }

    
    
	@SuppressWarnings("unchecked")
//	public List<LimpiezaRalladoGabetaMezclaBatch> getListaLimpiezaRalladoGabetaMezclaBatchPorProceso(Long idlproceso)
//	{	
//		try {
//			Query query = em.createQuery("select DISTINCT lrgmb from LimpiezaRalladoGabetaMezclaBatch lrgmb " +
//					"where lrgmb.limpiezaRalladoMezclaBatchCabecera.limpiezaRalladoMezclaBatchDetalles." +
//					"limpiezaRalladoBatchCabecera.limpiezaProceso.idlimpiezaproceso=:idlproceso ");
//			 query.setParameter("idlproceso", idlproceso);
//			 
//			return query.getResultList();
//		} catch (Exception e) {		
//			e.printStackTrace();
//			return null;
//		}		
//	}
    
    
					/*
					 select * from limpieza_rallado_mezcla_batch_detalle lrmbd 
					inner join limpieza_rallado_batch_cabecera lrbc 
					on lrmbd.idlimpiezaralladobatchcabecera = lrbc.idlimpiezaralladobatchcabecera
					inner join limpieza_rallado_gabeta_mezcla_batch lrgmb 
					on lrgmb.idlimpiezaralladomezclabatchcabecera = lrmbd.idlimpiezaralladomezclabatchcabecera
					where lrbc.idlimpiezaproceso = 1684	
					 */
					    
	public List<LimpiezaRalladoGabetaMezclaBatch> getListaLimpiezaRalladoGabetaMezclaBatchPorProceso(Long idlproceso)
	{	
		try {
			Query query = em.createQuery("select DISTINCT lrmbd.limpiezaRalladoMezclaBatchCabecera.limpiezaRalladoGabetaMezclaBatches " +
					"from LimpiezaRalladoMezclaBatchDetalle lrmbd " +
					"where lrmbd.limpiezaRalladoBatchCabecera.limpiezaProceso.idlimpiezaproceso=:idlproceso ");
			 query.setParameter("idlproceso", idlproceso);
			 
			return query.getResultList();
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		}		
	}    

	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoMezclaBatchCabecera> ListaBatchMezclasRallado(Long idlproceso)
	{	
		try {
			//LimpiezaDetalleProcesoLote lp = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select DISTINCT lp.limpiezaRalladoMezclaBatchCabecera from LimpiezaRalladoMezclaBatchDetalle lp " +
					"where lp.limpiezaRalladoBatchCabecera.limpiezaProceso.idlimpiezaproceso=:idlproceso and lp.limpiezaRalladoBatchCabecera.estado in (1,2) " +
					"order by lp.limpiezaRalladoMezclaBatchCabecera.fechareg desc ");
			 query.setParameter("idlproceso", idlproceso);
			 
			return query.getResultList();
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		}		
	}
    
	
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoMezclaBatchDetalle> ListaBatchMezclasRalladoDetalle2(Long pidlimpiezaralladomezclabatchcabecera)
	{	
		try {
			//LimpiezaDetalleProcesoLote lp = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select lp from LimpiezaRalladoMezclaBatchDetalle lp " +
					"where lp.limpiezaRalladoMezclaBatchCabecera.idlimpiezaralladomezclabatchcabecera =:pidlimpiezaralladomezclabatchcabecera " +
					"order by lp.limpiezaRalladoMezclaBatchCabecera.fechareg desc  ");
			 query.setParameter("pidlimpiezaralladomezclabatchcabecera", pidlimpiezaralladomezclabatchcabecera);
			 
			return query.getResultList();
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		}		
	}	


	
	@Override
	public void saveOrUpdate(LimpiezaRalladoGabetaMezclaBatch limpiezaRalladoGabetaMezclaBatch) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(limpiezaRalladoGabetaMezclaBatch);
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
