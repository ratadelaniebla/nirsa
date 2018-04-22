package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasOrdenProduccion;
import com.nw.model.LonjasProceso;

public class LonjasOrdenProduccionDAOJpaImpl {

	
	public LonjasOrdenProduccionDAOJpaImpl() {
		 
	}
	
	public LonjasOrdenProduccion saveOrUpdate(LonjasOrdenProduccion lonjasOrdenProduccion) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		LonjasOrdenProduccion LonjasOrdenProduccionDevuelto = null;
		try {
			t.begin();
			LonjasOrdenProduccionDevuelto = em.merge(lonjasOrdenProduccion);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return LonjasOrdenProduccionDevuelto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasOrdenProduccion> getListaLonjasOrdenProduccion(LonjasProceso lproceso ) {
		List<LonjasOrdenProduccion> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		long idlproceso = lproceso.getIdlonjasproceso();		
			 
			Query qry  = em.createQuery("select lpe from LonjasOrdenProduccion lpe " +
					" where lpe.lonjasProceso.idlonjasproceso =:lp " +
					"       order by lpe.idlonjasordenproduccion desc "); 
			
			 qry.setParameter("lp", idlproceso);
			 lista = qry.getResultList();
			 em.close();
	    return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasOrdenProduccion> getListaLonjasOrdenProduccionByFecha(Date fechaInicio , Date fechafin ) {
		List<LonjasOrdenProduccion> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			 
			Query qry  = em.createQuery("select lpe from LonjasOrdenProduccion lpe " +
					" where func('DATE', lpe.fecharegistro) between  :fechainicio and :fechafin " +
					"       order by lpe.idlonjasordenproduccion desc "); 
			
			 qry.setParameter("fechainicio", fechaInicio);
			 qry.setParameter("fechafin"   , fechafin);
			 
			 lista = qry.getResultList();
			 em.close();
	    return lista;
	}
	
	
	
}
