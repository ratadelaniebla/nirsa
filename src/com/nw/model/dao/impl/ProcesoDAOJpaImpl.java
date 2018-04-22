package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Proceso;
import com.nw.model.dao.ProcesoDAO;

/**
 * Clase para manejar los procesos
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-01-07
 */
public class ProcesoDAOJpaImpl extends BaseDaoJpaImpl implements ProcesoDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public ProcesoDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }
    
	@Override
	public Proceso getProcesoById(Integer id) {
		return em.find(Proceso.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Proceso> getProcesosDLLRE() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT p ");
		sbuilder.append("FROM Proceso p ");
		sbuilder.append("WHERE p.idproceso IN (4, 5, 9, 12, 13) ");
		try {
			List<Proceso> resultList = (List<Proceso>) em.createQuery(
					sbuilder.toString())//
					.getResultList();
			return resultList;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Proceso> getProcesosMP() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT p ");
		sbuilder.append("FROM Proceso p ");
		sbuilder.append("WHERE p.idproceso IN (4, 9, 12, 13) ");
		try {
			List<Proceso> resultList = (List<Proceso>) em.createQuery(
					sbuilder.toString())
					.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	

	
	
	
	public List<Proceso> getProcesosDevolucionBandejasConDefectos() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT p ");
		sbuilder.append("FROM Proceso p ");
		sbuilder.append("WHERE p.idproceso IN (9, 13, 14, 15) order by p.descripcionproceso ");
		try {
			@SuppressWarnings("unchecked")
			List<Proceso> resultList = (List<Proceso>) em.createQuery(
					sbuilder.toString())
					.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Proceso> getProcesosLimpiezaLomo() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT p ");
		sbuilder.append("FROM Proceso p ");
		sbuilder.append("WHERE p.idproceso IN (9,13,14) ");
		try {
			List<Proceso> resultList = (List<Proceso>) em.createQuery(
					sbuilder.toString())
					.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

}
