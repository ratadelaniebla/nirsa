package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.nw.model.EnvasadoControlPesoNetoDetalle;
import com.nw.model.dao.EnvasadoControlPesoNetoDetalleDAO;

public class EnvasadoControlPesoNetoDetalleDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoControlPesoNetoDetalleDAO{

	private EntityTransaction t;
	
	public EnvasadoControlPesoNetoDetalleDAOJpaImpl(){
		t = em.getTransaction();
	}
	
	@Override
	public EnvasadoControlPesoNetoDetalle updateEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle envasadoControlPesoNetoDetalle) {
		EnvasadoControlPesoNetoDetalle ecpnd = null;
		try {
			
			t.begin();
			ecpnd =	em.merge(envasadoControlPesoNetoDetalle);
			t.commit();
			
			return ecpnd;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean eliminaEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle ecpnd) {
		
		try {
			t.begin();
			if (!em.contains(ecpnd))
				em.remove(em.merge(ecpnd));
			else
				em.remove(ecpnd);
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
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoControlPesoNetoDetalle> obtieneByIdEnvasadoControlPesoNetoDetalle(Long idenvasadocontrolpesonetocabecera) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoNetoDetalle e "
					+ "WHERE e.envasadoControlPesoNetoCabecera.idenvasadocontrolpesonetocabecera = :idenvasadocontrolpesonetocabecera ";
			return em
					.createQuery(sql)
					.setParameter("idenvasadocontrolpesonetocabecera", idenvasadocontrolpesonetocabecera)
					.getResultList();
		} catch( NoResultException e) {
			return new ArrayList<EnvasadoControlPesoNetoDetalle>();
		} catch( Exception e) {
			e.printStackTrace();
			return new ArrayList<EnvasadoControlPesoNetoDetalle>();
		}
	}

}
