package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasMaterial;
 

public class LonjasMaterialDAOJpaImpl {
	
	public LonjasMaterialDAOJpaImpl() {
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasMaterial> getListaLonjasMaterial() {
		List<LonjasMaterial> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			 
			Query qry  = em.createQuery("select lpe from LonjasMaterial lpe " +
									"       order by lpe.idlonjasmaterial asc "); 
			 lista = qry.getResultList();
			 em.close();
	    return lista;
	}
	
	
	
	
}
