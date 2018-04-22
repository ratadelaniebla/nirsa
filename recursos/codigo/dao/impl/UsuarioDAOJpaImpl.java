package com.wm.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.wm.model.dao.impl.BaseDaoJpaImpl;
import com.wm.model.Usuario;
import com.wm.model.dao.UsuarioDAO;

/**
 * @author jvallejo
 *
 */
public class UsuarioDAOJpaImpl extends BaseDaoJpaImpl implements UsuarioDAO {
    
	@PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;
	
    public UsuarioDAOJpaImpl() {

        emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	/**
     * @see org.appfuse.dao.UserDao#getUser(Long)
     */
	@Override
    public Usuario getUser(String id) {
		
		//em = emf.createEntityManager();   
		
    	Usuario user = (Usuario) em.find(Usuario.class, id);

        if (user == null) {
            log.warn("Usuario '" + id + "' no encontrado...");
        }

        return user;
    }
    
    
    /**
     * @see org.appfuse.dao.UserDao#getUsers(org.appfuse.model.User)
     */
    
    @Override
	public List<Usuario> getUsers(Usuario user) {
        return em.createQuery("select r from User r order by r.username").getResultList();
    }
    
    @Override
	public List getOpcionesAsignadas(String id){
    	//em = emf.createEntityManager();   
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT "); 
		sb.append("VOPCION, VFORMULARIO, VIMAGEN "); 
		sb.append("FROM GRUPO_OPCION GO, OPCION O, USUARIO U "); 
		sb.append("WHERE "); 
		sb.append("U.VIDUSUARIO = '"+id+"' "); 
		sb.append("AND GO.IIDGRUPO = U.IIDGRUPO "); 
		sb.append("AND GO.IIDOPCION = O.IIDOPCION ");
		
		String sss= sb.toString();
		
		//em.createNativeQuery(sb.toString()).getResultList();
		List listOpciones =  em.createNativeQuery(sb.toString()).getResultList();
	    if (listOpciones == null || listOpciones.isEmpty()) {
	    	//logger.info(message, t) ("item: "+vIdDato+" not found");
	        return null;
	    } else {
	        return listOpciones;
	    }
	}
	

}


