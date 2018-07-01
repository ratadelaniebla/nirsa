package com.nw.model.dao.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.dao.EsterilizadoTipoCocheDAO;



public class EsterilizadoTipoCocheDAOJpaImpl extends BaseDaoJpaImpl implements EsterilizadoTipoCocheDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
//    private EntityManager em;
    
    public EsterilizadoTipoCocheDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//        em = emf.createEntityManager();   
    }

}
