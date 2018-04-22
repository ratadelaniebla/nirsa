package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaLomoLimpioCoche;

public class LimpiezaLomoLimpioCocheDAOJpaImpl {

	public LimpiezaLomoLimpioCocheDAOJpaImpl() {
	}
	
	public LimpiezaLomoLimpioCoche saveOrUpdate(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoche) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction    t    = em.getTransaction();
		LimpiezaLomoLimpioCoche LimpiezaLomoLimpioCocheDevuelto = null;
		try {
			t.begin();
			LimpiezaLomoLimpioCocheDevuelto = em.merge(limpiezaLomoLimpioCoche);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return LimpiezaLomoLimpioCocheDevuelto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaLomoLimpioCoche> getListaLimpiezaLomoLimpioCoche(long idlimpiezaproceso, String  secuencia) 
	{
		List<LimpiezaLomoLimpioCoche> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				 Query qry  = em.createQuery("select ep from LimpiezaLomoLimpioCoche ep " +
						" where ep.limpiezaProcesoLoteActivo.limpiezaProceso.idlimpiezaproceso = :idlote and ep.secuencia = :secuencia and ep.estado = 1 " +
						" order by  ep.idlimpiezalomolimpiocoche desc ");
				
				 qry.setParameter("idlote",  idlimpiezaproceso );
				 qry.setParameter("secuencia",  secuencia.trim() );
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
	public String generarSecuencia(long idlimpiezaproceso){
		List<LimpiezaLomoLimpioCoche> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
		try {
			 Query qry  = em.createQuery("select ep from LimpiezaLomoLimpioCoche ep " +
					" where ep.limpiezaProcesoLoteActivo.limpiezaProceso.idlimpiezaproceso = :idlp and ep.estado = 1 " +
					" order by  ep.idlimpiezalomolimpiocoche desc ");
			
			 qry.setParameter("idlp",  idlimpiezaproceso );
			 lista = qry.getResultList();
			 
			 if (lista.isEmpty()) {
				return "1";
			 }else{
				 int secuencia = lista.size() + 1;
				 return String.valueOf(secuencia);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			lista = new ArrayList<>();
			return "Error";
		}finally{
			em.close();
		}
	}
	
}
