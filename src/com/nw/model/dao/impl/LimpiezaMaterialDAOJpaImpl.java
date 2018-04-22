package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaMaterial;
import com.nw.model.dao.LimpiezaMaterialDAO;

public class LimpiezaMaterialDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaMaterialDAO {

	
	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaMaterialDAOJpaImpl()
    {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager(); 
    }
    
    @SuppressWarnings("unchecked")
	public List<LimpiezaMaterial> getLimpiezaMaterial()
    {
    	return em.createQuery("select lm from LimpiezaMaterial lm order by lm.nombre").getResultList();
    }
	
    
    @SuppressWarnings("unchecked")
	public List<LimpiezaMaterial> getLimpiezaMaterialLomoRallado()
    {
    	return em.createQuery("select lm from LimpiezaMaterial lm where lm.idlimpiezamaterial in (1,2) order by lm.nombre").getResultList();
    }
    
	@Override
	public void saveOrUpdate(LimpiezaMaterial limpiezaMaterial) {
		// TODO Auto-generated method stub
		
	}
	
	public LimpiezaMaterial getLimpiezaMaterialById(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select lm "); 
		sb.append("From LimpiezaMaterial lm "); 
		sb.append("Where lm.idlimpiezamaterial = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaMaterial) items.get(0);
        }		
	}	

}
