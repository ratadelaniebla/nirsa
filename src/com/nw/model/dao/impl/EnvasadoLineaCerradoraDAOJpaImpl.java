package com.nw.model.dao.impl;

import java.util.List;

import com.nw.model.EnvasadoLineaCerradora;
import com.nw.model.dao.MaquinaCerradoraDAO;

public class EnvasadoLineaCerradoraDAOJpaImpl extends BaseDaoJpaImpl implements MaquinaCerradoraDAO{
	
	public EnvasadoLineaCerradora getEnvasadoLineaCerradora(Integer id) {
		return (EnvasadoLineaCerradora)getObject(EnvasadoLineaCerradora.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoLineaCerradora> getEnvasadoLineaCerradoraAll() {
		return (List<EnvasadoLineaCerradora>)getObjects(EnvasadoLineaCerradora.class);
	}
}
