package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

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
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoControlPesoFillDetalle> obtieneByIdEnvasadoControlPesoFillDetalle(Long idenvasadocontrolpesofillcabecera) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoFillDetalle e "
					+ "WHERE e.envasadoControlPesoFillCabecera.idenvasadocontrolpesofillcabecera = :idenvasadocontrolpesofillcabecera ";
			return em
					.createQuery(sql)
					.setParameter("idenvasadocontrolpesofillcabecera", idenvasadocontrolpesofillcabecera)
					.getResultList();
		} catch( NoResultException e) {
			return new ArrayList<EnvasadoControlPesoFillDetalle>();
		} catch( Exception e) {
			e.printStackTrace();
			return new ArrayList<EnvasadoControlPesoFillDetalle>();
		}
	}

	@SuppressWarnings("unchecked")
	public List<EnvasadoControlPesoFillDetalle> obtieneByEnvasadoControlPesoFillDetalleByCorte(Long idenvasadocontrolfillcortedetalle, Long idenvasadocontrolpesofillcabecera) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoFillDetalle e "
					+ "WHERE e.envasadoControlFillCorteDetalle.idenvasadocontrolfillcortedetalle = :idenvasadocontrolfillcortedetalle "
					+ "AND e.envasadoControlPesoFillCabecera.idenvasadocontrolpesofillcabecera = :idenvasadocontrolpesofillcabecera";
			return em
					.createQuery(sql)
					.setParameter("idenvasadocontrolfillcortedetalle", idenvasadocontrolfillcortedetalle)
					.setParameter("idenvasadocontrolpesofillcabecera", idenvasadocontrolpesofillcabecera)
					.getResultList();
		} catch( NoResultException e) {
			return new ArrayList<EnvasadoControlPesoFillDetalle>();
		} catch( Exception e) {
			e.printStackTrace();
			return new ArrayList<EnvasadoControlPesoFillDetalle>();
		}
	}
}
