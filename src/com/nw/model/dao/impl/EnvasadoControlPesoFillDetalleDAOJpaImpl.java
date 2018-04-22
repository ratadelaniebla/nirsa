package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;

import com.nw.model.EnvasadoControlPesoFillDetalle;
import com.nw.model.dao.EnvasadoControlPesoFillDetalleDAO;

public class EnvasadoControlPesoFillDetalleDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoControlPesoFillDetalleDAO{

	private EntityTransaction t;
	
	public EnvasadoControlPesoFillDetalleDAOJpaImpl(){
		t = em.getTransaction();
	}
	
	@Override
	public EnvasadoControlPesoFillDetalle updateEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
		EnvasadoControlPesoFillDetalle ecpfd = null;
		try {
			
			t.begin();
			ecpfd =	em.merge(envasadoControlPesoFillDetalle);
			t.commit();
			
			return ecpfd;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean eliminaEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle ecpfd) {
		
		try {
			t.begin();
			if (!em.contains(ecpfd))
				em.remove(em.merge(ecpfd));
			else
				em.remove(ecpfd);
			t.commit();			
			return true;
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
//			em.close();
		}
	
	
	
	}

}
