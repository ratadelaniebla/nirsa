package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.PccParametro;
import com.nw.model.dao.PccParametroDAO;


public class PccParametroDAOJpaImpl extends BaseDaoJpaImpl implements PccParametroDAO 
{
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public PccParametroDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

    
    
	@Override
	public PccParametro getPccParametroById(Integer id) {
		return em.find(PccParametro.class, id);
	}
	
   
	
}
