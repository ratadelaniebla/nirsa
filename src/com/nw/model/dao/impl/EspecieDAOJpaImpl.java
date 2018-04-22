package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;

import com.nw.model.Especie;
import com.nw.model.dao.EspecieDAO;

public class EspecieDAOJpaImpl extends BaseDaoJpaImpl implements EspecieDAO {

	public EspecieDAOJpaImpl() {
	}

	@Override
	public void saveOrUpdate(Especie especie) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(especie);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public Especie getById(int idespecie) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT e ");
			sbuilder.append("FROM Especie e ");
			sbuilder.append("WHERE e.idespecie = :idespecie ");
			return (Especie) em.createQuery(sbuilder.toString())
					.setParameter("idespecie", idespecie)//
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			System.out.println(e.getMessage());
			return null;
		}
	}
}