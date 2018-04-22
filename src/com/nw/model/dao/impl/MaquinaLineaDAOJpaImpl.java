package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.MaquinaLinea;


@SuppressWarnings({"unchecked"})
public class MaquinaLineaDAOJpaImpl extends BaseDaoJpaImpl{
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public MaquinaLineaDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	
	public List<MaquinaLinea>getMaquinasLineas(){
		return em.createQuery("select l from MaquinaLinea l order by l.idmaquinalinea").getResultList();
	}
	
}
