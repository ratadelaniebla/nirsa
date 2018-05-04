package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.nw.model.EnvasadoControlFillCorteCabecera;
import com.nw.model.EnvasadoControlFillCorteDetalle;
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
			List<EnvasadoControlFillCorteDetalle> listaEcfcd = new ArrayList<EnvasadoControlFillCorteDetalle>();
			t.begin();
			for (EnvasadoControlFillCorteDetalle ecfcd: envasadoControlFillCorteCabecera.getEnvasadoControlFillCorteDetalles()) {
				listaEcfcd.add(em.merge(ecfcd));
			}
			if (!listaEcfcd.isEmpty()) {
				envasadoControlFillCorteCabecera.getEnvasadoControlFillCorteDetalles().clear();
				envasadoControlFillCorteCabecera.setEnvasadoControlFillCorteDetalles(listaEcfcd);
			}
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
			String sql = "SELECT a FROM EnvasadoControlFillCorteCabecera a WHERE a.envasadoProceso.idenvasadoproceso = :idenvasadoproceso ";
			
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
