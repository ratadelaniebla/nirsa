package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;

import com.nw.model.ProduccionArchivoCargaOrden;
import com.nw.model.ProduccionArchivoCargaOrdenDetalle;
import com.nw.model.dao.ProduccionArchivoCargaOrdenDAO;

public class ProduccionArchivoCargaOrdenDAOJpaImpl extends BaseDaoJpaImpl
		implements ProduccionArchivoCargaOrdenDAO {

	public void saveObject(ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(produccionArchivoCargaOrden);// merge
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) { // isActive()
				t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	public void updateObject(ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(produccionArchivoCargaOrden);// merge
			if (!produccionArchivoCargaOrden.getProduccionArchivoCargaOrdenDetalles().isEmpty())
				for (ProduccionArchivoCargaOrdenDetalle pacod : produccionArchivoCargaOrden.getProduccionArchivoCargaOrdenDetalles())
					em.merge(pacod);
					
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
	
	public ProduccionArchivoCargaOrden archivoCargaOrdenPorID(Long idproduccionarchivocargaorden) {
		String sql = "SELECT a FROM ProduccionArchivoCargaOrden a where a.idproduccionarchivocargaorden = :idproduccionarchivocargaorden";
		return (ProduccionArchivoCargaOrden) em
				.createQuery(sql)
				.setParameter("idproduccionarchivocargaorden", idproduccionarchivocargaorden)
				.getSingleResult();
	}
}
