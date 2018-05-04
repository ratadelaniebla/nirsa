package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.EnvasadoControlFillCorteDetalle;
import com.nw.model.dao.EnvasadoControlFillCorteDetalleDAO;

public class EnvasadoControlFillCorteDetalleDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoControlFillCorteDetalleDAO {
	private EntityTransaction t;
	
	public EnvasadoControlFillCorteDetalleDAOJpaImpl(){
		t = em.getTransaction();
	}
	
	public boolean eliminaTodos(List<EnvasadoControlFillCorteDetalle> listECFCD) {
		try {
			t.begin();
			
			for (EnvasadoControlFillCorteDetalle ecfcd : listECFCD) {
				if (!em.contains(ecfcd))
					em.remove(em.merge(ecfcd));
				else
					em.remove(ecfcd);
			}
			
			t.commit();			
			return true;
		} catch (RuntimeException e) {
			if (t.isActive())
				t.rollback();
			e.printStackTrace();
			return false;
		} finally {
//			em.close();
		}
	}
	
	public boolean elimina(EnvasadoControlFillCorteDetalle ecfcd) {
		
		try {
			t.begin();
			
			if (!em.contains(ecfcd))
				em.remove(em.merge(ecfcd));
			else
				em.remove(ecfcd);
			
			t.commit();			
			return true;
		} catch (RuntimeException e) {
			if (t.isActive())
				t.rollback();
			e.printStackTrace();
			return false;
		} finally {
//			em.close();
		}
		
	}
	
}
