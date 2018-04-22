package com.nw.model.dao.impl;

 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DispositivoDestino;
import com.nw.model.dao.DispositivoDestinoDAO;


public class DispositivoDestinoDAOJpalmpl extends BaseDaoJpaImpl implements DispositivoDestinoDAO {

	@PersistenceContext
	private EntityManagerFactory emf  ;
	private EntityManager em  ;

	 
	 
	
	public DispositivoDestinoDAOJpalmpl() {
		// emf = Persistence.createEntityManagerFactory("NW");
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}


	
	public List<DispositivoDestino> getListaDispositivoDestinoPorPuestoDeTrabajo(Integer iddispositivopuestotrabajo) 
	{        
        List<DispositivoDestino> listaDispositivoDestino = new ArrayList<DispositivoDestino>();  
        //Muesra la lista de todos los cajons con estado 1
        Query query =  em.createQuery(" select dd from DispositivoDestino dd " +
        		"where dd.dispositivoPuestoTrabajo.iddispositivopuestotrabajo=:iddd ");  
        query.setParameter("iddd", iddispositivopuestotrabajo);
        listaDispositivoDestino = query.getResultList();           
        return listaDispositivoDestino;
     }
	
	   
}
