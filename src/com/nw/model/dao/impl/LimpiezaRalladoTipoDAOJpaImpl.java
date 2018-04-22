package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaRalladoTipo;
import com.nw.model.dao.LimpiezaRalladoTipoDAO;

@SuppressWarnings("unchecked")
public class LimpiezaRalladoTipoDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaRalladoTipoDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaRalladoTipoDAOJpaImpl()
    {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	    
   
    
	public List<LimpiezaRalladoTipo> geLimpiezaRalladoTipo() {
		return em.createQuery("select t from LimpiezaRalladoTipo t order by t.descripcion").getResultList();
	}
	
	
}
