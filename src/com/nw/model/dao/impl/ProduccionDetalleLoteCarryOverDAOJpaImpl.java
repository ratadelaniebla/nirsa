package com.nw.model.dao.impl;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

//import javax.persistence.Query;
//import org.zkoss.zul.Messagebox;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.CalidadAprobacionDescargaCuba;
//import com.nw.model.Camara;
//import com.nw.model.DescongeladoDetalleProceso;
//import com.nw.model.ProduccionDetalleLote;
//import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.ProduccionDetalleLoteCarryover;
import com.nw.model.dao.ProducccionDetalleLoteCarryOverDAO;
//import com.nw.model.dao.ProducccionDetalleLoteDAO;
//import com.nw.util.Sistema;

public class ProduccionDetalleLoteCarryOverDAOJpaImpl extends BaseDaoJpaImpl implements ProducccionDetalleLoteCarryOverDAO {

	
	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public ProduccionDetalleLoteCarryOverDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}



	public void saveOrUpdate(ProduccionDetalleLoteCarryover producciondetallelotecarryover) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(producciondetallelotecarryover);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	

	
}
