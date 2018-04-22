package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasBalanza;

public class LonjasBalanzaDAOJpaImpl {

	public LonjasBalanzaDAOJpaImpl() {
	}
	
	public LonjasBalanza getBalanzaLonjaByLinea( int linea  ) {
		LonjasBalanza ep = new LonjasBalanza();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		try {			
			
			Query qry  = em.createQuery("select lb from LonjasBalanza lb " +
					" where  lb.linea =:idlinea  ");
			
			qry.setParameter("idlinea", linea);
			ep = (LonjasBalanza) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
}
