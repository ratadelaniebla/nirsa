package com.nw.model.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.CalidadAprobacionDescargaCuba;
import com.nw.model.LimpiezaBalanza;


@SuppressWarnings({"unchecked"})
public class LimpiezaBalanzasDAOJpaImpl extends BaseDaoJpaImpl{
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public LimpiezaBalanzasDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	
	public List<LimpiezaBalanza>getLimpiezaBalanzas()
	{
		return em.createQuery("select l from LimpiezaBalanza l order by l.idlimpiezabalanza").getResultList();
	}

	
	
	
	
	
	
	
	//Nuevo 26-01-2017
	@SuppressWarnings("rawtypes")
	public LimpiezaBalanza LimpiezaBalanzaPorLinea(Integer id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaBalanza o "); 
		sb.append("Where o.linea = " + id + " and o.estado=2");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList().subList(0, 1);

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaBalanza) items.get(0);
        }		
	} 
	
	
	public void saveOrUpdate(LimpiezaBalanza balanza) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(balanza);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	
/*	
	public List<LimpiezaLinea>getLimpiezaLineasGrupo(){
		return em.createQuery("select l from LimpiezaLinea l order by l.idlimpiezalinea").getResultList();
	}
*/	
	
}
