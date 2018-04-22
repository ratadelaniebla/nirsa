package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CocinaCurva;
//import com.nw.model.Lugar;
//import com.nw.model.LugarDetalle;
import com.nw.model.dao.CocinaCurvaDAO;
//import com.nw.model.dao.LugarDAO;

@SuppressWarnings("unchecked")
public class CocinaCurvasDAOJpaImpl extends BaseDaoJpaImpl implements CocinaCurvaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CocinaCurvasDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

    
	public List<CocinaCurva> getCocinaCurvas() {
		return em.createQuery("select l from CocinaCurva l order by l.descripcion")
				.getResultList();
	}

	
}
