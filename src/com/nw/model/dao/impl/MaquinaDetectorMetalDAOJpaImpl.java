package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.MaquinaDetectorMetal;


@SuppressWarnings({"unchecked"})
public class MaquinaDetectorMetalDAOJpaImpl extends BaseDaoJpaImpl{
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public MaquinaDetectorMetalDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	
	public List<MaquinaDetectorMetal>getMaquinasDetector(){
		return em.createQuery("select l from MaquinaDetectorMetal l order by l.idmaquinadetectormetal").getResultList();
	}
	
}
