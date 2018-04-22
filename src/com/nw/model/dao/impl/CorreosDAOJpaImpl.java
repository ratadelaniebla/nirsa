package com.nw.model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Correo;
import com.nw.model.LimpiezaLinea;
import com.nw.model.dao.CorreosDAO;


@SuppressWarnings("unchecked")
public class CorreosDAOJpaImpl extends BaseDaoJpaImpl implements CorreosDAO 
{	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CorreosDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

    
//    public List<Correo> getCorreos() 
//    {
//		try {
//			return em.createQuery("select c from Correo c where c.estado = 1").getResultList();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
    
    
	public List<Correo>getCorreos()
	{
		return em.createQuery("select c from Correo c where c.estado = 1 ").getResultList();
	}    
    
    
}
