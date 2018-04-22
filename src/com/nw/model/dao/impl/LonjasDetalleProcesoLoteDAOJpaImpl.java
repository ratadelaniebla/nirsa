package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasDetalleProcesoLote;
 

public class LonjasDetalleProcesoLoteDAOJpaImpl {

	public LonjasDetalleProcesoLoteDAOJpaImpl() {
		 
	}
	
	public LonjasDetalleProcesoLote saveOrUpdate(LonjasDetalleProcesoLote LonjasDetalleProcesoLote) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction    t    = em.getTransaction();
		LonjasDetalleProcesoLote LonjasDetalleProcesoLoteDevuelto = null;
		try {
			t.begin();
			LonjasDetalleProcesoLoteDevuelto = em.merge(LonjasDetalleProcesoLote);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return LonjasDetalleProcesoLoteDevuelto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasDetalleProcesoLote> getListaLonjasDetalleProcesoLote(long idlonjasproceso) 
	{
		List<LonjasDetalleProcesoLote> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				 Query qry  = em.createQuery("select distinct ep from LonjasDetalleProcesoLote ep " +
						" where ep.lonjasProceso.idlonjasproceso = :idlonj and ep.estado = 1 " +
						" order by  ep.fecharegistro asc ");
				
				 qry.setParameter("idlonj",  idlonjasproceso ); 
				 lista = qry.getResultList();
				
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
				lista = new ArrayList<>();
				return lista;
			}finally{
				em.close();
			}
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasDetalleProcesoLote> getListaLonjasDetalleProcesoLoteByOrdenProduccion(long idlonjasordenproduccion) 
	{
		List<LonjasDetalleProcesoLote> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				 Query qry  = em.createQuery("select ep from LonjasDetalleProcesoLote ep " +
						" where ep.lonjasOrdenProduccion.idlonjasordenproduccion = :idlonj and ep.estado = 1 " +
						" order by  ep.fecharegistro asc ");
				
				 qry.setParameter("idlonj",  idlonjasordenproduccion ); 
				 lista = qry.getResultList();
				
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
				lista = new ArrayList<>();
				return lista;
			}finally{
				em.close();
			}
	}	
	
}
