package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.EnvasadoControlNetoCorteDetalle;
import com.nw.model.dao.EnvasadoControlNetoCorteDetalleDAO;

public class EnvasadoControlNetoCorteDetalleDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoControlNetoCorteDetalleDAO {
	private EntityTransaction t;
	
	public EnvasadoControlNetoCorteDetalleDAOJpaImpl(){
		t = em.getTransaction();
	}
	
	public boolean eliminaTodos(List<EnvasadoControlNetoCorteDetalle> listECNCD) {
		try {
			t.begin();
			
			for (EnvasadoControlNetoCorteDetalle ecncd : listECNCD) {
				if (!em.contains(ecncd))
					em.remove(em.merge(ecncd));
				else
					em.remove(ecncd);
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
	
	public boolean elimina(EnvasadoControlNetoCorteDetalle ecncd) {
		
		try {
			t.begin();
			
			if (!em.contains(ecncd))
				em.remove(em.merge(ecncd));
			else
				em.remove(ecncd);
			
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
