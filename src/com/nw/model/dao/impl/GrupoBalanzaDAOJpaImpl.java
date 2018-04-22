package com.nw.model.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.dao.impl.BaseDaoJpaImpl;
import com.nw.model.GrupoBalanza;
import com.nw.model.dao.GrupoBalanzaDAO;

/**
 * @author hnavarrete
 *
 */
public class GrupoBalanzaDAOJpaImpl extends BaseDaoJpaImpl implements GrupoBalanzaDAO {
   
	@PersistenceContext
	

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public GrupoBalanzaDAOJpaImpl() {
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	/**
     * @see org.appfuse.dao.UserDao#getUser(Long)
     */
	@Override
    public GrupoBalanza getGruporBalanza(Integer id) {
		
		//em = emf.createEntityManager();   
		
		GrupoBalanza user = (GrupoBalanza) em.find(GrupoBalanza.class, id);

        if (user == null) {
            log.warn("Grupo Balanza '" + id.toString() + "' no encontrado...");
        }

        return user;
    }
    

}


