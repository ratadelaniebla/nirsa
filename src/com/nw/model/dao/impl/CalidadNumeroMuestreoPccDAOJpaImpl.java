package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadNumeroMuestreoPcc;
import com.nw.model.dao.CalidadNumeroMuestreoPccDAO;

@SuppressWarnings("unchecked")
public class CalidadNumeroMuestreoPccDAOJpaImpl extends BaseDaoJpaImpl implements CalidadNumeroMuestreoPccDAO {

	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadNumeroMuestreoPccDAOJpaImpl(){
//      	emf = Persistence.createEntityManagerFactory("NW");
      	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	public List<CalidadNumeroMuestreoPcc> getCalidadNumeroMuestreoPcc(Integer idmuestro) {
		
		//Verifica si el tipo de muestro es para mercante (idmuestro = 5)
		if(idmuestro != null)
		{
			//MUestra todos
			return em.createQuery("select nm from CalidadNumeroMuestreoPcc nm order by nm.idcalidadnumeromuestreopcc").getResultList();	
		}
		else
		{
			//MUestra la lista de basico para los muestreos
/*			return em.createQuery("select nm from CalidadNumeroMuestreoPcc nm order by nm.idcalidadnumeromuestreopcc").setMaxResults(4).getResultList();*/	
			return em.createQuery("select nm from CalidadNumeroMuestreoPcc nm order by nm.idcalidadnumeromuestreopcc").getResultList();	
		}
		
	}
	
}
