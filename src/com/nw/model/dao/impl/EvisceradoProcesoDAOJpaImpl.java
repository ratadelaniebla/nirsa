package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoProceso;
/*import com.nw.model.LimpiezaProceso;*/
import com.nw.model.dao.EvisceradoProcesoDAO;

public class EvisceradoProcesoDAOJpaImpl extends BaseDaoJpaImpl implements EvisceradoProcesoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EvisceradoProcesoDAOJpaImpl(){
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EvisceradoProceso> getEvisceradoProceso(double idprocesoAperturaCierre) {
		System.out.println("Entro al metodo getevisceradoproceso");
		Query qry  = em.createQuery("select ep from EvisceradoProceso ep " +
				"inner join ep.procesoAperturaCierre pac " +
				"where pac.idprocesoaperturacierre = :idpac ");
		
		System.out.println("el idproceso dentro --> " + idprocesoAperturaCierre);
		
		qry.setParameter("idpac", idprocesoAperturaCierre);
		
		List <EvisceradoProceso> evisceradoProceso = qry.getResultList();
		
		System.out.println("contar " + evisceradoProceso.size());
		
		return evisceradoProceso;
		
	}
public EvisceradoProceso obtenerEvisceradoPac(){
		
		try {
			EvisceradoProceso lp = new EvisceradoProceso();
/*			Query query = em.createQuery("select lp from EvisceradoProceso lp , ProcesoAperturaCierre pac  " +*/
			Query query = em.createQuery("select lp from EvisceradoProceso lp " +
/*					"where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");*/
					"where lp.procesoAperturaCierre.estado = 1 ");
			lp = (EvisceradoProceso) query.getSingleResult();
			return lp;
		} catch (Exception e) {
			
			return null;
		}
		
	}	
	public EvisceradoProceso getEvisceradoProcesoIdProduccion(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From EvisceradoProceso o "); 
		sb.append("Where o.produccion.idproduccion = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (EvisceradoProceso) items.get(0);
	    }		
	}	
	
	
	
	public EvisceradoProceso obtenerEvisceradoProceso(Long idprocesoAperturaCierre) {
		EvisceradoProceso ep = new EvisceradoProceso();
		  EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		  EntityManager em = emf.createEntityManager();
	
		Query qry  = em.createQuery("select ep from EvisceradoProceso ep " +
				" inner join ep.procesoAperturaCierre pac " +
				" where pac.idprocesoaperturacierre =:idpac  ");
		  
//		  Query qry = em.createNativeQuery("select * from eviscerado_proceso " +
//		  		"inner join proceso_apertura_cierre" +
//		  		" on eviscerado_proceso.idprocesoaperturacierre = proceso_apertura_cierre.idprocesoaperturacierre" +
//		  		" where proceso_apertura_cierre.idprocesoaperturacierre = 4 ");
		
		
		qry.setParameter("idpac", idprocesoAperturaCierre);
		ep = (EvisceradoProceso) qry.getSingleResult();
		System.out.println("EvisceradoProceso obteeenido " + ep.getIdevisceradoproceso());
		
		return ep;
		
	}
	
	public EvisceradoProceso getEvisceradoProcesoIdProduccion(Long id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From EvisceradoProceso o "); 
		sb.append("Where o.produccion.idproduccion = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (EvisceradoProceso) items.get(0);
	    }		
	}	
	
	
	public void guardarevisceradoProceso(EvisceradoProceso evisceradoProceso){
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(evisceradoProceso);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	
	public EvisceradoProceso obtenerEvisceradoPacActivo(){
	      
	      try {
	            EvisceradoProceso lp = new EvisceradoProceso();
	/*                Query query = em.createQuery("select lp from EvisceradoProceso lp , ProcesoAperturaCierre pac  " +*/
	            Query query = em.createQuery("select lp from EvisceradoProceso lp " +
	/*                            "where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");*/
	                        "where lp.procesoAperturaCierre.estado = 1 order by lp.idevisceradoproceso desc ");
	            lp = (EvisceradoProceso) query.getResultList().get(0);
	            return lp;
	      } catch (Exception e) {
	            
	            return null;
	      }
	      
	}     
	
	
	@Override
	public void saveorUpdate(EvisceradoProceso evisceradoProceso) {
		// TODO Auto-generated method stub
		
	}
	

}
