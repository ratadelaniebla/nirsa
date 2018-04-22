package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Cuartochillroom;
import com.nw.model.dao.CuartochillroomDAO;

public class CuartochillroomDAOJpaImpl extends BaseDaoJpaImpl implements CuartochillroomDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public CuartochillroomDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	@Override
	public void saveorUpdate(Cuartochillroom cuartochillroom) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Cuartochillroom> getCuartochillRomm() {
		return em.createQuery("select c from Cuartochillroom c order by c.descripcion ").getResultList();
	}
	
	
}
