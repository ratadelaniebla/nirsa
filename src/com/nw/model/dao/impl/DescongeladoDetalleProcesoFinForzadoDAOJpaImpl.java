package com.nw.model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProcesoFinForzado;

public class DescongeladoDetalleProcesoFinForzadoDAOJpaImpl extends BaseDaoJpaImpl {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DescongeladoDetalleProcesoFinForzadoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	
	
	//NUEVO 14-04-2016
	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProcesoFinForzado>  getListaDescongeladoDetalleProcesoFinForzadoId(String id) 
	{ 
	 	return em.createQuery("Select o From DescongeladoDetalleProcesoFinForzado o Where o.descongeladoDetalleProceso.iddescongeladodetalleproceso = '" + id + "'").getResultList();		
	}	
	
	
	//NUEVO 14-04-2016
	public void remove(Long vid) 
	{

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					DescongeladoDetalleProcesoFinForzado o = (DescongeladoDetalleProcesoFinForzado) em.find(DescongeladoDetalleProcesoFinForzado.class, vid);
					if (o != null){
						em.remove(o);
						t.commit();
					}
		   	 } finally {
		   		 if (t.isActive()) t.rollback();
		   	 }
		}finally{
			em.close();
		}
	}	 
	
	
	
}
