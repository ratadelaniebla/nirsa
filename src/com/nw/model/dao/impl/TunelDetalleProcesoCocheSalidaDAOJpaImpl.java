package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.TunelDetalleProcesoCocheSalida;

public class TunelDetalleProcesoCocheSalidaDAOJpaImpl {

	public TunelDetalleProcesoCocheSalidaDAOJpaImpl() {
	}
	
	public TunelDetalleProcesoCocheSalida saveOrUpdate(TunelDetalleProcesoCocheSalida TunelDetalleProcesoCoche) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction    t    = em.getTransaction();
		TunelDetalleProcesoCocheSalida TunelDetalleProcesoCocheDevuelto = null;
		try {
			t.begin();
			TunelDetalleProcesoCocheDevuelto = em.merge(TunelDetalleProcesoCoche);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return TunelDetalleProcesoCocheDevuelto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TunelDetalleProcesoCocheSalida> getListaTunelDetalleProcesoCocheByOrdenFabricacion(long idordenfabriacion ) 
	{
		List<TunelDetalleProcesoCocheSalida> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		 Query qry  = em.createQuery("select ep from TunelDetalleProcesoCocheSalida ep " +
				" where ep.lonjasOrdenProduccion.idlonjasordenproduccion = :idorden " +
				" order by  ep.idtuneldetalleprocesocochesalida desc ");
		
		 qry.setParameter("idorden",  idordenfabriacion );
		  
		 lista = qry.getResultList();
		 em.close();
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TunelDetalleProcesoCocheSalida> getListaTunelDetalleProcesoCocheByOrdenFabricacionAndEstado(long idordenfabriacion , int estado ) 
	{
		List<TunelDetalleProcesoCocheSalida> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		 Query qry  = em.createQuery("select ep from TunelDetalleProcesoCocheSalida ep " +
				" where ep.lonjasOrdenProduccion.idlonjasordenproduccion = :idorden and ep.estado = :estad " +
				" order by  ep.idtuneldetalleprocesocochesalida desc ");
		
		 qry.setParameter("idorden",  idordenfabriacion );
		 qry.setParameter("estad",  estado );
		  
		 lista = qry.getResultList();
		 em.close();
		return lista;
	}
	
	
}
