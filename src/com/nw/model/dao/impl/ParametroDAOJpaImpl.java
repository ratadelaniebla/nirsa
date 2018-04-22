package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;

import com.nw.model.Parametro;
import com.nw.model.dao.ParametroDAO;

public class ParametroDAOJpaImpl extends BaseDaoJpaImpl implements ParametroDAO {

	@SuppressWarnings("unused")
	private static Log logger = LogFactory.getLog(ParametroDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public ParametroDAOJpaImpl() {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
	public Parametro findById(Integer id) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT p ");
			sbuilder.append("FROM Parametro p ");
			sbuilder.append("WHERE p.idparametro = :id ");
			Parametro item = (Parametro) em.createQuery(sbuilder.toString()) 
					.setParameter("id", id)
					.getSingleResult();
			return item;
		} catch (Exception e) {
			System.out.println(String.format(
					"ParametrosDAO ERROR: %s , parametro: %s", e.getMessage(),
					id));
			return null;
		}finally{
			em.close();
		}
	}
    
	public Parametro getParametroById(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select p "); 
		sb.append("From Parametro p "); 
		sb.append("Where p.idparametro = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (Parametro) items.get(0);
        }		
	}   

	@Override
	public void saveOrUpdate(Parametro parametro) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(parametro);
	 			        t.commit();
   		  } finally {
   		    if (t.isActive()) t.rollback();
   		  }
			}finally{
				//em.close();
				//emf.close();
			}
		
	}	
}	