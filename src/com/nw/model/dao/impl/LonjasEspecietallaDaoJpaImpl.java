package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasEspecietalla;

public class LonjasEspecietallaDaoJpaImpl {

	
	public LonjasEspecietallaDaoJpaImpl() {
		 
	}
	
	@SuppressWarnings("unchecked")
	public List<LonjasEspecietalla> getListaLonjasEspecietalla(int idespecietalla) 
	{
		List<LonjasEspecietalla> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				 Query qry  = em.createQuery("select ep from LonjasEspecietalla ep " +
						" where ep.especieTalla.idespecietalla = :idespecie  " +
						" order by  ep.idlonjasespecietalla desc ");
				
				 qry.setParameter("idespecie",  idespecietalla ); 
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
