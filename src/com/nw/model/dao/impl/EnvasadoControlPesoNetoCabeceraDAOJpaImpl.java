package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.nw.model.EnvasadoControlPesoNetoCabecera;
import com.nw.model.EnvasadoControlPesoNetoDetalle;
import com.nw.model.dao.EnvasadoControlPesoNetoCabeceraDAO;

public class EnvasadoControlPesoNetoCabeceraDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoControlPesoNetoCabeceraDAO {

	private EntityTransaction t;
	
	public EnvasadoControlPesoNetoCabeceraDAOJpaImpl(){
		t = em.getTransaction();
	}
	
	public EnvasadoControlPesoNetoCabecera updateEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		EnvasadoControlPesoNetoCabecera ecpfc = null;
		try {
			
			t.begin();
			List<EnvasadoControlPesoNetoDetalle> listaEcpnd = new ArrayList<EnvasadoControlPesoNetoDetalle>();
			for(EnvasadoControlPesoNetoDetalle ecpnd : envasadoControlPesoNetoCabecera.getEnvasadoControlPesoNetoDetalles())
				listaEcpnd.add(em.merge(ecpnd));
			envasadoControlPesoNetoCabecera.setEnvasadoControlPesoNetoDetalles(listaEcpnd);
			ecpfc =	em.merge(envasadoControlPesoNetoCabecera);
			t.commit();
			
			return ecpfc;
		} catch(Exception e) {
			e.printStackTrace();
			try {t.rollback();}catch(Exception e1) {e1.printStackTrace();}
			
			return null;
		}
	}
	
	public EnvasadoControlPesoNetoCabecera getByProduccionTurnoOrden(Long idenvasadoproceso, Integer idproducciondetalleorden) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoNetoCabecera e "
					+ "WHERE e.envasadoProceso.idenvasadoproceso = :idenvasadoproceso "
					+ "AND e.produccionDetalleOrden.idproducciondetalleorden= :idproducciondetalleorden	";
			return (EnvasadoControlPesoNetoCabecera) em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.setParameter("idproducciondetalleorden", idproducciondetalleorden)
					.getSingleResult();
		} catch( NoResultException e) {
			return new EnvasadoControlPesoNetoCabecera();
		} catch( Exception e) {
			e.printStackTrace();
			return new EnvasadoControlPesoNetoCabecera();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoControlPesoNetoCabecera> getByEnvasadoproceso(Long idenvasadoproceso) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoNetoCabecera e "
					+ "WHERE e.envasadoProceso.idenvasadoproceso = :idenvasadoproceso ";
			return em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.getResultList();
		} catch( NoResultException e) {
			return new ArrayList<EnvasadoControlPesoNetoCabecera>();
		} catch( Exception e) {
			e.printStackTrace();
			return new ArrayList<EnvasadoControlPesoNetoCabecera>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoControlPesoNetoCabecera> getByOrdenProduccion(Long idproduccion) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoNetoCabecera e "
					+ "WHERE e.produccionDetalleOrden.produccion.idproduccion = :idproduccion ";
			return em
					.createQuery(sql)
					.setParameter("idproduccion", idproduccion)
					.getResultList();
		} catch( NoResultException e) {
			return new ArrayList<EnvasadoControlPesoNetoCabecera>();
		} catch( Exception e) {
			e.printStackTrace();
			return new ArrayList<EnvasadoControlPesoNetoCabecera>();
		}
	}
	
	public boolean eliminaEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera ecpfc) {
		
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
