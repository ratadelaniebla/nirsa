package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.nw.model.EnvasadoControlFillCorteCabecera;
import com.nw.model.dao.EnvasadoControlFillCorteCabeceraDAO;

public class EnvasadoControlFillCorteCabeceraDAOJpaImpl extends BaseDaoJpaImpl
		implements EnvasadoControlFillCorteCabeceraDAO {

	private EntityTransaction t;

	public EnvasadoControlFillCorteCabeceraDAOJpaImpl() {
		t = em.getTransaction();
	}

	public EnvasadoControlFillCorteCabecera updateEnvasadoControlFillCorteCabecera(
			EnvasadoControlFillCorteCabecera envasadoControlFillCorteCabecera) {
		EnvasadoControlFillCorteCabecera ecfcc = null;
		try {

			t.begin();
			ecfcc = em.merge(envasadoControlFillCorteCabecera);
			t.commit();

			return ecfcc;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public EnvasadoControlFillCorteCabecera obtieneByIdEnvasadoProceso(Long idenvasadoproceso) {
		try {
			String sql = "SELECT a FROM EnvasadoControlFillCorteCabecera a WHERE a.idenvasadoproceso = :idenvasadoproceso ";
			
			return (EnvasadoControlFillCorteCabecera) em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.getSingleResult();
			
		} catch( NoResultException e) {
			return new EnvasadoControlFillCorteCabecera();
		} catch( Exception e) {
			e.printStackTrace();
			return new EnvasadoControlFillCorteCabecera();
		}
	
	}

}
