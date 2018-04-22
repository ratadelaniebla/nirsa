package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.ProcesosCargaEvolution;

/**
 * Clase para manejar los procesos de carga a Evolution
 * @author carper SAmuelPalma spalma@nirsa.com
 * 2016-08-05
 */
public class ProcesoCargaEvolutionDAOJpaImpl {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public ProcesoCargaEvolutionDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }
    
	public ProcesosCargaEvolution getProcesoById(Integer id) {
		return em.find(ProcesosCargaEvolution.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<ProcesosCargaEvolution> getProcesosCargaEvolution() {
		String sql = "select o from ProcesosCargaEvolution o where o.estado=1";
		return em.createQuery(sql).getResultList();
	}

}
