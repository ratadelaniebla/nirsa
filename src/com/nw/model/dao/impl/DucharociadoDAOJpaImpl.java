package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Ducharociado;
import com.nw.model.dao.DucharociadoDAO;

public class DucharociadoDAOJpaImpl extends BaseDaoJpaImpl implements DucharociadoDAO {
	
	private EntityManagerFactory emf;
    private EntityManager em;
    
    public DucharociadoDAOJpaImpl()
    {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();  
    }

	public List<Ducharociado> getTurnos() {
		return em.createQuery("select dr from Ducharociado dr order by dr.descripcion").getResultList();
	}

	public List<Ducharociado> getDuchas() {
		return em.createQuery("select dr from Ducharociado dr").getResultList();
	}	
	
	@Override
	public void saveorUpdate(Ducharociado duchaRociado) {
		// TODO Auto-generated method stub
		
	}

}
