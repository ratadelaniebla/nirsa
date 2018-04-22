package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CamaraArea;
import com.nw.model.dao.CamaraAreaDAO;

@SuppressWarnings("unchecked")
public class CamaraAreaDAOJpaImpl extends BaseDaoJpaImpl implements CamaraAreaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CamaraAreaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	public List<CamaraArea> getCamaraAreas() {
		return em.createQuery("select c from CamaraArea c order by c.descripcioncamaraarea").getResultList();
	}

	
	public CamaraArea getFindCamaraAreaId(Integer vid) {
		return em.find(CamaraArea.class, vid);	
	}	
	
}
