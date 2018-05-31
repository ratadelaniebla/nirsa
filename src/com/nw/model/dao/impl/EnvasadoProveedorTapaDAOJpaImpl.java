package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.nw.model.EnvasadoProveedorTapa;
import com.nw.model.dao.EnvasadoProveedorTapaDAO;



@SuppressWarnings("unchecked")
public class EnvasadoProveedorTapaDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoProveedorTapaDAO {

	
	@PersistenceContext

	private EntityTransaction t;
	
	public EnvasadoProveedorTapaDAOJpaImpl() {
		t = em.getTransaction();
	}

	@Override
	public EnvasadoProveedorTapa getEnvasadoProveedorTapa(Integer id) {
		return (EnvasadoProveedorTapa)getObject(EnvasadoProveedorTapa.class, id);
	}

	@Override
	public List<EnvasadoProveedorTapa> getEnvasadoProveedorTapa() {
		return getObjects(EnvasadoProveedorTapa.class);
	}
	
}
