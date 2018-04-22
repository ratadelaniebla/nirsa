package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.dao.impl.BaseDaoJpaImpl;
import com.nw.model.Usuario;
import com.nw.model.UsuariosAprobacion;
import com.nw.model.dao.UsuarioDAO;

/**
 * @author hnavarrete
 *
 */
public class UsuarioAprobacionDAOJpaImpl extends BaseDaoJpaImpl implements UsuarioDAO {
   
	@PersistenceContext
	

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public UsuarioAprobacionDAOJpaImpl() {
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	/**
     * @see org.appfuse.dao.UserDao#getUser(Long)
     */
	
	public UsuariosAprobacion getUserAprobacion(String vid) {
		UsuariosAprobacion usuarioaprobacion = new UsuariosAprobacion();

		Query query = em.createQuery("select pdlc from UsuariosAprobacion pdlc " +
					"where pdlc.usuario.idusuario = :idusu");
		query.setParameter("idusu", vid);
		
		usuarioaprobacion = (UsuariosAprobacion) query.getSingleResult();
		
		return usuarioaprobacion;	
	}
	@Override
	public Usuario getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsers(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List getOpcionesAsignadas(String id) {
		// TODO Auto-generated method stub
		return null;
	}	    
   
    
    /**
     * @see org.appfuse.dao.UserDao#getUsers(org.appfuse.model.User)
     */
    
	

}


