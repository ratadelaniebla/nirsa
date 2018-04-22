package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasTunel;

public class LonjasTunelDAOJpaImpl {
 
	public LonjasTunelDAOJpaImpl() {
	}
	
	@SuppressWarnings("unchecked")
	public List<LonjasTunel> getListaLonjasTunel() {
		List<LonjasTunel> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			 
			Query qry  = em.createQuery("select lpe from LonjasTunel lpe " +
					        "  order by lpe.idlonjastunel desc "); 
		 
			 lista = qry.getResultList();
			 em.close();
	    return lista;
	}
	
	
}
