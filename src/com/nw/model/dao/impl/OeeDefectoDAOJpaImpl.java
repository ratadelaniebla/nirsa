package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.OeeDefecto;
import com.nw.model.dao.OeeDefectoDAO;

public class OeeDefectoDAOJpaImpl extends BaseDaoJpaImpl implements
		OeeDefectoDAO {

	public OeeDefectoDAOJpaImpl() {
	}

	@Override
	public void saveOrUpdate(OeeDefecto defecto) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(defecto);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<OeeDefecto> getAll() {
		List<OeeDefecto> lista = new ArrayList<>();
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM OeeDefecto m order by m.idOeeDefectos ");
			lista = em.createQuery(sbuilder.toString())
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	   return lista;	
	}

	@SuppressWarnings("unchecked")
	public List<OeeDefecto> findByIdproceso(int idproceso) {
		List<OeeDefecto> lista = new ArrayList<>();
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM OeeDefecto m ");
			sbuilder.append("WHERE m.proceso.idproceso = :idproceso ");
			lista = em.createQuery(sbuilder.toString()) 
					.setParameter("idproceso", idproceso) 
					.getResultList();
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			em.close();
		}
		
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OeeDefecto> findByIdprocesoAndId(int idproceso, int id) {
		List<OeeDefecto> lista = new ArrayList<>();
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM OeeDefecto m ");
			sbuilder.append("WHERE m.idOeeDefectos =:id and m.proceso.idproceso =:idproceso ");
			lista = em.createQuery(sbuilder.toString()) 
					.setParameter("idproceso", idproceso) 
					.setParameter("id", id) 
					.getResultList();
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			em.close();
		}
		
		return lista;
	}
	
	
	
}
