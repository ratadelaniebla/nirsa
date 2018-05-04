package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.nw.model.EnvasadoControlNetoCorteCabecera;
import com.nw.model.EnvasadoControlNetoCorteDetalle;
import com.nw.model.dao.EnvasadoControlNetoCorteCabeceraDAO;

public class EnvasadoControlNetoCorteCabeceraDAOJpaImpl extends BaseDaoJpaImpl
		implements EnvasadoControlNetoCorteCabeceraDAO {

	private EntityTransaction t;

	public EnvasadoControlNetoCorteCabeceraDAOJpaImpl() {
		t = em.getTransaction();
	}

	public EnvasadoControlNetoCorteCabecera updateEnvasadoControlNetoCorteCabecera(
			EnvasadoControlNetoCorteCabecera envasadoControlNetoCorteCabecera) {
		EnvasadoControlNetoCorteCabecera ecncc = null;
		try {
			List<EnvasadoControlNetoCorteDetalle> listaEcncd = new ArrayList<EnvasadoControlNetoCorteDetalle>();
			t.begin();
			
			if (t.isActive()){
		        System.out.println("IS ACTIVE");
		    } else {
		        System.out.println("NO ACTIVE");
		    }
			
			if (envasadoControlNetoCorteCabecera.getIdenvasadocontrolnetocortecabecera()!=null) {
				for (EnvasadoControlNetoCorteDetalle ecfcd: envasadoControlNetoCorteCabecera.getEnvasadoControlNetoCorteDetalles())
					listaEcncd.add(em.merge(ecfcd));
				
				if (!listaEcncd.isEmpty()) {
					envasadoControlNetoCorteCabecera.getEnvasadoControlNetoCorteDetalles().clear();
					envasadoControlNetoCorteCabecera.setEnvasadoControlNetoCorteDetalles(listaEcncd);
				}
			}
			ecncc = em.merge(envasadoControlNetoCorteCabecera);
			t.commit();

			return ecncc;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public EnvasadoControlNetoCorteCabecera obtieneByIdEnvasadoProceso(Long idenvasadoproceso) {
		try {
			String sql = "SELECT a FROM EnvasadoControlNetoCorteCabecera a WHERE a.envasadoProceso.idenvasadoproceso = :idenvasadoproceso ";
			
			return (EnvasadoControlNetoCorteCabecera) em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.getSingleResult();
			
		} catch( NoResultException e) {
			return new EnvasadoControlNetoCorteCabecera();
		} catch( Exception e) {
			e.printStackTrace();
			return new EnvasadoControlNetoCorteCabecera();
		}
	
	}

}
