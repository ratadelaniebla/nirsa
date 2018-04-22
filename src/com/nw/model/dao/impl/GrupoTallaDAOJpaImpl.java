package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.GrupoTalla;
import com.nw.model.dao.GrupoTallaDAO;


@SuppressWarnings("unchecked")
public class GrupoTallaDAOJpaImpl extends BaseDaoJpaImpl implements GrupoTallaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public GrupoTallaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public GrupoTalla getFindGrupoTallaId(Integer vid) {
		return em.find(GrupoTalla.class, vid);	
	}	    
   
    
	public List<GrupoTalla> getGrupoTallas() {
		return em.createQuery("select t from GrupoTalla t order by t.idgrupotalla").getResultList();
	}
	

	
	
}
