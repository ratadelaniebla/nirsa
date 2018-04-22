package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoRackeoLote;
import com.nw.model.dao.EvisceradoRackeoLoteDAO;

public class EvisceradoRackeoLoteDAOJpaImpl extends BaseDaoJpaImpl implements EvisceradoRackeoLoteDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EvisceradoRackeoLoteDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	

	//@Override
	public EvisceradoRackeoLote getEvisceradoDetalleProcesoIdidproducciondetallelotecajon(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From EvisceradoRackeoLote o "); 
		sb.append("Where o.produccionDetalleLoteCajon.idproducciondetallelotecajon = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (EvisceradoRackeoLote) items.get(0);
	    }		
	}
	

	public List<EvisceradoRackeoLote> getLotesAperturados(Long idprod, Integer idturn)
	{
		try {
			
//			edp.evisceradoProceso.procesoAperturaCierre.estado = 1
			List<EvisceradoRackeoLote> edp = new ArrayList<EvisceradoRackeoLote>();
			//and edp.evisceradoProceso.produccion.idproduccion = :idproduc
			Query query = em.createQuery("select edp from EvisceradoRackeoLote edp " +
					"where edp.estado = 1 and " +
					"edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idtur ");
			
			query.setParameter("idtur", idturn);
			
			edp = (List<EvisceradoRackeoLote>) query.getResultList();

			return edp;		
			
		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;		
		}
	}
	

	public void guardarEvisceradoRackeoLote(EvisceradoRackeoLote evisceradoRackeoLote)
	{
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(evisceradoRackeoLote);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	
	
	@Override
	public void saveOrUpdate(EvisceradoRackeoLote evisceradoRackeoLote) {
		// TODO Auto-generated method stub
		
	}


	 
	 
}
