package com.nw.model.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.GestionTurno;
import com.nw.model.dao.GestionTurnoDAO;

/*import com.wm.model.MedioPeriodo;
import com.wm.model.MedioPeriodoPK;
import com.wm.model.dao.MedioPeriodoDAO;*/


@SuppressWarnings("unchecked")
public class GestionTurnoDAOJpaImpl extends BaseDaoJpaImpl implements GestionTurnoDAO {

	private static Log logger = LogFactory.getLog(GestionTurnoDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public GestionTurnoDAOJpaImpl() {

   //    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
   

	@Override
	public void saveOrUpdate(GestionTurno gestionturno) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(gestionturno);
	 			        t.commit();
   		  } finally {
   		    if (t.isActive()) t.rollback();
   		  }
			}finally{
				//em.close();
				//emf.close();
			}
		
	}
	
	
	public List<GestionTurno> ListaGestionTurnos(String f1) {
		return em.createQuery("Select o From GestionTurno o " +
				"Where o.fechaproduccion = '"+f1+"' order by o.turno.idturno").getResultList();
	}
	
	@Override	
	public GestionTurno getGestionTurnoByProduccionTurno(String f1, Integer idturno) 
	{ 
		System.out.println("Datos");
		System.out.println("Fecha :"+f1);
		System.out.println("Tuno :"+ String.valueOf(idturno));
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("Select o "); 
		sb.append("From GestionTurno o "); 
		sb.append("Where o.fechaproduccion = '"+f1+"' and o.turno.idturno = '"+String.valueOf(idturno)+"'");
		
		logger.info(GestionTurno.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (GestionTurno) items.get(0);
	    }		
	}
	
		
}