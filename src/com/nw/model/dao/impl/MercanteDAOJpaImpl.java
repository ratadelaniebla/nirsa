package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Mercante;
import com.nw.model.dao.MercanteDAO;

@SuppressWarnings("unchecked")
public class MercanteDAOJpaImpl extends BaseDaoJpaImpl implements MercanteDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public MercanteDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public Mercante getFindMercantebyId(Integer vid) {
		return em.find(Mercante.class, vid);	
	}	    

    
    public List<Mercante> getMercantes() {
		return em.createQuery("select m from Mercante m order by m.descripcionmercante").getResultList();
	}
	
}
