package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;

public class ProduccionDetalleOrdenDAOJpaImpl extends BaseDaoJpaImpl implements ProduccionDetalleOrdenDAO{

	public boolean saveObject(ProduccionDetalleOrden produccionDetalleOrden) {

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(produccionDetalleOrden);// merge
			t.commit();
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) { // isActive()
				t.rollback();
			}
			return false;
		} finally {
//			em.close();
		}
	}
	
	@Override
	public void updateObject(ProduccionDetalleOrden produccionDetalleOrden) {

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(produccionDetalleOrden);// merge
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) { // isActive()
				t.rollback();
			}
		} finally {
//			em.close();
		}
	}
	
	public ProduccionDetalleOrden existeDetalleOrden(Integer idturno, Long idproduccion, Integer item, String orden) {
		String sql = "SELECT a FROM ProduccionDetalleOrden a "
				+ " where a.turno.idturno = :idturno "
				+ " and a.produccion.idproduccion = :idproduccion"
				+ " and a.item = :item"
				+ " and a.orden = :orden ";
		return (ProduccionDetalleOrden) em.createQuery(sql)
				.setParameter("idturno", idturno)
				.setParameter("idproduccion", idproduccion)
				.setParameter("item", item).setParameter("orden", orden)
				.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleOrden> obtieneDetalleOrdenByProduccionTurno(Integer idturno, Long idproduccion) {
		String sql = "SELECT a FROM ProduccionDetalleOrden a "
				+ " where a.turno.idturno = :idturno "
				+ " and a.produccion.idproduccion = :idproduccion"
				+ " order by a.item, a.orden";
		return em.createQuery(sql)
				.setParameter("idturno", idturno)
				.setParameter("idproduccion", idproduccion)
				.getResultList();
	}
	
	public ProduccionDetalleOrden obtieneDetalleOrdenById(Integer idproducciondetalleorden) {
		String sql = "SELECT a FROM ProduccionDetalleOrden a "
				+ " where a.idproducciondetalleorden = :idproducciondetalleorden ";
		return (ProduccionDetalleOrden)em.createQuery(sql)
				.setParameter("idproducciondetalleorden", idproducciondetalleorden)
				.getSingleResult();
	}
}
