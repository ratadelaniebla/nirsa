package com.nw.model.dao.impl;

import java.util.List;

import com.nw.model.EnvasadoTipoProteina;
import com.nw.model.dao.EnvasadoTipoProteinaDAO;

public class EnvasadoTipoProteinaDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoTipoProteinaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<EnvasadoTipoProteina> getAll() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM EnvasadoTipoProteina m ");
			return (List<EnvasadoTipoProteina>) em.createQuery(sbuilder.toString())
					.getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
}
