package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.Luthy;
import com.nw.model.dao.LuthyDAO;

public class LuthyDAOJpaImpl extends BaseDaoJpaImpl implements LuthyDAO {

	public LuthyDAOJpaImpl() {
	}

	@Override
	public void saveOrUpdate(Luthy luthy) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(luthy);
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
	public List<Luthy> getAll() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM Luthy m ");
			return (List<Luthy>) em.createQuery(sbuilder.toString())
					.getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	
	/**
	 * Extrae una luthy por ID
	 * @author clsMbaque
	 * @param idluthy
	 * @return
	 */
	public Luthy getLuthyById(Integer idluthy){
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m FROM Luthy m WHERE m.idluthy = :idluthy");
			return (Luthy) em.createQuery(sbuilder.toString()).setParameter("idluthy", idluthy).getSingleResult();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
}
