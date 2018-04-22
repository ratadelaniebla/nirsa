package com.nw.model.dao.impl;

import java.util.List;

import com.nw.model.EnvasadoCaldoVegetalProteina;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;

public class EnvasadoCaldoVegetalProteinaDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoCaldoVegetalProteinaDAO {
	
	public EnvasadoCaldoVegetalProteina getEnvasadoCaldoVegetalProteina(Integer id){
		return (EnvasadoCaldoVegetalProteina)getObject(EnvasadoCaldoVegetalProteina.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoCaldoVegetalProteina> getEnvasadoCaldoVegetalProteina(){
		return getObjects(EnvasadoCaldoVegetalProteina.class);
	}
}
