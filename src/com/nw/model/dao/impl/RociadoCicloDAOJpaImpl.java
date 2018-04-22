package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.RociadoCiclo;
import com.nw.model.dao.RociadoCicloDAO;

@SuppressWarnings("unchecked")
public class RociadoCicloDAOJpaImpl extends BaseDaoJpaImpl implements RociadoCicloDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public RociadoCicloDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public List<RociadoCiclo> getRociadoCiclos() {
		return em.createQuery("select r from RociadoCiclo  r ").getResultList();
	}

	
}
