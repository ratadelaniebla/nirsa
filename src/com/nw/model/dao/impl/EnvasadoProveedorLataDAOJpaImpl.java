package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.nw.model.EnvasadoProveedorLata;
import com.nw.model.dao.EnvasadoProveedorLataDAO;



@SuppressWarnings("unchecked")
public class EnvasadoProveedorLataDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoProveedorLataDAO {

	
	@PersistenceContext

	private EntityTransaction t;
	
	public EnvasadoProveedorLataDAOJpaImpl() {
		t = em.getTransaction();
	}

	@Override
	public EnvasadoProveedorLata getEnvasadoProveedorLata(Integer id) {
		return (EnvasadoProveedorLata)getObject(EnvasadoProveedorLata.class, id);
	}

	@Override
	public List<EnvasadoProveedorLata> getEnvasadoProveedorLata() {
		return getObjects(EnvasadoProveedorLata.class);
	}
	
}
