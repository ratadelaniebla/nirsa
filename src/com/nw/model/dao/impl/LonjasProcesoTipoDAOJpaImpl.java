package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LonjasProcesoTipo;
 

public class LonjasProcesoTipoDAOJpaImpl {
	
	public LonjasProcesoTipoDAOJpaImpl() {
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LonjasProcesoTipo> getListaLonjasProcesoTipo() {
		List<LonjasProcesoTipo> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			 
			Query qry  = em.createQuery("select lpe from LonjasProcesoTipo lpe " +
									"       order by lpe.idlonjasprocesotipo asc "); 
			 lista = qry.getResultList();
			 em.close();
	    return lista;
	}
	
	
	
	
}
