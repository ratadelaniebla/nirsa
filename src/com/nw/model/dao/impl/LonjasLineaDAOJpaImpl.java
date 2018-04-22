package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.LonjasLinea;
import com.nw.model.dao.LonjasLineaDAO;

public class LonjasLineaDAOJpaImpl extends BaseDaoJpaImpl implements
		LonjasLineaDAO {

	public LonjasLineaDAOJpaImpl() {
	}

	@Override
	public void saveOrUpdate(LonjasLinea lonjasLinea) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(lonjasLinea);
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
	public List<LonjasLinea> getAll() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM LonjasLinea m ");
			sbuilder.append("ORDER BY m.descripcion");
			return (List<LonjasLinea>) em.createQuery(sbuilder.toString())
					.getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

}
