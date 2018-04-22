package com.nw.model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.dao.impl.BaseDaoJpaImpl;
import com.nw.model.Usuario;
import com.nw.model.dao.UsuarioDAO;

public class UsuarioDAOJpaImpl extends BaseDaoJpaImpl implements UsuarioDAO {
   
	@PersistenceContext
	

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public UsuarioDAOJpaImpl() {
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
    
    //Busca al usuario que sea del grupo de supervisores de linea
	public Usuario getUserAprobacion(String usuario, String clave) 
	{
		Usuario usuarioaprobacion = new Usuario();

		try {
			Query query = em.createQuery("select u from Usuario u " +
						                 "where u.idusuario = :idusu and u.clave = :clave and u.grupo.idgrupo = 77 ");
			query.setParameter("idusu", usuario);
			query.setParameter("clave", clave);
			
			usuarioaprobacion = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		
		return usuarioaprobacion;	
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
		sb.append("select "); 
		sb.append("O.opcion, O.formulario, O.imagen "); 
		sb.append("from Grupo_Opcion GO, Opcion O, Usuario U "); 
		sb.append("where "); 
		sb.append("U.idUsuario = '"+id+"' "); 
		sb.append("and GO.idGrupo = U.idGrupo "); 
		sb.append("AND GO.idOpcion = O.idOpcion ");
		sb.append("order by GO.idOpcion ");
		
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


