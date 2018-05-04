package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.nw.model.EnvasadoControlPesoFillCabecera;
import com.nw.model.dao.EnvasadoControlPesoFillCabeceraDAO;

public class EnvasadoControlPesoFillCabeceraDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoControlPesoFillCabeceraDAO {

	private EntityTransaction t;
	
	public EnvasadoControlPesoFillCabeceraDAOJpaImpl(){
		t = em.getTransaction();
	}
	
	public EnvasadoControlPesoFillCabecera updateEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		EnvasadoControlPesoFillCabecera ecpfc = null;
		try {
			
			t.begin();
			ecpfc =	em.merge(envasadoControlPesoFillCabecera);
			t.commit();
			
			return ecpfc;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public EnvasadoControlPesoFillCabecera getByProduccionTurnoOrden(Long idenvasadoproceso, Integer idproducciondetalleorden) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoFillCabecera e "
					+ "WHERE e.envasadoProceso.idenvasadoproceso = :idenvasadoproceso "
					+ "AND e.produccionDetalleOrden.idproducciondetalleorden= :idproducciondetalleorden	";
			return (EnvasadoControlPesoFillCabecera) em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.setParameter("idproducciondetalleorden", idproducciondetalleorden)
					.getSingleResult();
		} catch( NoResultException e) {
			return new EnvasadoControlPesoFillCabecera();
		} catch( Exception e) {
			e.printStackTrace();
			return new EnvasadoControlPesoFillCabecera();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoControlPesoFillCabecera> getByProduccion(Long idenvasadoproceso) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoFillCabecera e "
					+ "WHERE e.envasadoProceso.idenvasadoproceso = :idenvasadoproceso ";
			return em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.getResultList();
		} catch( NoResultException e) {
			return new ArrayList<EnvasadoControlPesoFillCabecera>();
		} catch( Exception e) {
			e.printStackTrace();
			return new ArrayList<EnvasadoControlPesoFillCabecera>();
		}
	}
	
	public boolean eliminaEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera ecpfc) {
		
		try {
			t.begin();
			if (!em.contains(ecpfc))
				em.remove(em.merge(ecpfc));
			else
				em.remove(ecpfc);
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
