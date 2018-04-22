package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CamaraCajonEstado;

public class CamaraCajonEstadoJpaImpl extends BaseDaoJpaImpl 
{
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CamaraCajonEstadoJpaImpl()
    {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	
	public CamaraCajonEstado getFindCamaraCajonEstadoId(Integer vid) 
	{
		return em.find(CamaraCajonEstado.class, vid);	
	}	
	
}