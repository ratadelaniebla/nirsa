package com.nw.model.dao.impl;

import java.util.List;

import com.nw.model.EnvasadoMotivoCambio;
import com.nw.model.dao.EnvasadoMotivoCambioDAO;

public class EnvasadoMotivoCambioDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoMotivoCambioDAO {
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoMotivoCambio> getAll() {
		return (List<EnvasadoMotivoCambio>)getObjects(EnvasadoMotivoCambio.class);
	}

}
