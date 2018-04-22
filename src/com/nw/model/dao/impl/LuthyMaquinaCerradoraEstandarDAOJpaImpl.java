package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.LuthyMaquinaCerradoraEstandar;
import com.nw.model.dao.LuthyMaquinaCerradoraEstandarDAO;

public class LuthyMaquinaCerradoraEstandarDAOJpaImpl extends BaseDaoJpaImpl
		implements LuthyMaquinaCerradoraEstandarDAO {

	public LuthyMaquinaCerradoraEstandarDAOJpaImpl() {
	}

	@Override
	public void saveOrUpdate(LuthyMaquinaCerradoraEstandar luthy) {
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
	public List<LuthyMaquinaCerradoraEstandar> getAll() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM LuthyMaquinaCerradoraEstandar m ");
			return (List<LuthyMaquinaCerradoraEstandar>) em.createQuery(
					sbuilder.toString()).getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LuthyMaquinaCerradoraEstandar> getMceByLuthy(int idluthy) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM LuthyMaquinaCerradoraEstandar m ");
			sbuilder.append("WHERE m.luthy.idluthy = :idluthy ");
			return (List<LuthyMaquinaCerradoraEstandar>) em
					.createQuery(sbuilder.toString())//
					.setParameter("idluthy", idluthy)//
					.getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
}
