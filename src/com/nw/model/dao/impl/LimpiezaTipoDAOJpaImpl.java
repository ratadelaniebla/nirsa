package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaTipo;
import com.nw.model.dao.LimpiezaTipoDAO;

@SuppressWarnings("unchecked")
public class LimpiezaTipoDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaTipoDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaTipoDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

    
	public List<LimpiezaTipo> getLimpiezaTipo() {
		return em.createQuery("select t from LimpiezaTipo t order by t.descripcion").getResultList();
	}
	
	
}
