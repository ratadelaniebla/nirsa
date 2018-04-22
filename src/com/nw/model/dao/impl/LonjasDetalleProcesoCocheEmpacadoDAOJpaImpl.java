package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasDetalleProcesoCocheEmpacado;

public class LonjasDetalleProcesoCocheEmpacadoDAOJpaImpl {

	public LonjasDetalleProcesoCocheEmpacadoDAOJpaImpl() {
		 
	}
	
	public LonjasDetalleProcesoCocheEmpacado saveOrUpdate(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		LonjasDetalleProcesoCocheEmpacado LonjasDetalleProcesoCocheEmpacadoDevuelto = null;
		try {
			t.begin();
			LonjasDetalleProcesoCocheEmpacadoDevuelto = em.merge(lonjasDetalleProcesoCocheEmpacado);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return LonjasDetalleProcesoCocheEmpacadoDevuelto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasDetalleProcesoCocheEmpacado> getListaLonjasDetalleProcesoCocheEmpacadoByOrdenFabricacionAndEstado(long idordenfabriacion, int estado) 
	{
		List<LonjasDetalleProcesoCocheEmpacado> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
		 
		 Query qry  = em.createQuery("select ep from LonjasDetalleProcesoCocheEmpacado ep " +
				" where ep.lonjasOrdenProduccion.idlonjasordenproduccion = :idorden  and ep.estado = :estad " +
				" order by  ep.idlonjasdetalleprocesococheempacado desc ");
		
		 qry.setParameter("idorden",  idordenfabriacion );
		 qry.setParameter("estad",    estado );
		  
		 lista = qry.getResultList();
		 em.close();
		return lista;
			 
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasDetalleProcesoCocheEmpacado> getListaLonjasDetalleProcesoCocheEmpacadoByOrdenFabricacion(long idordenfabriacion ) 
	{
		List<LonjasDetalleProcesoCocheEmpacado> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		 Query qry  = em.createQuery("select ep from LonjasDetalleProcesoCocheEmpacado ep " +
				" where ep.lonjasOrdenProduccion.idlonjasordenproduccion = :idorden " +
				" order by  ep.idlonjasdetalleprocesococheempacado desc ");
		
		 qry.setParameter("idorden",  idordenfabriacion );
		  
		 lista = qry.getResultList();
		 em.close();
		return lista;
	}
	
}
